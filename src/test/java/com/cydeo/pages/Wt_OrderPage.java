package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Wt_OrderPage extends WT_BasePage{

    public Wt_OrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name="product")
    public WebElement productDropdown;

    @FindBy(xpath = "//input[@value='Visa']")
    public WebElement visaRadiButton;

    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement masterCardRadiButton;

    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement americanExpressRadiButton;

    //We find same attribute and value directly add our list of WebElement
    @FindBy(name="card")
    public List<WebElement> cardTypes;


    @FindBy(name="quantity")
    public WebElement inputQuantity;

    @FindBy(xpath = "//button[.='Calculate']")
    public WebElement calculateButton;

    @FindBy(name="name")
    public WebElement inputNAme;

    @FindBy(name = "street")
    public WebElement inputStreet;

    @FindBy(name = "city")
    public WebElement inputCity;

    @FindBy(name = "state")
    public WebElement inputState;

    @FindBy(name = "zip")
    public WebElement inputZip;

    @FindBy(name = "cardNo")
    public WebElement inputCard;

    @FindBy(name = "cardExp")
    public WebElement inputExpressionsDate;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processButton;
}
