package de.holisticon.dmn.testdriver;

import lombok.Setter;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

public class CustomerStateDecision extends AbstractDecision<String> {

    private boolean isVip;

    @Setter
    private int insuranceDuration;


    public CustomerStateDecision(String dmnFile, String decisionName) {
        super(dmnFile, decisionName);
    }

    public String customerState() {

        return evaluateDecisionTable(createVariables(),"customerState");
    }

    public VariableMap createVariables() {

        VariableMap variableMap = Variables.createVariables();
        variableMap
                .putValue("isVip", isVip)
                .putValue("insuranceDuration", insuranceDuration);
        return variableMap;
    }

    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }
}
