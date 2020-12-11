package com.github.biancacristina.syntax.analysis.structure;

public abstract class Vertex {
    private String label;
    private Vertex nextVertex;

    public Vertex(String label) {
        this.label = label;
    }

    public abstract void process(String symbol);

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
