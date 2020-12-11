package com.github.biancacristina.syntax.analysis.request;

import com.github.biancacristina.syntax.analysis.structure.ProcedureVertex;
import com.github.biancacristina.syntax.analysis.structure.SymbolVertex;
import com.github.biancacristina.syntax.analysis.structure.Vertex;

public class VertexRequest {
    private String label;

    public VertexRequest(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public Vertex toVertex() {
        if (isProcedureVertex(this.label)) {
            return new ProcedureVertex(this.label);
        } else {
            return new SymbolVertex(this.label);
        }
    }

    private boolean isProcedureVertex(String label) {
        return Character.isUpperCase(label.charAt(0));
    }
}
