package org.fregelang.plugin.idea;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

public class FregeFileTypeFactory extends FileTypeFactory {
    @Override
        public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
            fileTypeConsumer.consume(FregeFileType.INSTANCE, "fr");
        }
}