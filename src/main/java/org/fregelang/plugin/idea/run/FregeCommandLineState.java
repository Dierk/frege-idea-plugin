package org.fregelang.plugin.idea.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.KillableColoredProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.ide.highlighter.JavaClassFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.*;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Represents a Command that gets executed for compiling and executing Frege Code
 *
 * @author rahulsom
 */
public class FregeCommandLineState extends CommandLineState {
  private FregeRunConfiguration runConfiguration;

  public FregeCommandLineState(FregeRunConfiguration runConfiguration, ExecutionEnvironment executionEnvironment) {
    super(executionEnvironment);
    this.runConfiguration = runConfiguration;
  }

  @NotNull
  @Override
  protected ProcessHandler startProcess() throws ExecutionException {
    System.out.println("StartProcess");

    final Project project = runConfiguration.getProject();
    final ProjectRootManager projectRootManager = ProjectRootManager.getInstance(project);

    final VirtualFile[] sourceRoots = projectRootManager.getContentSourceRoots();
    final String sourcePath = getSourcePath(sourceRoots);
    final String fregeClassPath = getClassPathSource();
    final String projectOutPath = project.getBasePath() + "/out";
    final String effectiveClassPath = fregeClassPath + ":" + projectOutPath;

    /*
     * Cross compile from frege to java
     */
    ProcessHandler fregec = compile(sourcePath, ".fr", file -> new String[]{
        "java", "-Xss1m", "-jar", fregeClassPath,
        "-d", projectOutPath, "-sp", sourcePath, "-nocp", "-greek", "-j", file
    });
    if (fregec != null) return fregec;

    /*
     * Compile Java to bytecode
     */
    ProcessHandler javac = compile(projectOutPath, ".java", file -> new String[]{
        "javac", "-cp", effectiveClassPath, "-d", projectOutPath, file
    });
    if (javac != null) return javac;

    /*
     * Execute bytecode
     */
    final KillableColoredProcessHandler processHandler = new KillableColoredProcessHandler(new GeneralCommandLine(
        "java",
        "-cp", effectiveClassPath,
        runConfiguration.getClassName()
    ));
    processHandler.setShouldDestroyProcessRecursively(true);
    return processHandler;
  }

  @Nullable
  private ProcessHandler compile(String projectOutPath, String suffix, CommandFunction commandFunction) throws ExecutionException {
    final ArrayList<String> fileNames = new ArrayList<>();
    final File[] fileList = new File(projectOutPath).listFiles();
    if (fileList == null || fileList.length == 0) {
      return echo("Filelist could not be compiled");
    }
    for (File file : fileList) {
      if (file.getAbsolutePath().endsWith(suffix))
        fileNames.add(file.getAbsolutePath());
    }
    for (String file : fileNames) {
      final String[] command = commandFunction.apply(file);
      if (execProcess(command) != 0) {
        return echo("Could not compile with " + Arrays.toString(command));
      }
    }
    return null;
  }

  @NotNull
  private KillableColoredProcessHandler echo(String message) throws ExecutionException {
    return new KillableColoredProcessHandler(new GeneralCommandLine(
        "echo",
        message
    ));
  }

  public void pipe(InputStream is, OutputStream os) throws IOException {
    int n;
    byte[] buffer = new byte[1024];
    while ((n = is.read(buffer)) > -1) {
      os.write(buffer, 0, n);   // Don't allow any extra bytes to creep in, final write
    }
  }

  private int execProcess(String[] command) {
    try {
      final Process process = new ProcessBuilder(command).start();
      process.waitFor();
      pipe(process.getErrorStream(), System.err);
      pipe(process.getInputStream(), System.out);
      return process.exitValue();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return -1;
  }

  @NotNull
  private String getSourcePath(VirtualFile[] sourceRoots) {
    String sourcePath = "";
    for (VirtualFile sourceRoot : sourceRoots) {
      if (sourcePath.length() > 0) {
        sourcePath += ":";
      }
      sourcePath += sourceRoot.getPath();
    }
    return sourcePath;
  }

  /**
   * Gets the classpath of the frege compiler
   *
   * @return classpath of the frege compiler
   */
  private String getClassPathSource() {
    final Project project = runConfiguration.getProject();
    final FileBasedIndex fileBasedIndex = FileBasedIndex.getInstance();
    final Collection<VirtualFile> containingFiles = fileBasedIndex.getContainingFiles(
        FileTypeIndex.NAME, JavaClassFileType.INSTANCE, GlobalSearchScope.allScope(project));
    final ProjectFileIndex fileIndex = ProjectRootManager.getInstance(project).getFileIndex();

    String defaultJarPath = "/usr/local/Cellar/frege/3.22.524-gcc99d7e/libexec/frege3.22.524-gcc99d7e.jar";

    String jarPathFromDependency = getFregeJarPath(containingFiles, fileIndex);
    return jarPathFromDependency == null ? defaultJarPath : jarPathFromDependency;

  }

  /**
   * Given a collection of virtual files, and a project index, find the library that contains the frege compiler.
   *
   * @param containingFiles
   * @param fileIndex
   * @return path of the frege compiler jar
   */
  @Nullable
  private String getFregeJarPath(Collection<VirtualFile> containingFiles, ProjectFileIndex fileIndex) {
    for (VirtualFile containingFile : containingFiles) {
      if (containingFile.getPath().endsWith("frege/compiler/Main.class")) {
        for (OrderEntry orderEntry : fileIndex.getOrderEntriesForFile(containingFile)) {
          String file = getPathFromOrderEntry(orderEntry);
          if (file != null) return file;
        }
      }
    }
    return null;
  }

  /**
   * Given an orderEntry, checks if it represents a library, and if it does, returns the location of the jar
   *
   * @param orderEntry
   * @return path of the jar represented by the orderEntry
   */
  @Nullable
  private String getPathFromOrderEntry(OrderEntry orderEntry) {
    if (orderEntry instanceof LibraryOrderEntry) {
      final LibraryOrderEntry libraryOrderEntry = (LibraryOrderEntry) orderEntry;
      final Library library = libraryOrderEntry.getLibrary();
      if (library == null) {
        return null;
      }
      final VirtualFile[] files = library.getFiles(OrderRootType.CLASSES);
      if (files.length == 1) {
        VirtualFile file = files[0];
        return file.getPath().replaceAll("!/$", "");
      }
    }
    return null;
  }

  interface CommandFunction {
    @NotNull
    String[] apply(@NotNull String file);
  }
}
