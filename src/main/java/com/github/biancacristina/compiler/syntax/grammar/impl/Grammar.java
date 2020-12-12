package com.github.biancacristina.compiler.syntax.grammar.impl;

import com.github.biancacristina.compiler.syntax.grammar.GrammarInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;

import java.util.HashMap;

public class Grammar implements GrammarInterface {
    private HashMap<String, ItemInterface> rules;

    public Grammar() {
        this.rules = new HashMap<String, ItemInterface>();
        // TODO: make grammar receive an ItemFactory to create terminal and non-terminal items
    }

    private void createRule(String label) {
        // TODO add factories to create terminal and non-terminal objects
    }

    @Override
    public boolean hasItem(String label) {
        return this.rules.containsKey(label);
    }

    @Override
    public ItemInterface get(String label) {
        return this.rules.get(label);
    }

    @Override
    public void put(ItemInterface item) {
        this.rules.put(item.getLabel(), item);
    }
}
