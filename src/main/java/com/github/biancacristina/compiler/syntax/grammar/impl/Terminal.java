package com.github.biancacristina.compiler.syntax.grammar.impl;

import com.github.biancacristina.compiler.syntax.ParserInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemType;

public class Terminal implements ItemInterface {
    private String label;
    private ParserInterface parser;

    public Terminal(String label, ParserInterface parser) {
        this.label = label;
        this.parser = parser;
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
        System.out.println("PROCESSING TERMINAL < " + this.label + " > ------------------------");
        this.parser.eatToken(this.label);
    }

    public void setParser(ParserInterface parser) {
        this.parser = parser;
    }

    public boolean canProcess(String label) {
        return this.label.equals(label);
    }
}
