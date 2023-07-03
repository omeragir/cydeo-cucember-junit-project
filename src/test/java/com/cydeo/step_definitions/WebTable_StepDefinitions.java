package com.cydeo.step_definitions;

import com.cydeo.pages.WT_LoginPage;
import com.cydeo.pages.WT_ViewAllOrderPage;
import com.cydeo.pages.Wt_OrderPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class WebTable_StepDefinitions {

    WT_LoginPage wtLoginPage = new WT_LoginPage();

    @Given("user is on the  Web Table app login page")
    public void user_is_on_the_web_table_app_login_page() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");

    }

    @When("user enters correct username")
    public void user_enters_correct_username() {
        wtLoginPage.inputUsername.sendKeys("Test");

    }

    @When("user enters correct password")
    public void user_enters_correct_password() {
        wtLoginPage.inputPassword.sendKeys("Tester");

    }


    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        wtLoginPage.loginButton.click();


    }

    @Then("user should see orders word in the URL")
    public void user_should_see_orders_word_in_the_url() {
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedInURL = "orders";
        Assert.assertTrue(actualURL.contains(expectedInURL));

    }

    @When("user enters {string} username and user enters {string} password")
    public void userEntersUsernameAndUserEntersPassword(String username, String password) {
        wtLoginPage.inputUsername.sendKeys(username);
        wtLoginPage.inputPassword.sendKeys(password);
    }


    @When("user enters belows correct credentials")
    public void userEntersBelowsCorrectCredentials(Map<String, String> credentials) {
        wtLoginPage.inputUsername.sendKeys(credentials.get("username"));
        wtLoginPage.inputPassword.sendKeys(credentials.get("password"));

    }

    @Given("user is already logged in to The Web table app")
    public void user_is_already_logged_in_to_the_web_table_app() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        wtLoginPage.login();
    }

    Wt_OrderPage orderPage = new Wt_OrderPage();

    @When("user is on the Order page")
    public void user_is_on_the_order_page() {
        orderPage.orderLink.click();
        BrowserUtils.sleep(2);
    }

    @Then("user sees below options under product dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String> expectedOptions) {
        List<String> actualOptions=BrowserUtils.dropdownOptions_as_STRING(orderPage.productDropdown);
        Assert.assertEquals(actualOptions,expectedOptions);

    }

    @Then("user sees VISA as enable payment options")
    public void userSeesVISAAsEnablePaymentOptions() {
        Assert.assertTrue(orderPage.visaRadiButton.isEnabled());
    }

    @Then("user sees MasterCard as enable payment options")
    public void userSeesMasterCardAsEnablePaymentOptions() {
        Assert.assertTrue(orderPage.masterCardRadiButton.isEnabled());
    }

    @Then("user sees American Express as enable payment options")
    public void userSeesAmericanExpressAsEnablePaymentOptions() {
        Assert.assertTrue(orderPage.americanExpressRadiButton.isEnabled());
    }

    @And("user enters quantity {string}")
    public void userEntersQuantity(String quantity) {
        orderPage.inputQuantity.clear();

        //Another options delete
        //orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);
        orderPage.inputQuantity.sendKeys("2");
    }

    @Then("user clicks to the calculate button")
    public void userClicksToTheCalculateButton() {
        orderPage.calculateButton.click();
    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String name) {
        orderPage.inputNAme.sendKeys(name);

    }

    @And("user enters street {string}")
    public void userEntersStreet(String street) {
        orderPage.inputStreet.sendKeys(street);
    }

    @And("user enters city {string}")
    public void userEntersCity(String city) {
        orderPage.inputCity.sendKeys(city);
    }

    @And("user enters state {string}")
    public void userEntersState(String state) {
        orderPage.inputState.sendKeys(state);
    }

    @And("user enters zip {string}")
    public void userEntersZip(String zip) {
        orderPage.inputZip.sendKeys(zip);
    }

    @And("user selects payment options {string}")
    public void userSelectsPaymentOptions(String expectedCardType) {
        BrowserUtils.clickRadioButton(orderPage.cardTypes,expectedCardType);

    }

    @And("user enters card number {string}")
    public void userEntersCardNumber(String cardNumber) {
        orderPage.inputCard.sendKeys(cardNumber);

    }

    @And("user enters expiration date {string}")
    public void userEntersExpirationDate(String date) {
        orderPage.inputExpressionsDate.sendKeys(date);
    }

    @And("user clicks to process order button")
    public void userClicksToProcessOrderButton() {
        orderPage.processButton.click();
    }

    WT_ViewAllOrderPage viewAllOrderPage=new WT_ViewAllOrderPage();

    @Then("user should see {string} in the first row of the web table")
    public void userShouldSeeInTheFirstRowOfTheWebTable(String expectedName) {
        String actualName=viewAllOrderPage.newCustomerCell.getText();
        Assert.assertEquals(actualName,expectedName);

    }
}
