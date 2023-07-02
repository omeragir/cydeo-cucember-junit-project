package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Google_StepDefinitions {

    GoogleSearchPage googleSearchPage=new GoogleSearchPage();

    @When("user searches for {word}")
    public void user_searches_for_apple(String word) {
        BrowserUtils.sleep(1);
        //googleSearchPage.cookies.click();
        //googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);
        BrowserUtils.sleep(1);
        Driver.getDriver().findElement(By.cssSelector("[id='L2AGLb']")).click();
        WebElement search =  Driver.getDriver().findElement(By.name("q"));
        search.sendKeys(word+Keys.ENTER);

        BrowserUtils.sleep(1);
    }
    @Then("user should see {word} in the title")
    public void user_should_see_apple_in_the_title(String word) {
        BrowserUtils.verifyTitle(word+" - Google Suche");
    }

    @When("user is on the Google search page")
    public void user_is_on_the_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {

        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="Google";

        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.closeDriver();

    }

    /*
    @And("user sees {int} apple")
    public void userSeesApple(int arg0) {

    }

     */
}
