package com.github.biancacristina.lexical.analysis.request;

public class TransitionRequest {
    String currentStateLabel;
    String nextStateLabel;
    String symbol;

    public TransitionRequest(String currentStateLabel, String nextStateLabel, String symbol) {
        this.currentStateLabel = currentStateLabel;
        this.nextStateLabel = nextStateLabel;
        this.symbol = symbol;
    }

    public String getCurrentStateLabel() {
        return currentStateLabel;
    }

    public String getNextStateLabel() {
        return nextStateLabel;
    }

    public String getSymbol() {
        return symbol;
    }
}
