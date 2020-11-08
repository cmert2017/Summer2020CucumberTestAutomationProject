package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class Hooks {

    /**
     * @db
     * Scenario: I dont know but here i'm connecting to DB
     * Given user runs following quesry Select * ....
     * @param scenario
     */
    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getName());
        scenario.getSourceTagNames().forEach(tag-> {
            if (tag.contains("firefox")){
                Driver.getDriver("firefox");
            }

        });
        System.out.println(scenario.getSourceTagNames());
        System.out.println(":::Connecting to the database:::");
    }

    @Before("@db")  //this hook will run only before scenarios with a tag @db
    public void setup(){
        System.out.println(":::Starting Automation:::");
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @After
    public void tearDown(Scenario scenario) throws InterruptedException {

        /*byte[] screenshoot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshoot,"image/PNG", scenario.getName());*/
        Driver.closeDriver();
        System.out.println(":::(^_^)End of test execution(*_*):::");

    }

    @After("@db")
    public void dbtearDown(){
        System.out.println(":::Disconnecting from DB:::");
    }



}
