package structure;

import exception.AutomatonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Automaton {
    private static final Logger logger = LoggerFactory.getLogger(Automaton.class);
    private State initialState;
    private State currentState;
    private HashMap<String, State> states;

    public Automaton(HashMap<String, State> states) {
        this.initialState = states.values().stream()
                .filter(State::isInitial)
                .findFirst()
                .orElseThrow( () -> new AutomatonException("Automaton without initial state exception") );
        this.currentState = this.initialState;
        this.states = states;
        logger.info("Created automaton");
    }

    public boolean hasNextState(String symbol) {
        return currentState.getTransitions().containsKey(symbol);
    }

    public boolean isAtFinalState() {
        return this.currentState.isFinal();
    }

    public void makeTransition(String symbol) {
        this.currentState = currentState.getTransitions().get(symbol);
    }
}
