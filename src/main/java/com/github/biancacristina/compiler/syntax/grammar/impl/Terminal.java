package com.github.biancacristina.compiler.syntax.grammar.impl;

import com.github.biancacristina.compiler.lexical.Lexer;
import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemType;

public class Terminal implements ItemInterface {
    private String label;
    private Lexer lexer;

    public Terminal(String label, Lexer lexer) {
        this.label = label;
        this.lexer = lexer;
    }

    @Override
    public ItemType getType() {
        return ItemType.TERMINAL;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public void process() {
        // TODO: eat current token with label this.label
    }
}
