package com.github.biancacristina.syntax.analysis.structure;

import java.util.Stack;

public abstract class Vertex {
    private String label;
    private Vertex nextVertex;

    public Vertex(String label) {
        this.label = label;
    }

    public abstract void process(Stack<Token> stack, SyntacticGraph syntacticGraph);

    public boolean hasNextVertex() {
        return this.nextVertex != null;
    }

    public String getLabel() {
        return label;
    }

    public Vertex getNextVertex() {
        return nextVertex;
    }

    public void setNextVertex(Vertex nextVertex) {
        this.nextVertex = nextVertex;
    }
}
