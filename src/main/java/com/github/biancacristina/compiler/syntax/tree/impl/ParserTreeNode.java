package com.github.biancacristina.compiler.syntax.tree.impl;

import com.github.biancacristina.compiler.syntax.tree.ParserTreeNodeInterface;

import java.util.ArrayList;
import java.util.Collection;

public class ParserTreeNode implements ParserTreeNodeInterface {
    private String label;
    private ArrayList<ParserTreeNodeInterface> children;

    public ParserTreeNode(String label) {
        this.label = label;
        this.children = new ArrayList<ParserTreeNodeInterface>();
    }

    public String getLabel() {
        return this.label;
    }

    public void addChild(ParserTreeNodeInterface child) {
        this.children.add(child);
    }

    public Collection<ParserTreeNodeInterface> getChildren() {
        return this.children;
    }
}
