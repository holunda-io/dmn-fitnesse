package de.holisticon.dmn.testdriver;

import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

public class InsuranceProtectionDecision extends AbstractDecision<Boolean> {


    private String damage;
    private boolean isVip;
    private int insuranceDuration;
    private Long amount;


    public InsuranceProtectionDecision(String dmnFile, String decisionName) {
        super(dmnFile, decisionName);
    }

    public boolean insuranceProtection() {

        return evaluateDecisionTable(createVariables(), "insuranceProtection");
    }

    private VariableMap createVariables() {
        return Variables
                .putValue("damage", damage)
                .putValue("amount", amount)
                .putValue("isVip", isVip)
                .putValue("insuranceDuration", insuranceDuration);
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setInsuranceDuration(int insuranceDuration) {
        this.insuranceDuration = insuranceDuration;
    }

    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }
}
