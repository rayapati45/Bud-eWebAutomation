package com.bude.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory_Sims {

    private WebDriver driver;
    ExtentTest logger;

    public Inventory_Sims(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements( driver, this);
    }

    @FindBy(xpath = "Inventory")  WebElement Inventoery;
    @FindBy(xpath = "//a[@class='ng-tns-c134-19 ng-star-inserted active-menuitem-routerlink']") WebElement SIM_Cards;
    @FindBy(xpath = "//button[@class='p-button-success p-mr-2 p-button p-component']") WebElement btnAdd_sim;
    @FindBy(xpath = "//input[@class='add-input ng-untouched ng-pristine ng-invalid' and @formcontrolname='number']") WebElement Mobilenumber;
    @FindBy(xpath = "//input[@class='add-input ng-untouched ng-pristine ng-invalid' and @formcontrolname='simCardNumber']") WebElement Simnumber;
    @FindBy(xpath = "//div[@class='p-dropdown-trigger ng-tns-c95-20']") WebElement dropdown_operator;
    @FindBy(xpath = "//div[@class='p-dropdown-trigger ng-tns-c95-21']") WebElement dropdown_Cirlce;
    @FindBy(xpath = "//li[@class=\"p-dropdown-item p-ripple\"]") WebElement Select_Airtel;
    @FindBy(xpath = "//li[@class='p-dropdown-item p-ripple']") WebElement Select_Andhrapradesh;
    @FindBy(xpath = "//button[@class='p-button-primary p-button p-component']") WebElement btn_CreateSim;


    public void Clickinventory(){
        if (Inventoery.isDisplayed())
        {
            Inventoery.click();
        }
        else
        {
            logger.log(LogStatus.FAIL, "Failed to Click Inventory: ");
        }
    }


}
