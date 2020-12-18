package com.github.biancacristina.compiler.syntax.tree.impl;

import com.github.biancacristina.compiler.common.Counter;
import com.github.biancacristina.compiler.syntax.tree.ParserTreeInterface;
import com.github.biancacristina.compiler.syntax.tree.ParserTreeNodeInterface;

import java.util.Collection;

public class ParserTree implements ParserTreeInterface {
    private ParserTreeNodeInterface root;

    public ParserTree() {}

    public ParserTreeNodeInterface getRoot() {
        return this.root;
    }

    @Override
    public void setRoot(ParserTreeNodeInterface root) {
        this.root = root;
    }

    @Override
    public void traverse() {
        this.traversePrefix(this.root);
    }

    private void traversePrefix(ParserTreeNodeInterface root) {
        if (root == null) return;
        System.out.println("\n<" + root.getLabel() + ">");
        Collection<ParserTreeNodeInterface> children = root.getChildren();
        for (ParserTreeNodeInterface child : children) {
            this.traversePrefix(child);
        }
        System.out.println("backtrack from <" + root.getLabel() + ">\n");
    }

    public String toString() {
        return "digraph G {\n" + this.getString(this.root, Counter.getInstance().getCount(this.root.getLabel())) + "}\n";
    }

    private String getString(ParserTreeNodeInterface root, int id) {
        if (root == null) return "";
        String str = "";
        Collection<ParserTreeNodeInterface> children = root.getChildren();
        for (ParserTreeNodeInterface child : children) {
            int childId = Counter.getInstance().getCount(child.getLabel());
            str += root.getLabel() + "_" + id + " -> " + child.getLabel() + "_" + childId + ";\n";
            str += this.getString(child, childId);
        }
        return str;
    }
}
