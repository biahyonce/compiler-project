package com.github.biancacristina.compiler.syntax.grammar.impl;

import com.github.biancacristina.compiler.syntax.ParserInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemType;
import com.github.biancacristina.compiler.syntax.tree.ParserTreeNodeInterface;
import com.github.biancacristina.compiler.syntax.tree.impl.ParserTreeNode;

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
    public ParserTreeNodeInterface process() {
        System.out.println("PROCESSING TERMINAL " + this.toString() + " ------------------------");
        this.parser.eatToken(this.label);
        return new ParserTreeNode(this.label);
    }

    public void setParser(ParserInterface parser) {
        this.parser = parser;
    }

    public boolean canProcess(String label) {
        System.out.println("TERMINAL check if terminal <"
                + this.label
                + "> is compatible with token <"
                + this.parser.getCurrentToken().getLabel()
                + ","
                + this.parser.getCurrentToken().getAttribute()
                + ">"
        );
        return this.parser.canEatToken(this.label);
    }

    public String toString() {
        return "<" + this.label + ">";
    }
}
