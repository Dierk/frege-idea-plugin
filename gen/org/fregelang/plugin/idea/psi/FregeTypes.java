// This is a generated file. Not intended for manual editing.
package org.fregelang.plugin.idea.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.fregelang.plugin.idea.psi.impl.*;

public interface FregeTypes {

  IElementType PROPERTY = new FregeElementType("PROPERTY");

  IElementType COMMENT = new FregeTokenType("COMMENT");
  IElementType CRLF = new FregeTokenType("CRLF");
  IElementType KEY = new FregeTokenType("KEY");
  IElementType SEPARATOR = new FregeTokenType("SEPARATOR");
  IElementType VALUE = new FregeTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new FregePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
