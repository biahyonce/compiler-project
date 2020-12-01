package service;

import request.StateRequest;
import request.TransitionRequest;

import java.util.List;

public interface AutomatonFileService {
    List<StateRequest> readStates();
    List<TransitionRequest> readTransitions();
}
