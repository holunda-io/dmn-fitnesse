package de.holisticon.dmn.testdriver;

import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

public class CustomerStateDecision extends AbstractDecision<String> {

    private boolean isVip;
    private int insuranceDuration;

    public void setInsuranceDuration(int insuranceDuration) {
        this.insuranceDuration = insuranceDuration;
    }

    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }

    public CustomerStateDecision(String dmnFile, String decisionName) {
        super(dmnFile, decisionName);
    }

    public String customerState() {

        return evaluateDecisionTable(createVariables(), "customerState");
    }

    private VariableMap createVariables() {
        return Variables
                .putValue("isVip", isVip)
                .putValue("insuranceDuration", insuranceDuration);
    }


}
