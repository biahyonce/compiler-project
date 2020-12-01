package request;

public class StateRequest {
    private String label;
    private String tokenType;
    private boolean isFinal;
    private boolean isInitial;

    public StateRequest(String label, boolean isFinal, boolean isInitial) {
        this.label = label;
        this.isFinal = isFinal;
        this.isInitial = isInitial;
    }

    public StateRequest(String label, String tokenType, boolean isFinal, boolean isInitial) {
        this.label = label;
        this.tokenType = tokenType;
        this.isFinal = isFinal;
        this.isInitial = isInitial;
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

    public String getTokenType() {
        return tokenType;
    }
}
