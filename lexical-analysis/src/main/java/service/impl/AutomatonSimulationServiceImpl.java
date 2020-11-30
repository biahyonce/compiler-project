package service.impl;

import service.AutomatonCreationService;
import service.AutomatonSimulationService;
import structure.Automaton;

public class AutomatonSimulationServiceImpl implements AutomatonSimulationService {
    AutomatonCreationService automatonCreationService = new AutomatonCreationServiceImpl();

    @Override
    public void simulate(String s) {
        Automaton automaton = automatonCreationService.create();
        for(char c : s.toCharArray()) {
            String symbol = String.valueOf(c);
            if (automaton.hasNextState(symbol)) { automaton.makeTransition(symbol); }
            else { break; }
        }
        // TODO: Improve the follow final result
        if (automaton.isAtFinalState()) { System.out.println("Accepted"); }
        else { System.out.println("Denied"); }
    }
}