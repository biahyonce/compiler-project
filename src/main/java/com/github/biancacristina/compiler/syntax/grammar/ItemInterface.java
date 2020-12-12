package com.github.biancacristina.compiler.syntax.grammar;

import com.github.biancacristina.compiler.syntax.ParserInterface;

public interface ItemInterface {
    void setParser(ParserInterface parser);
    ItemType getType();
    String getLabel();
    void process();
}
