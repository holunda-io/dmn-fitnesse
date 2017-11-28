package de.holisticon.dmn.testdriver;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

import java.io.InputStream;


public abstract class AbstractDecision<T> {

    private DmnEngine dmnEngine;
    private DmnDecision decision;
    private String dmnFile;
    private String decisionName;


    public AbstractDecision(String dmnFile, String decisionName) {
        this.dmnFile = dmnFile;
        this.decisionName = decisionName;

    }

    public T evaluateDecisionTable(VariableMap variableMap,String param) {

        // Evaluate decision with id 'orderDecision' from file 'Example.dmn'
        DmnDecisionTableResult results = getDmnEngine().evaluateDecisionTable(getDecision(), variableMap);
        return results.getSingleResult().getEntry(param);

    }

    private DmnEngine getDmnEngine() {

        if (this.dmnEngine == null) {
            // create default DMN engine configuration
            DmnEngineConfiguration configuration = DmnEngineConfiguration
                    .createDefaultDmnEngineConfiguration();

            // build a new DMN engine
            dmnEngine = configuration.buildEngine();
        }
        return this.dmnEngine;
    }

    private DmnDecision getDecision() {

        if (this.decision == null) {

            // Parse decision
            InputStream inputStream = getClass().getResourceAsStream("/" + dmnFile);
            this.decision = getDmnEngine().parseDecision(decisionName, inputStream);
        }
        return this.decision;
    }

}
