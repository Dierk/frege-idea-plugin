package org.fregelang.plugin.idea;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class FregeLexerAdapter extends FlexAdapter {
    public FregeLexerAdapter() {
        super(new FregeLexer((Reader) null));
    }
}
