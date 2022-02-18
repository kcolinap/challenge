package org.challenge.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario){

        logger.info("Executing scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario){
        if (scenario.isFailed())
            logger.warn(scenario.getName() + ": " + scenario.getStatus());
        else
            logger.info(scenario.getName() + ": " + scenario.getStatus());

    }
}
