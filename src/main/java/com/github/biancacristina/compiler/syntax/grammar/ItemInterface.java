package com.github.biancacristina.compiler.syntax.grammar;

public interface ItemInterface {
    ItemType getType();
    String getLabel();
    void process();
}
