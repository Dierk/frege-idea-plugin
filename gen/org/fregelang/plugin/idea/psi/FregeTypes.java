// This is a generated file. Not intended for manual editing.
package org.fregelang.plugin.idea.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.fregelang.plugin.idea.psi.impl.*;

public interface FregeTypes {


  IElementType AS_KW = new FregeTokenType("AS_KW");
  IElementType AT = new FregeTokenType("AT");
  IElementType BACKQUOTE = new FregeTokenType("BACKQUOTE");
  IElementType BACK_SLASH = new FregeTokenType("BACK_SLASH");
  IElementType BLOCK_COMMENT = new FregeTokenType("BLOCK_COMMENT");
  IElementType CASE_KW = new FregeTokenType("CASE_KW");
  IElementType CHARACTER = new FregeTokenType("CHARACTER");
  IElementType CLASS_KW = new FregeTokenType("CLASS_KW");
  IElementType COLON = new FregeTokenType("COLON");
  IElementType COMMA = new FregeTokenType("COMMA");
  IElementType DATA_KW = new FregeTokenType("DATA_KW");
  IElementType DEFAULT_KW = new FregeTokenType("DEFAULT_KW");
  IElementType DOLLAR = new FregeTokenType("DOLLAR");
  IElementType DOT = new FregeTokenType("DOT");
  IElementType DOT_DOT = new FregeTokenType("DOT_DOT");
  IElementType DOUBLE_ARROW = new FregeTokenType("DOUBLE_ARROW");
  IElementType DOUBLE_COLON = new FregeTokenType("DOUBLE_COLON");
  IElementType DO_KW = new FregeTokenType("DO_KW");
  IElementType ELSE_KW = new FregeTokenType("ELSE_KW");
  IElementType END_OF_LINE_COMMENT = new FregeTokenType("END_OF_LINE_COMMENT");
  IElementType EQUALS = new FregeTokenType("EQUALS");
  IElementType EXCLAMATION = new FregeTokenType("EXCLAMATION");
  IElementType EXPORT = new FregeTokenType("EXPORT");
  IElementType FORALL_KW = new FregeTokenType("FORALL_KW");
  IElementType FOREIGN_KW = new FregeTokenType("FOREIGN_KW");
  IElementType HASH = new FregeTokenType("HASH");
  IElementType HIDING_KW = new FregeTokenType("HIDING_KW");
  IElementType ID = new FregeTokenType("ID");
  IElementType IF_KW = new FregeTokenType("IF_KW");
  IElementType IMPORT_KW = new FregeTokenType("IMPORT_KW");
  IElementType INFIXL_KW = new FregeTokenType("INFIXL_KW");
  IElementType INFIXR_KW = new FregeTokenType("INFIXR_KW");
  IElementType INFIX_KW = new FregeTokenType("INFIX_KW");
  IElementType INSTANCE_KW = new FregeTokenType("INSTANCE_KW");
  IElementType IN_KW = new FregeTokenType("IN_KW");
  IElementType LEFT_ARROW = new FregeTokenType("LEFT_ARROW");
  IElementType LEFT_BRACE = new FregeTokenType("LEFT_BRACE");
  IElementType LEFT_BRACKET = new FregeTokenType("LEFT_BRACKET");
  IElementType LEFT_PAREN = new FregeTokenType("LEFT_PAREN");
  IElementType LET_KW = new FregeTokenType("LET_KW");
  IElementType MODULE_KW = new FregeTokenType("MODULE_KW");
  IElementType NEW_LINE = new FregeTokenType("NEW_LINE");
  IElementType NUMBER = new FregeTokenType("NUMBER");
  IElementType OF_KW = new FregeTokenType("OF_KW");
  IElementType OPERATOR_CONS = new FregeTokenType("OPERATOR_CONS");
  IElementType OPERATOR_ID = new FregeTokenType("OPERATOR_ID");
  IElementType PRAGMA = new FregeTokenType("PRAGMA");
  IElementType QUALIFIED_KW = new FregeTokenType("QUALIFIED_KW");
  IElementType QUESTION = new FregeTokenType("QUESTION");
  IElementType RIGHT_ARROW = new FregeTokenType("RIGHT_ARROW");
  IElementType RIGHT_BRACE = new FregeTokenType("RIGHT_BRACE");
  IElementType RIGHT_BRACKET = new FregeTokenType("RIGHT_BRACKET");
  IElementType RIGHT_PAREN = new FregeTokenType("RIGHT_PAREN");
  IElementType SAFE = new FregeTokenType("SAFE");
  IElementType SEMICOLON = new FregeTokenType("SEMICOLON");
  IElementType STRING = new FregeTokenType("STRING");
  IElementType THEN_KW = new FregeTokenType("THEN_KW");
  IElementType TH_TY_QUOTE = new FregeTokenType("TH_TY_QUOTE");
  IElementType TH_VAR_QUOTE = new FregeTokenType("TH_VAR_QUOTE");
  IElementType TILDE = new FregeTokenType("TILDE");
  IElementType TYPE_KW = new FregeTokenType("TYPE_KW");
  IElementType TYPE_OR_CONS = new FregeTokenType("TYPE_OR_CONS");
  IElementType UNDERSCORE = new FregeTokenType("UNDERSCORE");
  IElementType UNSAFE = new FregeTokenType("UNSAFE");
  IElementType VERTICAL_BAR = new FregeTokenType("VERTICAL_BAR");
  IElementType WHERE_KW = new FregeTokenType("WHERE_KW");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
