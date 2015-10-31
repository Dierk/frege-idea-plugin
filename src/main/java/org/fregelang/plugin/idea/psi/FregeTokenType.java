package org.fregelang.plugin.idea.psi;

import com.intellij.psi.tree.IElementType;
import org.fregelang.plugin.idea.FregeLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class FregeTokenType extends IElementType {

    public FregeTokenType(@NotNull @NonNls String debugName) {
        super(debugName, FregeLanguage.INSTANCE);
    }
 
    @Override
    public String toString() {
        return "FregeTokenType." + super.toString();
    }
}
