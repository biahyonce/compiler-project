package com.github.biancacristina.compiler.syntax.grammar;

import com.github.biancacristina.compiler.syntax.ParserInterface;
import com.github.biancacristina.compiler.syntax.tree.ParserTreeNodeInterface;

public interface ItemInterface {
    void setParser(ParserInterface parser);
    ItemType getType();
    String getLabel();
    ParserTreeNodeInterface process();
    boolean canProcess(String label);
    String toString();
}
