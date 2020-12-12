package com.github.biancacristina.compiler.lexical.service.impl;

import com.github.biancacristina.compiler.lexical.exception.AutomatonCreationException;
import com.github.biancacristina.compiler.lexical.request.StateRequest;
import com.github.biancacristina.compiler.lexical.request.TransitionRequest;
import com.github.biancacristina.compiler.lexical.service.AutomatonCreationService;
import com.github.biancacristina.compiler.lexical.service.AutomatonFileService;
import com.github.biancacristina.compiler.lexical.structure.Automaton;
import com.github.biancacristina.compiler.lexical.structure.State;

import java.util.HashMap;
import java.util.List;

public class AutomatonCreationServiceImpl implements AutomatonCreationService {
    AutomatonFileService automatonFileService = new AutomatonFileServiceImpl();

    @Override
    public Automaton create() {
        HashMap<String, State> states = new HashMap<>();
        List<StateRequest> stateRequests = automatonFileService.readStates();
        List<TransitionRequest> transitionRequests = automatonFileService.readTransitions();
        stateRequests.forEach(request -> createState(request, states) );
        transitionRequests.forEach( request -> createTransition(request, states) );
        return new Automaton(states);
    }

    private void createState(StateRequest request, HashMap<String, State> states) {
        State state;
        if (request.isFinal()) {
            state = new State(request.getLabel(), request.getTokenType(), request.isFinal(), request.isInitial());
        } else {
            state = new State(request.getLabel(), request.isFinal(), request.isInitial());
        }
        states.put(request.getLabel(), state);
    }

    private void createTransition(TransitionRequest request, HashMap<String, State> states) {
        if (states.containsKey(request.getCurrentStateLabel()) && states.containsKey(request.getNextStateLabel())) {
            State currentState = states.get(request.getCurrentStateLabel());
            State nextState = states.get(request.getNextStateLabel());
            currentState.addTransition(request.getSymbol(), nextState);
            states.replace(request.getCurrentStateLabel(), currentState);
        } else {
            throw new AutomatonCreationException("Current state or next state doesn't exist in automaton");
        }
    }
}