package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.txt",
        //glue is where we can find the implementation for gherkin steps
        //here we provide the path of our steps package
        glue = "steps",
        //if we set dryRun to true, then no actual execution happens
        //it wil quickly scan all gherkin steps whether they have implementation or not
        //dryRun = false,
        //it keeps the console output for the cucumber test easily readable
        //it will remove all the unreadable characters
        monochrome = true,
        //tags is like logical operators, and you can define the scope of what you want to be executed
        //tags = "@errorvalidation",
        plugin = {"pretty"}
        //plugin - we use it to generate report for the execution
        //pretty - it takes care of printing the steps in console
        //strict = true, it checks all the steps definition
)

public class FailedRunner {
}
