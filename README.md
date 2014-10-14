First stab at an IntelliJIdea plugin for the [Frege](http://www.frege-lang.org) programming language.

Currently it is a mere adaption of the "properties" grammar example in
the [Custom Language Support Tutorial](http://confluence.jetbrains.com/display/IntelliJIDEA/Custom+Language+Support)
covering code highlighting and a color settings page.

The bnf only lists the tokens such that the parser generation works.

The lexer is copied from [the haskell plugin](http://github.com/Atsky/haskell-idea-plugin)
with only few modifications. More will be needed.
