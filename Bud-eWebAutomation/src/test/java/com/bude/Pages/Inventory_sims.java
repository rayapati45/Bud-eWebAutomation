package com.bude.Pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory_sims{

    private WebDriver driver;
    ExtentTest logger;

    public Inventory_sims(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements( driver, this);
    }

    @FindBy(xpath = "Inventory")  WebElement Inventoery;
    @FindBy(xpath = "//a[@class='ng-tns-c134-19 ng-star-inserted active-menuitem-routerlink']") WebElement SIM_Cards;
    @FindBy(xpath = "//button[@class='p-button-success p-mr-2 p-button p-component']") WebElement btnAdd_sim;
    @FindBy(xpath = "//input[@formcontrolname='number']") WebElement Mobilenumber;
    @FindBy(xpath = "//input[@formcontrolname='simCardNumber']") WebElement Simnumber;
    @FindBy(xpath = "//div[@class='p-dropdown-trigger ng-tns-c66-95']") WebElement Operator_dropdown;
    @FindBy(xpath = "//div[@class='p-dropdown-trigger ng-tns-c66-96']") WebElement Circle_dropdown;
    @FindBy(xpath = "//li[@class='p-dropdown-item p-ripple']") WebElement Select_Airtel;
    @FindBy(xpath = "//span[@class='ng-tns-c95-59 p-dropdown-label p-inputtext ng-star-inserted']") WebElement Select_AndhraPradesh;
    @FindBy(xpath = "//span[@class='p-button-label' and text()='Create SIM']") WebElement btn_createSim;


}
