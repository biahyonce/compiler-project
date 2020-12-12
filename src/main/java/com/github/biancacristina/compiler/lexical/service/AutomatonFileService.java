package com.github.biancacristina.compiler.lexical.service;


import com.github.biancacristina.compiler.lexical.request.StateRequest;
import com.github.biancacristina.compiler.lexical.request.TransitionRequest;

import java.util.List;

public interface AutomatonFileService {
    List<StateRequest> readStates();
    List<TransitionRequest> readTransitions();
}
