package com.github.biancacristina.syntax.analysis.structure;

import com.github.biancacristina.syntax.analysis.exception.ProcedureException;
import com.github.biancacristina.syntax.analysis.service.impl.FileServiceImpl;

import java.util.HashMap;
import java.util.Stack;

public class SyntacticGraph {
    private HashMap<String, Procedure> procedures;

    public SyntacticGraph(HashMap<String, Procedure> procedures) {
        this.procedures = procedures;
    }

    public void addProcedure(Procedure procedure) {
        this.procedures.put(procedure.getLabel(), procedure);
    }

    public Procedure getProcedure(String label) {
        return procedures.get(label);
    }

    public void analyze(Stack<Token> stack) {
        String startProcedureLabel = "S"; // TODO: Change
        Procedure procedure = procedures.get(startProcedureLabel);
        if (procedure != null) { procedure.process(stack, this); }
        else { throw new ProcedureException("Missing start procedure label"); }
    }

    public static void main(String[] args) {
        FileServiceImpl fileService = new FileServiceImpl();
        SyntacticGraph sg = fileService.readSyntacticGraph();
        String s = "aefd";
        Stack<Token> stack = new Stack<>();
        for(int i=0; i<s.length();i++) {
            Token token = new Token(String.valueOf(s.charAt(i)));
            stack.push(token);
        }
        sg.analyze(stack);
    }
}
