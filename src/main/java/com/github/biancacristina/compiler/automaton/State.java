package com.github.biancacristina.compiler.automaton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class State {
    private static final Logger logger = LoggerFactory.getLogger(State.class);
    private String label;
    private String tokenType;
    private boolean isFinal;
    private boolean isInitial;
    private HashMap<String, State> transitions;

    public State(String label, boolean isFinal, boolean isInitial) {
        this.label = label;
        this.isFinal = isFinal;
        this.isInitial = isInitial;
        this.transitions = new HashMap<>();
        logger.info("Created non final state labeled {}", label);
    }

    public State(String label, String tokenType, boolean isFinal, boolean isInitial) {
        this.label = label;
        this.tokenType = tokenType;
        this.isFinal = isFinal;
        this.isInitial = isInitial;
        this.transitions = new HashMap<>();
        logger.info("Created final state labeled {}", label);
    }

    public void addTransition(String symbol, State state) {
        this.transitions.put(symbol, state);
        logger.info("Added transition from symbol {} to state labeled {}", symbol, state.label);
    }

    public void removeTransition(String symbol) {
        if (this.transitions.containsKey(symbol)) {
            State state = this.transitions.remove(symbol);
            logger.info("Removed transition from symbol {} to state labeled {}", symbol, state.label);
        }
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getLabel() {
        return label;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public boolean isInitial() {
        return isInitial;
    }

    public State(String tokenType) {
        this.tokenType = tokenType;
    }

    public HashMap<String, State> getTransitions() {
        return transitions;
    }
}
