package org.sunrise.sunset.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/json-reports/cucumber.json",
                "html:target/cucumber-reports"
        },
        features = "src/test/resources",
        glue = "org/sunrise/sunset/steps"
        , dryRun = false
        , tags = "@api"
)
public class TestRunner {

}
