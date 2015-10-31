package org.fregelang.plugin.idea;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class FregeFileType extends LanguageFileType {
    public static final FregeFileType INSTANCE = new FregeFileType();

        private FregeFileType() {
            super(FregeLanguage.INSTANCE);
        }

        @NotNull
        @Override
        public String getName() {
            return "Frege file";
        }

        @NotNull
        @Override
        public String getDescription() {
            return "Frege language file";
        }

        @NotNull
        @Override
        public String getDefaultExtension() {
            return "fr";
        }

        @Nullable
        @Override
        public Icon getIcon() {
            return FregeIcons.FILE;
        }
}
