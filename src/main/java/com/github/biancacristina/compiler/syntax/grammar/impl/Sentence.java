package com.github.biancacristina.compiler.syntax.grammar.impl;

import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;

import java.util.ArrayList;

public class Sentence {
    private ArrayList<ItemInterface> concatenation;

    public Sentence(){
        this.concatenation = new ArrayList<ItemInterface>();
    }

    public void add(ItemInterface item) {
        this.concatenation.add(item);
    }

    public void processAll() {
        System.out.println("PROCESS SENTENCE: ");
        this.concatenation.forEach(item -> System.out.println("<" + item.getLabel() + ">"));
        for(ItemInterface item: this.concatenation) {
            item.process();
        }
    }

    public ArrayList<ItemInterface> getAll() {
        return this.concatenation;
    }

    // TODO
    public boolean canProcess(String label) {
        // return true if the given label if accepted by this sequence
        // basically checks if the first item of the concatenation accepts this label
        System.out.println("SENTENCE Check if it can process token with label <" + label + ">");
        return true;
    }
}
