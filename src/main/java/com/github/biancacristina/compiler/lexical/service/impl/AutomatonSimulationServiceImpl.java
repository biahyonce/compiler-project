package com.github.biancacristina.compiler.lexical.service.impl;

import com.github.biancacristina.compiler.lexical.buffer.impl.BufferImpl;
import com.github.biancacristina.compiler.lexical.exception.BufferException;
import com.github.biancacristina.compiler.lexical.service.AutomatonCreationService;
import com.github.biancacristina.compiler.lexical.service.AutomatonSimulationService;
import com.github.biancacristina.compiler.lexical.structure.Automaton;

public class AutomatonSimulationServiceImpl implements AutomatonSimulationService {
    AutomatonCreationService automatonCreationService = new AutomatonCreationServiceImpl();

    @Override
    public void simulate(String s) {
        Automaton automaton = automatonCreationService.create();
        BufferImpl buffer = new BufferImpl(automaton, s);

        try {
        while(buffer.hasToken()) {
        	System.out.println("Accepted token: " + buffer.getNextToken());
        }
        }catch(BufferException e) {
        	System.out.println(e.getMessage());
        	System.out.println("Compilation ended with errors.");
        	return;
        }
        
        System.out.println("Compilation completed without errors!");
    }
}