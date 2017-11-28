package de.holisticon.dmn.testdriver;

import lombok.Setter;
import lombok.experimental.Delegate;
import org.camunda.bpm.engine.variable.VariableMap;

public class InsuranceProtectionDecision extends AbstractDecision<Boolean> {

    @Setter
    private String damage;

    @Setter
    private Long amount;

    @Delegate(types = CustomerStateDecision.class, excludes = AbstractDecision.class)
    private final CustomerStateDecision customerStateDecision = new CustomerStateDecision(null, null);

    public InsuranceProtectionDecision(String dmnFile, String decisionName) {
        super(dmnFile, decisionName);
    }

    public boolean insuranceProtection() {
        VariableMap variableMap = customerStateDecision.createVariables();
        variableMap.putValue("damage", damage)
                .putValue("amount", amount);
        return evaluateDecisionTable(variableMap, "insuranceProtection");
    }

}
