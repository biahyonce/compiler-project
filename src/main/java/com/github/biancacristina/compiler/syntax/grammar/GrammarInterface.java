package com.github.biancacristina.compiler.syntax.grammar;

import com.github.biancacristina.compiler.syntax.ParserInterface;

public interface GrammarInterface {
    boolean hasItem(String label);
    ItemInterface get(String label);
    void put(ItemInterface item);
    void setParser(ParserInterface parser);
    ItemInterface getFirstRule();
}
