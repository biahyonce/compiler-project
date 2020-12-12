package com.github.biancacristina.compiler.automaton.service;


import com.github.biancacristina.compiler.automaton.request.StateRequest;
import com.github.biancacristina.compiler.automaton.request.TransitionRequest;

import java.util.List;

public interface AutomatonFileService {
    List<StateRequest> readStates();
    List<TransitionRequest> readTransitions();
}
