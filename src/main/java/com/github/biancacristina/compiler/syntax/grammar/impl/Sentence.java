package com.github.biancacristina.compiler.syntax.grammar.impl;

import com.github.biancacristina.compiler.syntax.ParserInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;
import com.github.biancacristina.compiler.syntax.grammar.exception.SyntaxException;
import com.github.biancacristina.compiler.syntax.tree.ParserTreeNodeInterface;

import java.util.ArrayList;

public class Sentence {
    private ArrayList<ItemInterface> concatenation;
    private ParserInterface parser;

    public Sentence(){
        this.concatenation = new ArrayList<ItemInterface>();
    }

    public void add(ItemInterface item) {
        this.concatenation.add(item);
    }

    public void processAll(ParserTreeNodeInterface root) {
        System.out.printf("\nPROCESS SENTENCE: ");
        this.concatenation.forEach(item -> System.out.printf(" <" + item.getLabel() + ">,"));
        System.out.printf(" end-sentence\n\n");
        for(ItemInterface item: this.concatenation) {
            String currentTokenLabel = this.parser.getCurrentToken().getLabel();
            if(!item.canProcess(currentTokenLabel)) {
                this.parser.error(currentTokenLabel);
            }
            root.addChild(item.process());
        }
    }

    public ArrayList<ItemInterface> getAll() {
        return this.concatenation;
    }

    public boolean canProcess(String label) {
        System.out.println("SENTENCE Check if it can process token with label <" + label + ">");
        if(this.concatenation.size() > 0) {
            return this.concatenation.get(0).canProcess(label);
        }
        return true;
    }

    public void setParser(ParserInterface parser) {
        this.parser = parser;
    }
}
