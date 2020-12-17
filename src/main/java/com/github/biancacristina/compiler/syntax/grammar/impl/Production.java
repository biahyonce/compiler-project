package com.github.biancacristina.compiler.syntax.grammar.impl;

import com.github.biancacristina.compiler.syntax.ParserInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemInterface;
import com.github.biancacristina.compiler.syntax.grammar.ItemType;
import com.github.biancacristina.compiler.syntax.tree.ParserTreeNodeInterface;
import com.github.biancacristina.compiler.syntax.tree.impl.ParserTreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class Production implements ItemInterface {
    private String label;
    private ArrayList<Sentence> orRules;
    private ParserInterface parser;
    private HashMap<String, Boolean> first;
    private HashMap<String, Boolean> follow;

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
    public ParserTreeNodeInterface process() {
        System.out.println("PROCESSING RULE < " + this.label + " > ------------------------");
        String nextTokenLabel = this.parser.getCurrentToken().getLabel();

        ParserTreeNodeInterface root = new ParserTreeNode(this.label);

        for (Sentence sentence: this.orRules) {
            if(!sentence.canProcess(nextTokenLabel)) {
                continue;
            }
            sentence.processAll(root);
            return root;
        }
        this.parser.error(nextTokenLabel);
        return null;
    }

    public void addFirst(HashMap<String, Boolean> first) {
        this.first = first;
    }

    public void addFollow(HashMap<String, Boolean> follow) {
        this.follow = follow;
    }

    public boolean isTokenInFirst(String tokenLabel) {
        System.out.println("CHECKING IF <" + tokenLabel + "> is in " + this.first.toString());
        return this.first.containsKey(tokenLabel);
    }

    public boolean isTokenInFollow(String tokenLabel) {
        return this.follow.containsKey(tokenLabel);
    }

    public void addSentence(Sentence sentence) {
        //System.out.println("add sentence: ");
        //sentence.getAll().forEach(item -> System.out.println(item.getLabel()));
        this.orRules.add(sentence);
    }

    public ArrayList<Sentence> getOrRules() {
        return orRules;
    }

    public void setParser(ParserInterface parser) {
        this.parser = parser;
        this.orRules.forEach(rule -> {
            rule.setParser(parser);
        });
    }

    public boolean canProcess(String label) {
        System.out.println("RULE <" + this.label + "> CHECK IF CAN PROCESS LABEL <" + label + ">");
        System.out.println("RULE <" + this.label + "> FIRST: " + this.first.toString());
        return this.isTokenInFirst(label);
    }

    public String toString() {
        return this.label;
    }
}
