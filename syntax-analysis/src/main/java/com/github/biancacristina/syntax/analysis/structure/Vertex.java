package com.github.biancacristina.syntax.analysis.structure;

import com.github.biancacristina.lexical.analysis.structure.Token;

public abstract class Vertex {
    private String label;
    private Vertex nextVertex;

    public Vertex(String label) {
        this.label = label;
    }

    public abstract void process(Token token, SyntacticGraph syntacticGraph);

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
