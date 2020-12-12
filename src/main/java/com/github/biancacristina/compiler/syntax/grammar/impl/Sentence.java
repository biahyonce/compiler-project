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
        for(ItemInterface item: this.concatenation) {
            item.process();
        }
    }

    public ArrayList<ItemInterface> getAll() {
        return this.concatenation;
    }

    // TODO
    public boolean canProcess(String labelFirst) {
        // return true if the given label if accepted by this sequence
        // basically checks if the first item of the concatenation accepts this label
        return true;
    }
}
