package com.github.biancacristina.syntax.analysis.structure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Procedure {
    // TODO: Include value of stack here ?
    private static final Logger logger = LoggerFactory.getLogger(Procedure.class);
    private String label;
    private HashMap<String, Vertex> startVertices;
    private HashMap<String, Vertex> vertices;

    public Procedure(String label) {
        this.label = label;
        this.vertices = new HashMap<>();
        this.startVertices = new HashMap<>();
    }

    public void addStartVertex(Vertex vertex) {
        this.startVertices.put(vertex.getLabel(), vertex);
        logger.info("Added vertex " + vertex.getLabel() + " to procedure " + this.getLabel() + " (FIRST VERTEX)");

    }

    public void addVertex(Vertex vertex) {
        this.vertices.put(vertex.getLabel(), vertex);
        logger.info("Added vertex " + vertex.getLabel() + " to procedure " + this.getLabel());
    }

    public String getLabel() {
        return label;
    }

    public HashMap<String, Vertex> getStartVertices() {
        return startVertices;
    }

    public HashMap<String, Vertex> getVertices() {
        return vertices;
    }
}