package org.fregelang.plugin.idea;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.fregelang.plugin.idea.psi.FregeTypes;
import com.intellij.psi.TokenType;


import java.util.*;
import com.intellij.lexer.*;
import com.intellij.psi.*;

%%

%class FregeLexer
%implements FlexLexer
%unicode

%{
    private int commentStart;
    private int commentDepth;
%}


%function advance
%type IElementType


%xstate BLOCK_COMMENT, TEX

unispace    = \x05
white_no_nl = [\ \r\t\f]|{unispace}
whitechar   = {white_no_nl}|[\n]
tab         = \t

ascdigit  = [0-9]
unidigit  = \x03
decdigit  = {ascdigit}
digit     = {ascdigit}|{unidigit}

special   = [\(\)\,\;\[\]\`\{\}]
ascsymbol = [\!\#\$\%\&\*\+\.\/\<\=\>\?\@\\\^\|\-\~]
symbol    = {ascsymbol}

large     = [:uppercase:]
ascsmall  = [:lowercase:]
ascLarge  =	[A-Z]
small     = {ascsmall}|"_"

graphic   = {small}|{large}|{symbol}|{digit}|{special}|[\:\"\']

octit     = [0-7]
hexit     = {decdigit}|[A-Fa-f]
symchar   = {symbol}|[\:]
nl        = [\n\r]
idchar      = {small}|{large}|{digit}|[\']

pragmachar = [$small $large $digit]

docsym      = [\| \^ \* \$]



//----- Strings --------

gap        = \\{whitechar}*\\
cntrl      = {ascLarge} | [@\[\\\]\^_]
charesc    = [abfnrtv\\\"\'&]
ascii      = ("^"{cntrl})|(NUL)|(SOH)|(STX)|(ETX)|(EOT)|(ENQ)|(ACK)|(BEL)|(BS)|(HT)|(LF)|(VT)|(FF)|(CR)|(SO)|(SI)|(DLE)|(DC1)|(DC2)|(DC3)|(DC4)|(NAK)|(SYN)|(ETB)|(CAN)|(EM)|(SUB)|(ESC)|(FS)|(GS)|(RS)|(US)|(SP)|(DEL)
escape     = \\({charesc}|{ascii}|({decdigit}+)|(o({octit}+))|(x({hexit}+)))

character  = (\'([^\'\\\n]|{escape})\')
string     = \"([^\"\\\n]|{escape}|{gap})*(\"|\n)

//----- Indent -------

EOL_COMMENT = "--"[^\n]*



%%

<TEX> {
    [^\\]+            { return FregeTypes.BLOCK_COMMENT; }
    "\\begin{code}"   { yybegin(YYINITIAL); return FregeTypes.BLOCK_COMMENT; }
    \\+*              { return FregeTypes.BLOCK_COMMENT; }

}


<BLOCK_COMMENT> {
    "{-" {
         commentDepth++;
    }

    <<EOF>> {
        int state = yystate();
        yybegin(YYINITIAL);
        zzStartRead = commentStart;
        return FregeTypes.BLOCK_COMMENT;
    }

    "-}" {
        if (commentDepth > 0) {
            commentDepth--;
        }
        else {
             int state = yystate();
             yybegin(YYINITIAL);
             zzStartRead = commentStart;
             return FregeTypes.BLOCK_COMMENT;
        }
    }

    .|{whitechar} {}
}

"{-" {
    yybegin(BLOCK_COMMENT);
    commentDepth = 0;
    commentStart = getTokenStart();
}


{white_no_nl}+        { return TokenType.WHITE_SPACE; }
"\n"                  { return FregeTypes.NEW_LINE; }
{EOL_COMMENT}         { return FregeTypes.END_OF_LINE_COMMENT; }
"{"                   { return FregeTypes.LEFT_BRACE; }
"}"                   { return FregeTypes.RIGHT_BRACE; }
"["                   { return FregeTypes.LEFT_BRACKET; }
"]"                   { return FregeTypes.RIGHT_BRACKET; }
"("                   { return FregeTypes.LEFT_PAREN; }
")"                   { return FregeTypes.RIGHT_PAREN; }
":"                   { return FregeTypes.COLON;}
"::"                  { return FregeTypes.DOUBLE_COLON; }
";"                   { return FregeTypes.SEMICOLON;}
"."                   { return FregeTypes.DOT; }
".."                  { return FregeTypes.DOT_DOT; }
"$"                   { return FregeTypes.DOLLAR; }
","                   { return FregeTypes.COMMA; }
"="                   { return FregeTypes.EQUALS; }
"|"                   { return FregeTypes.VERTICAL_BAR;}
"\\"                  { return FregeTypes.BACK_SLASH; }
"<-"                  { return FregeTypes.LEFT_ARROW; }
(->)|(\u2192)         { return FregeTypes.RIGHT_ARROW; }

"?"                   { return FregeTypes.QUESTION; }
"#"                   { return FregeTypes.HASH; }
"@"                   { return FregeTypes.AT; }
"~"                   { return FregeTypes.TILDE; }
"`"                   { return FregeTypes.BACKQUOTE; }
"=>"                  { return FregeTypes.DOUBLE_ARROW; }
"!"                   { return FregeTypes.EXCLAMATION; }
"_"                   { return FregeTypes.UNDERSCORE; }
":"{symbol}+          { return FregeTypes.OPERATOR_CONS; }
{symbol}+             { return FregeTypes.OPERATOR_ID; }

// - Keywords

"as"                  { return FregeTypes.AS_KW; }
"case"                { return FregeTypes.CASE_KW; }
"class"               { return FregeTypes.CLASS_KW; }
"data"                { return FregeTypes.DATA_KW; }
"default"             { return FregeTypes.DEFAULT_KW; }
"do"                  { return FregeTypes.DO_KW; }
"else"                { return FregeTypes.ELSE_KW; }
"export"              { return FregeTypes.EXPORT; }
"hiding"              { return FregeTypes.HIDING_KW; }
"if"                  { return FregeTypes.IF_KW; }
"import"              { return FregeTypes.IMPORT_KW; }
"in"                  { return FregeTypes.IN_KW; }
"infix"               { return FregeTypes.INFIX_KW; }
"infixl"              { return FregeTypes.INFIXL_KW; }
"infixr"              { return FregeTypes.INFIXR_KW; }
"instance"            { return FregeTypes.INSTANCE_KW; }
("forall")|(\u2200)   { return FregeTypes.FORALL_KW; }
"foreign"             { return FregeTypes.FOREIGN_KW; }
"let"                 { return FregeTypes.LET_KW; }
"module"              { return FregeTypes.MODULE_KW; }
"of"                  { return FregeTypes.OF_KW; }
"then"                { return FregeTypes.THEN_KW; }
"qualified"           { return FregeTypes.QUALIFIED_KW; }
"safe"                { return FregeTypes.SAFE; }
"type"                { return FregeTypes.TYPE_KW; }
"unsafe"              { return FregeTypes.UNSAFE; }
"where"               { return FregeTypes.WHERE_KW; }
"{-#".*"#-}"          { return FregeTypes.PRAGMA; }
(0(o|O){octit}*) |
(0(x|X){hexit}*) |
({digit}+)            { return FregeTypes.NUMBER; }

{character}           { return FregeTypes.CHARACTER; }
{string}              { return FregeTypes.STRING;}

"\\end{code}"         { yybegin(TEX); return FregeTypes.BLOCK_COMMENT; }

"''"                  { return FregeTypes.TH_TY_QUOTE; }
"'"                   { return FregeTypes.TH_VAR_QUOTE; }
{large}{idchar}*      { return FregeTypes.TYPE_OR_CONS;}
{small}{idchar}*      { return FregeTypes.ID; }
.                     { return TokenType.BAD_CHARACTER; }