package com.bude.pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory_battery {
    private WebDriver driver;
    ExtentTest logger;

    public Inventory_battery(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements( driver, this);
    }


}
