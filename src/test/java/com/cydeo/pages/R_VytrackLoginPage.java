package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class R_VytrackLoginPage {

    @FindBy(id = "prependedInput")
    public WebElement userName;

    @FindBy(id = "prependedInput2")
    public WebElement passWord;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public R_VytrackLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void login(String username,String password){
        userName.sendKeys(username);
        passWord.sendKeys(password);
        loginBtn.click();
    }


}
