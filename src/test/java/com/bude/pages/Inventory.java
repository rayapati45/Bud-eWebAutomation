package com.bude.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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

    @FindBy(xpath = "Inventory") WebElement Inventory;
    @FindBy(xpath = "//a[@class=\"ng-tns-c134-24 ng-star-inserted\"]") WebElement SIM_Cards;
    @FindBy(xpath = "//a[@class=\"ng-tns-c134-23 ng-star-inserted\"]") WebElement IoT;
    @FindBy(xpath = "//a[@class=\"ng-tns-c134-22 ng-star-inserted\"]") WebElement Batteries;
    @FindBy(xpath = "//a[@class=\"ng-tns-c134-21 ng-star-inserted\"]") WebElement Vehicles;

    public WebDriver clickinventory() {
        if (Inventory.isDisplayed()) {
            Inventory.click();
            logger.log(LogStatus.PASS, "Clicked on Inventory Successfully");

        } else {
            logger.log(LogStatus.FAIL, "Failed to Click Inventory: " + Inventory);
        }
        return null;
    }

    public WebDriver clickSims(){
        if (SIM_Cards.isDisplayed())
        {
            SIM_Cards.click();
            logger.log(LogStatus.PASS, "Clicked on SIM Cards Successfully");
        }
        else{
            logger.log(LogStatus.FAIL, "Failed to Click SIM Cards: " + SIM_Cards);
        }
        return driver;
    }

    public WebDriver clickIoT(){
        if (IoT.isDisplayed())
        {
            IoT.click();
            logger.log(LogStatus.PASS, "Clicked on IoT Successfully");
        }
        else{
            logger.log(LogStatus.FAIL, "Failed to Click IoT: " + IoT);
        }
        return driver;
    }

    public WebDriver clickbatteries(){
        if (Batteries.isDisplayed())
        {
            Batteries.click();
            logger.log(LogStatus.PASS, "Clicked on Batteries Successfully");
        }
        else{
            logger.log(LogStatus.FAIL, "Failed to Click Batteries: " + Batteries);
        }
        return driver;
    }

    public WebDriver clickVehicels(){
        if (Vehicles.isDisplayed())
        {
            Vehicles.click();
            logger.log(LogStatus.PASS, "Clicked on vehilces Successfully");
        }
        else{
            logger.log(LogStatus.FAIL, "Failed to Click Vehilces : " + Vehicles);
        }
        return driver;
    }


}
