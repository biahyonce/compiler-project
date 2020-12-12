package com.github.biancacristina.compiler.syntax.grammar.impl;

import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemType;
import com.github.biancacristina.compiler.syntax.grammar.exception.SyntaxException;

import java.util.ArrayList;

public class Production implements ItemInterface {
    private String label;
    private ArrayList<Sentence> orRules;

    public Production(String label) {
        this.label = label;
        this.orRules = new ArrayList<>();
    }

    @Override
    public ItemType getType() {
        return ItemType.NON_TERMINAL;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public void process() {
        // TODO: check first
        for (Sentence sentence: this.orRules) {
            String nextTokenLabel = ""; // TODO: label of next token
            if(!sentence.canProcess(nextTokenLabel)) {
                continue;
            }
            sentence.processAll();
            // TODO: check follow
            return;
        }
        this.error();
    }

    public void addSentence(Sentence sentence) {
        this.orRules.add(sentence);
    }

    public ArrayList<Sentence> getOrRules() {
        return orRules;
    }

    public void error() throws SyntaxException{
        throw new SyntaxException("Syntax Error after <" + this.label + "> rule.");
    }
}
