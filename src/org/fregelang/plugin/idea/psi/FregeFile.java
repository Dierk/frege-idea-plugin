package org.fregelang.plugin.idea.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.fregelang.plugin.idea.FregeFileType;
import org.fregelang.plugin.idea.FregeLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class FregeFile extends PsiFileBase {
    public FregeFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, FregeLanguage.INSTANCE);
    }
 
    @NotNull
    @Override
    public FileType getFileType() {
        return FregeFileType.INSTANCE;
    }
 
    @Override
    public String toString() {
        return "Frege File";
    }
 
    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}