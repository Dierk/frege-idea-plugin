package org.fregelang.plugin.idea.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FregeRunConfiguration extends RunConfigurationBase {

  private String className;

  protected FregeRunConfiguration(@NotNull Project project, @NotNull ConfigurationFactory factory, String name) {
    super(project, factory, name);
  }

  @NotNull
  @Override
  public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
    final FregeSettingsEditor fregeSettingsEditor = new FregeSettingsEditor();
    // fregeSettingsEditor.resetEditorFrom(this);
    return fregeSettingsEditor;
  }

  @Override
  public void checkConfiguration() throws RuntimeConfigurationException {
    if (className == null) {
      throw new RuntimeConfigurationException("No class specified");
    }
  }

  @Nullable
  @Override
  public RunProfileState getState(
      @NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment) throws ExecutionException {
    FregeCommandLineState state = new FregeCommandLineState(this, executionEnvironment);
    state.setConsoleBuilder(TextConsoleBuilderFactory.getInstance().createBuilder(this.getProject()));
    return state;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }
}
