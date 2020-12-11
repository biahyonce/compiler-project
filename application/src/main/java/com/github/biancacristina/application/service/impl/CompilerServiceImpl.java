package com.github.biancacristina.application.service.impl;

import com.github.biancacristina.application.service.CompilerService;
import com.github.biancacristina.lexical.analysis.buffer.impl.BufferImpl;
import com.github.biancacristina.lexical.analysis.exception.BufferException;
import com.github.biancacristina.lexical.analysis.service.AutomatonCreationService;
import com.github.biancacristina.lexical.analysis.service.impl.AutomatonCreationServiceImpl;
import com.github.biancacristina.lexical.analysis.structure.Automaton;
import com.github.biancacristina.lexical.analysis.structure.Token;
import com.github.biancacristina.syntax.analysis.service.FileService;
import com.github.biancacristina.syntax.analysis.service.impl.FileServiceImpl;
import com.github.biancacristina.syntax.analysis.structure.SyntacticGraph;

import java.io.InputStream;
import java.util.Scanner;

public class CompilerServiceImpl implements CompilerService {
    private Automaton automaton;
    private SyntacticGraph syntacticGraph;

    public CompilerServiceImpl() {
        AutomatonCreationService automatonCreationService = new AutomatonCreationServiceImpl();
        FileService fileService = new FileServiceImpl();
        this.automaton = automatonCreationService.create();
        this.syntacticGraph = fileService.readSyntacticGraph();
    }

    @Override   
    public String read(String fileName) {
        InputStream inputStream  = CompilerServiceImpl.class.getResourceAsStream(fileName);
        Scanner scanner = new Scanner(inputStream);
        StringBuilder fileStr = new StringBuilder();
        while(scanner.hasNextLine()) {
            fileStr.append(scanner.nextLine());
        }
        scanner.close();
        return fileStr.toString();
    }

    @Override
    public void compile(String code) {
        BufferImpl buffer = new BufferImpl(automaton, code);
        try {
            while(buffer.hasToken()) {
                Token token = buffer.getNextToken();
                this.syntacticGraph.analyze(token);
            }
        }catch(BufferException e) {
            System.out.println(e.getMessage());
            System.out.println("Compilation ended with errors.");
            return;
        }

        System.out.println("Compilation completed without errors!");
    }
}