package com.cydeo.step_definitions;

import com.cydeo.pages.R_VytrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class R_VytrackLogin_StepDefinitions {

    R_VytrackLoginPage rVytrackLoginPage = new R_VytrackLoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));

    }

    @When("user enters the driver information")
    public void user_enters_the_driver_information() {

        rVytrackLoginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));

    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard";

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(30));
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals("Title verification failed",expectedTitle,actualTitle);

    }

    @When("user enters the sales manager information")
    public void user_enters_the_sales_manager_information() {

        rVytrackLoginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty("sales_manager_password"));

    }

    @When("user enters the store manager information")
    public void user_enters_the_store_manager_information() {
        rVytrackLoginPage.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("store_manager_password"));

    }
}
