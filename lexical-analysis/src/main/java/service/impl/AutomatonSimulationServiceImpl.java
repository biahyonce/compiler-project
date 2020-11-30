package service.impl;

import service.AutomatonCreationService;
import service.AutomatonSimulationService;
import structure.Automaton;
import buffer.impl.BufferImpl;
import exception.BufferException;

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