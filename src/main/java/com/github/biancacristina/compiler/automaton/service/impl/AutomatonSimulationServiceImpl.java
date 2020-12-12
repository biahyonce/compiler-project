package com.github.biancacristina.compiler.automaton.service.impl;

import com.github.biancacristina.compiler.lexical.impl.LexerImpl;
import com.github.biancacristina.compiler.lexical.exception.LexerException;
import com.github.biancacristina.compiler.automaton.service.AutomatonCreationService;
import com.github.biancacristina.compiler.automaton.service.AutomatonSimulationService;
import com.github.biancacristina.compiler.automaton.Automaton;

public class AutomatonSimulationServiceImpl implements AutomatonSimulationService {
    AutomatonCreationService automatonCreationService = new AutomatonCreationServiceImpl();

    @Override
    public void simulate(String s) {
        Automaton automaton = automatonCreationService.create();
        LexerImpl buffer = new LexerImpl(automaton, s);

        try {
        while(buffer.hasToken()) {
        	System.out.println("Accepted token: " + buffer.getNextToken());
        }
        }catch(LexerException e) {
        	System.out.println(e.getMessage());
        	System.out.println("Compilation ended with errors.");
        	return;
        }
        
        System.out.println("Compilation completed without errors!");
    }
}