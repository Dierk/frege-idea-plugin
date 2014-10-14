// This is a generated file. Not intended for manual editing.
package org.fregelang.plugin.idea.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.fregelang.plugin.idea.psi.FregeTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.fregelang.plugin.idea.psi.*;

public class FregePropertyImpl extends ASTWrapperPsiElement implements FregeProperty {

  public FregePropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof FregeVisitor) ((FregeVisitor)visitor).visitPsiElement(this);
    else super.accept(visitor);
  }

}
