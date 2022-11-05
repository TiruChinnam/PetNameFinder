package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"StepDefinitions"},
        features = "src/test/resources/Feature",

        plugin = { "pretty", "json:test-output/cucumber-reports/Cucumber.json",
                "html:test-output/cucumber-reports/Cucumber.html"},
        dryRun = true,
        monochrome = true
)


public class TestRun {


}
