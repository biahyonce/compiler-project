package com.github.biancacristina.compiler.syntax.grammar.impl;

import com.github.biancacristina.compiler.syntax.ParserInterface;
import com.github.biancacristina.compiler.syntax.grammar.GrammarInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;

import java.util.HashMap;

public class Grammar implements GrammarInterface {
    private HashMap<String, ItemInterface> rules;
    private ParserInterface parser;
    private ItemInterface firstRule;

    public Grammar() {
        this.rules = new HashMap<String, ItemInterface>();
    }

    public void setParser(ParserInterface parser) {
        this.parser = parser;
        for (ItemInterface item: this.rules.values()) {
            item.setParser(this.parser);
        }
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
        if(this.rules.isEmpty()) {
            this.firstRule = item;
        }
        this.rules.put(item.getLabel(), item);
        System.out.println("Put item < " + item.getLabel() + " > on grammar");
    }

    @Override
    public ItemInterface getFirstRule() {
        return this.firstRule;
    }
}
