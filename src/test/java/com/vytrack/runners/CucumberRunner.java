package com.vytrack.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/vytrack/step_definitions",
        publish = true,
        dryRun = false,
        //tags = "@negative_login or @parametrized_test",
        //tags = "@login",
       // tags = "@scenario_1"
         //tags = "@scenario_1 or @scenario_2"
       // tags = " @createCar"
        tags = "@positiveLogin"

)
public class CucumberRunner {


}
