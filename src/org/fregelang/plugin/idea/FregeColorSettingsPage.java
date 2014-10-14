package org.fregelang.plugin.idea;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class FregeColorSettingsPage  implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
        new AttributesDescriptor("Line Comment", FregeSyntaxHighlighter.END_OF_LINE_COMMENT),
        new AttributesDescriptor("Block Comment", FregeSyntaxHighlighter.BLOCK_COMMENT)
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return FregeIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new FregeSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "-- line comment\n" +
               "{-\n" +
               "   multi-line comment\n" +
               "-}\n" +
               "{--\n" +
               "   multi-line doc comment\n" +
               "--}\n" +
               "module my.module.Name where\n" +
               "\n" +
               "myFun :: Num a => a -> a -> a\n" +
               "myFun x y = x * y\n";
    }
 
    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }
 
    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }
 
    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }
 
    @NotNull
    @Override
    public String getDisplayName() {
        return "Frege";
    }
}
