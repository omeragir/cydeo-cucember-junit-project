package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyHomePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Etsy_StepDefinitions {
    EtsyHomePage etsyHomePage = new EtsyHomePage();

    @Given("user is on the Etsy home page")
    public void user_is_on_the_etsy_home_page() {
        Driver.getDriver().get("https://www.etsy.com");
        //etsyHomePage.cookies.click();

    }

    @Then("user should see title is as expected")
    public void user_should_see_title_is_as_expected() {

        String expectedTitle = "Etsy Deutschland – Kaufe Handgefertigtes, Vintage-Sachen, Spezialanfertigungen und einzigartige Geschenke für alle ein.";
        //String actualTitle=Driver.getDriver().getTitle();
        //Assert.assertEquals(expectedTitle,actualTitle);

        BrowserUtils.verifyTitle(expectedTitle);
    }

    @When("user types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {
        etsyHomePage.searchBox.sendKeys("Wooden Spoon");
    }

    @When("user click to Etsy search button")
    public void user_click_to_etsy_search_button() {
        etsyHomePage.searchButton.click();
    }

    @Then("user sees Wooden Spoon is in the title")
    public void user_sees_wooden_spoon_is_in_the_title() {
        BrowserUtils.verifyTitle("Wooden spoon - Etsy DE");
    }

    @When("user types {string} in the search box")
    public void userTypesInTheSearchBox(String searchValue) {
        etsyHomePage.searchBox.sendKeys(searchValue);
    }

    @Then("user sees {string} is in the title")
    public void userSeesIsInTheTitle(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }
}
