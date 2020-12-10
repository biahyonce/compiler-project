package com.github.biancacristina.lexical.analysis.service.impl;

import com.github.biancacristina.lexical.analysis.buffer.impl.BufferImpl;
import com.github.biancacristina.lexical.analysis.exception.BufferException;
import com.github.biancacristina.lexical.analysis.service.AutomatonCreationService;
import com.github.biancacristina.lexical.analysis.service.AutomatonSimulationService;
import com.github.biancacristina.lexical.analysis.structure.Automaton;

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