package com.bude.Pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory {

    private WebDriver driver;
    ExtentTest logger;

    public Inventory(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements( driver, this);
    }

    @FindBy(xpath = "Inventory")  WebElement Inventoery;
    @FindBy(xpath = "//a[@class='ng-tns-c134-19 ng-star-inserted active-menuitem-routerlink']") WebElement SIM_Cards;
    @FindBy(xpath = "//button[@class='p-button-success p-mr-2 p-button p-component']") WebElement btnAdd_sim;

}
