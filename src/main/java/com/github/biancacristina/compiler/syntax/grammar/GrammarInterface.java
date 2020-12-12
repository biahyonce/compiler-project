package com.github.biancacristina.compiler.syntax.grammar;

public interface GrammarInterface {
    boolean hasItem(String label);
    ItemInterface get(String label);
    void put(ItemInterface item);
}
