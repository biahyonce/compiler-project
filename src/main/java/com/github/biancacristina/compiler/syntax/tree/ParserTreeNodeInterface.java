package com.github.biancacristina.compiler.syntax.tree;

import java.util.Collection;

public interface ParserTreeNodeInterface {
    String getLabel();
    void addChild(ParserTreeNodeInterface child);
    Collection<ParserTreeNodeInterface> getChildren();
}
