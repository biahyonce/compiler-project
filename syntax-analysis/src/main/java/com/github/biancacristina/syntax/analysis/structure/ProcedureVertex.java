package com.github.biancacristina.syntax.analysis.structure;

public class ProcedureVertex extends Vertex {
    // TODO: Should have some value implied with to use alongside stack -> inside procedure maybe
    public ProcedureVertex(String label) {
        super(label);
    }

    @Override
    public void process(String symbol) {}
}
