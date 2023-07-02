package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {


    //#1-Create to constructor and initialize the driver with object

    public void GoogleSearchPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    //#2-Use @FindBy instead of findElement()

    @FindBy(id="L2AGLb")
    public WebElement cookies;

    @FindBy(xpath = "//textarea[@class='gLFyf']")
    public WebElement searchBox;


}
