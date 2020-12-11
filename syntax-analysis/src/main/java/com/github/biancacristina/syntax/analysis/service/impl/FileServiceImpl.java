package com.github.biancacristina.syntax.analysis.service.impl;

import com.github.biancacristina.syntax.analysis.exception.FileException;
import com.github.biancacristina.syntax.analysis.request.VertexRequest;
import com.github.biancacristina.syntax.analysis.service.FileService;
import com.github.biancacristina.syntax.analysis.structure.Procedure;
import com.github.biancacristina.syntax.analysis.structure.SyntacticGraph;
import com.github.biancacristina.syntax.analysis.structure.Vertex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.*;

public class FileServiceImpl implements FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
    private static final String SPLIT_REGEX = "\\s+";
    private static final String SYNTACTIC_GRAPH_FILE = "/syntactic-graph.txt";

    @Override
    public SyntacticGraph readSyntacticGraph() {
        try {
            HashMap<String, Procedure> procedures = new HashMap<>();
            InputStream inputStream = FileServiceImpl.class.getResourceAsStream(SYNTACTIC_GRAPH_FILE);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] requestString = line.split(SPLIT_REGEX);
                logger.info("Read line: " + requestString[0] + " " + requestString[1]);
                addProcedure(requestString, procedures);
            }
            return new SyntacticGraph(procedures);
        } catch (Exception e) {
            throw new FileException("Error on reading syntactic graph file", e);
        }
    }

    private void addProcedure(String[] rule, HashMap<String, Procedure> procedures) {
        Procedure procedure = getProcedureRequest(rule[0]);
        Stack<Vertex> vertices = getVertices(rule[1]);

        if (isNewProcedure(procedure, procedures)) {
            addVertexFromStack(vertices, procedure);
            procedures.put(procedure.getLabel(), procedure);
        } else {
            Procedure modifiedProcedure = procedures.get(procedure.getLabel());
            addVertexFromStack(vertices, modifiedProcedure);
            procedures.replace(procedure.getLabel(), modifiedProcedure);
        }
    }

    private boolean isNewProcedure(Procedure procedure, HashMap<String, Procedure> procedures) {
        return !procedures.containsKey(procedure.getLabel());
    }

    private void addVertexFromStack(Stack<Vertex> vertices, Procedure procedure) {
        Vertex firstVertex = vertices.pop();
        procedure.addStartVertex(firstVertex);
        while (!vertices.isEmpty()) {
            Vertex vertex = vertices.pop();
            procedure.addVertex(vertex);
        }
    }

    private Procedure getProcedureRequest(String label) {
        return new Procedure(label);
    }

    private Stack<Vertex> getVertices(String vertices) {
        Stack<Vertex> stack = new Stack<>();
        Vertex previousVertex = null;
        for (int i=vertices.length() - 1; i >= 0; i--) {
            String vertexLabel = String.valueOf(vertices.charAt(i));
            VertexRequest request = new VertexRequest(vertexLabel);
            Vertex vertex = request.toVertex();
            vertex.setNextVertex(previousVertex);
            previousVertex = vertex;
            stack.push(vertex);
        }
        return stack;
    }
}