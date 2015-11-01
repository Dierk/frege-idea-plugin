package org.fregelang.plugin.idea;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.fregelang.plugin.idea.parser.FregeParser;
import org.fregelang.plugin.idea.psi.FregeFile;
import org.fregelang.plugin.idea.psi.FregeTypes;
import org.jetbrains.annotations.NotNull;

import java.io.Reader;

public class FregeParserDefinition implements ParserDefinition {
    
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS     = TokenSet.create(FregeTypes.END_OF_LINE_COMMENT);

    public static final IFileElementType FILE = new IFileElementType(Language.<FregeLanguage>findInstance(FregeLanguage.class));

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new FlexAdapter(new FregeLexer((Reader) null));
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }
 
    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }
 
    @NotNull
    public PsiParser createParser(final Project project) {
        return new FregeParser();
    }
 
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }
 
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new FregeFile(viewProvider);
    }
 
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }
 
    @NotNull
    public PsiElement createElement(ASTNode node) {
        return FregeTypes.Factory.createElement(node);
    }
}
