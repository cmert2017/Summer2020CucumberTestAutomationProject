package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utils.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStepDefinitions {
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new LoginPage();

    @Given("user navigates to {string} and {string}")
    public void user_navigates_to_and(String tab, String module) throws InterruptedException {

        basePage.navigateTo(tab, module);


    }



    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
       Driver.getDriver().get("https://qa1.vytrack.com");

    }

    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
        loginPage.login(string);

    }


    @When("user clicks on save and close button")
    public void user_clicks_on_save_and_close_button() {
       basePage.clickSaveAndClose();
    }



}
