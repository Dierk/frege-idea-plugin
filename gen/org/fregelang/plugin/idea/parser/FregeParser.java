// This is a generated file. Not intended for manual editing.
package org.fregelang.plugin.idea.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static org.fregelang.plugin.idea.psi.FregeTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class FregeParser implements PsiParser {

  public static final Logger LOG_ = Logger.getInstance("org.fregelang.plugin.idea.parser.FregeParser");

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    result_ = parse_root_(root_, builder_, 0);
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return simpleFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // BLOCK_COMMENT|
  //    END_OF_LINE_COMMENT|
  //    NEW_LINE |
  //    LEFT_BRACE |    
  //    RIGHT_BRACE |   
  //    LEFT_BRACKET |  
  //    RIGHT_BRACKET | 
  //    LEFT_PAREN |    
  //    RIGHT_PAREN |   
  //    COLON |         
  //    DOUBLE_COLON |  
  //    SEMICOLON |     
  //    DOT |           
  //    DOT_DOT |       
  //    DOLLAR |        
  //    COMMA |         
  //    EQUALS |        
  //    VERTICAL_BAR |  
  //    BACK_SLASH |    
  //    LEFT_ARROW |    
  //    RIGHT_ARROW |   
  //    QUESTION |      
  //    HASH |          
  //    AT |            
  //    TILDE |         
  //    BACKQUOTE |     
  //    DOUBLE_ARROW |  
  //    EXCLAMATION |   
  //    UNDERSCORE |    
  //    OPERATOR_CONS | 
  //    OPERATOR_ID |   
  //    AS_KW |         
  //    CASE_KW |       
  //    CLASS_KW |      
  //    DATA_KW |       
  //    DEFAULT_KW |    
  //    DERIVING_KW |   
  //    DO_KW |         
  //    ELSE_KW |       
  //    EXPORT |        
  //    HIDING_KW |     
  //    IF_KW |         
  //    IMPORT_KW |     
  //    IN_KW |         
  //    INFIX_KW |      
  //    INFIXL_KW |     
  //    INFIXR_KW |     
  //    INSTANCE_KW |   
  //    FORALL_KW |     
  //    FOREIGN_KW |    
  //    LET_KW |        
  //    MODULE_KW |     
  //    NEWTYPE_KW |    
  //    OF_KW |         
  //    THEN_KW |       
  //    QUALIFIED_KW |  
  //    SAFE |          
  //    TYPE_KW |       
  //    UNSAFE |        
  //    WHERE_KW |      
  //    PRAGMA |        
  //    NUMBER |        
  //    CHARACTER |     
  //    STRING |        
  //    TH_TY_QUOTE |   
  //    TH_VAR_QUOTE |  
  //    TYPE_OR_CONS |  
  //    ID
  static boolean item_(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "item_")) return false;
    boolean result_;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, BLOCK_COMMENT);
    if (!result_) result_ = consumeToken(builder_, END_OF_LINE_COMMENT);
    if (!result_) result_ = consumeToken(builder_, NEW_LINE);
    if (!result_) result_ = consumeToken(builder_, LEFT_BRACE);
    if (!result_) result_ = consumeToken(builder_, RIGHT_BRACE);
    if (!result_) result_ = consumeToken(builder_, LEFT_BRACKET);
    if (!result_) result_ = consumeToken(builder_, RIGHT_BRACKET);
    if (!result_) result_ = consumeToken(builder_, LEFT_PAREN);
    if (!result_) result_ = consumeToken(builder_, RIGHT_PAREN);
    if (!result_) result_ = consumeToken(builder_, COLON);
    if (!result_) result_ = consumeToken(builder_, DOUBLE_COLON);
    if (!result_) result_ = consumeToken(builder_, SEMICOLON);
    if (!result_) result_ = consumeToken(builder_, DOT);
    if (!result_) result_ = consumeToken(builder_, DOT_DOT);
    if (!result_) result_ = consumeToken(builder_, DOLLAR);
    if (!result_) result_ = consumeToken(builder_, COMMA);
    if (!result_) result_ = consumeToken(builder_, EQUALS);
    if (!result_) result_ = consumeToken(builder_, VERTICAL_BAR);
    if (!result_) result_ = consumeToken(builder_, BACK_SLASH);
    if (!result_) result_ = consumeToken(builder_, LEFT_ARROW);
    if (!result_) result_ = consumeToken(builder_, RIGHT_ARROW);
    if (!result_) result_ = consumeToken(builder_, QUESTION);
    if (!result_) result_ = consumeToken(builder_, HASH);
    if (!result_) result_ = consumeToken(builder_, AT);
    if (!result_) result_ = consumeToken(builder_, TILDE);
    if (!result_) result_ = consumeToken(builder_, BACKQUOTE);
    if (!result_) result_ = consumeToken(builder_, DOUBLE_ARROW);
    if (!result_) result_ = consumeToken(builder_, EXCLAMATION);
    if (!result_) result_ = consumeToken(builder_, UNDERSCORE);
    if (!result_) result_ = consumeToken(builder_, OPERATOR_CONS);
    if (!result_) result_ = consumeToken(builder_, OPERATOR_ID);
    if (!result_) result_ = consumeToken(builder_, AS_KW);
    if (!result_) result_ = consumeToken(builder_, CASE_KW);
    if (!result_) result_ = consumeToken(builder_, CLASS_KW);
    if (!result_) result_ = consumeToken(builder_, DATA_KW);
    if (!result_) result_ = consumeToken(builder_, DEFAULT_KW);
    if (!result_) result_ = consumeToken(builder_, DERIVING_KW);
    if (!result_) result_ = consumeToken(builder_, DO_KW);
    if (!result_) result_ = consumeToken(builder_, ELSE_KW);
    if (!result_) result_ = consumeToken(builder_, EXPORT);
    if (!result_) result_ = consumeToken(builder_, HIDING_KW);
    if (!result_) result_ = consumeToken(builder_, IF_KW);
    if (!result_) result_ = consumeToken(builder_, IMPORT_KW);
    if (!result_) result_ = consumeToken(builder_, IN_KW);
    if (!result_) result_ = consumeToken(builder_, INFIX_KW);
    if (!result_) result_ = consumeToken(builder_, INFIXL_KW);
    if (!result_) result_ = consumeToken(builder_, INFIXR_KW);
    if (!result_) result_ = consumeToken(builder_, INSTANCE_KW);
    if (!result_) result_ = consumeToken(builder_, FORALL_KW);
    if (!result_) result_ = consumeToken(builder_, FOREIGN_KW);
    if (!result_) result_ = consumeToken(builder_, LET_KW);
    if (!result_) result_ = consumeToken(builder_, MODULE_KW);
    if (!result_) result_ = consumeToken(builder_, NEWTYPE_KW);
    if (!result_) result_ = consumeToken(builder_, OF_KW);
    if (!result_) result_ = consumeToken(builder_, THEN_KW);
    if (!result_) result_ = consumeToken(builder_, QUALIFIED_KW);
    if (!result_) result_ = consumeToken(builder_, SAFE);
    if (!result_) result_ = consumeToken(builder_, TYPE_KW);
    if (!result_) result_ = consumeToken(builder_, UNSAFE);
    if (!result_) result_ = consumeToken(builder_, WHERE_KW);
    if (!result_) result_ = consumeToken(builder_, PRAGMA);
    if (!result_) result_ = consumeToken(builder_, NUMBER);
    if (!result_) result_ = consumeToken(builder_, CHARACTER);
    if (!result_) result_ = consumeToken(builder_, STRING);
    if (!result_) result_ = consumeToken(builder_, TH_TY_QUOTE);
    if (!result_) result_ = consumeToken(builder_, TH_VAR_QUOTE);
    if (!result_) result_ = consumeToken(builder_, TYPE_OR_CONS);
    if (!result_) result_ = consumeToken(builder_, ID);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // item_*
  static boolean simpleFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "simpleFile")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!item_(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "simpleFile", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

}
