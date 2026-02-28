package com.shivang.sqloptimiser.model;

public class OptimisationIssue {

    private final String ruleName;
    private final String message;
    private final Severity severity;

    public OptimisationIssue(String ruleName, String message, Severity severity){
        this.ruleName = ruleName;
        this.message = message;
        this.severity = severity;
    }    

    public String getRuleName() {
        return ruleName;
    }
    public String getMessage() {
        return message;
    }
    public Severity getSeverity() {
        return severity;
    }

}
