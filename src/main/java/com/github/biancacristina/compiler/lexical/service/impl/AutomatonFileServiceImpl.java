package com.github.biancacristina.compiler.lexical.service.impl;

import com.github.biancacristina.compiler.lexical.exception.AutomatonFileException;
import com.github.biancacristina.compiler.lexical.request.StateRequest;
import com.github.biancacristina.compiler.lexical.request.TransitionRequest;
import com.github.biancacristina.compiler.lexical.service.AutomatonFileService;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomatonFileServiceImpl implements AutomatonFileService {
    private static final String SPLIT_REGEX = "\\s+";
    private static final String STATES_FILE = "/states.txt";
    private static final String TRANSITIONS_FILE = "/transitions.txt";

    public List<StateRequest> readStates(){
        try {
            List<StateRequest> requests = new ArrayList<>();
            InputStream inputStream  = AutomatonFileServiceImpl.class.getResourceAsStream(STATES_FILE);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] requestString = line.split(SPLIT_REGEX);
                StateRequest request = createStateRequest(requestString);
                requests.add(request);
            }
            scanner.close();
            inputStream.close();
            return requests;
        } catch (Exception e) {
            throw new AutomatonFileException("Error on reading states file", e);
        }
    }

    private StateRequest createStateRequest(String[] requestString) {
        int size = requestString.length;
        if (size == 3) {
            return new StateRequest(requestString[0], Boolean.parseBoolean(requestString[1]), Boolean.parseBoolean(requestString[2]));
        } else {
            return new StateRequest(requestString[0], requestString[3], Boolean.parseBoolean(requestString[1]), Boolean.parseBoolean(requestString[2]));
        }
    }

    public List<TransitionRequest> readTransitions() {
        try {
            List<TransitionRequest> requests = new ArrayList<>();
            InputStream inputStream  = AutomatonFileServiceImpl.class.getResourceAsStream(TRANSITIONS_FILE);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                ArrayList<String> requestString = this.getRequestString(line);
                requests.add(
                    new TransitionRequest(
                        requestString.get(0), 
                        requestString.get(1), 
                        requestString.get(2)
                    )
                );
            }
            scanner.close();
            inputStream.close();
            return requests;
        } catch (Exception e) {
            throw new AutomatonFileException("Error on reading transitions file", e);
        }
    }

    private ArrayList<String> getRequestString(String line) {
        ArrayList<String> requestString = new ArrayList<String>();
        String[] arr = line.split(SPLIT_REGEX);
        for(int i=0; i<arr.length; i++) {
            requestString.add(arr[i]);
        }
        while(requestString.size() < 3) {
            requestString.add(" ");
        }
        return requestString;
    }
}