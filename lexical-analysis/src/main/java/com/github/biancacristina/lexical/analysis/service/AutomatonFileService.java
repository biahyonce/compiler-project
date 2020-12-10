package com.github.biancacristina.lexical.analysis.service;

import com.github.biancacristina.lexical.analysis.request.StateRequest;
import com.github.biancacristina.lexical.analysis.request.TransitionRequest;

import java.util.List;

public interface AutomatonFileService {
    List<StateRequest> readStates();
    List<TransitionRequest> readTransitions();
}
