package org.fregelang.plugin.idea.psi;
 
import com.intellij.psi.tree.IElementType;
import org.fregelang.plugin.idea.FregeLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
 
public class FregeElementType extends IElementType {
    public FregeElementType(@NotNull @NonNls String debugName) {
        super(debugName, FregeLanguage.INSTANCE);
    }
}