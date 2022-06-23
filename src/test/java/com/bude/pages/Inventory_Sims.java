package com.bude.pages;

import com.bude.genericmethods.Utilities;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class Inventory_Sims {

    private WebDriver driver;
    ExtentTest logger;
    Inventory inventory = new Inventory(driver,logger);
    Utilities utilities = new Utilities();

    public Inventory_Sims(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements( driver, this);
    }



    @FindBy(xpath = "//button[@class='p-button-success p-mr-2 p-button p-component']") WebElement btnAdd_sim;
    @FindBy(xpath = "//input[@class='add-input ng-untouched ng-pristine ng-invalid' and @formcontrolname='number']") WebElement Mobilenumber;
    @FindBy(xpath = "//input[@class='add-input ng-untouched ng-pristine ng-invalid' and @formcontrolname='simCardNumber']") WebElement Simnumber;
    @FindBy(xpath = "//div[@class='p-dropdown-trigger ng-tns-c95-20']") WebElement dropdown_operator;
    @FindBy(xpath = "//div[@class='p-dropdown-trigger ng-tns-c95-21']") WebElement dropdown_Cirlce;
    @FindBy(xpath = "//li[@class=\"p-dropdown-item p-ripple\"]") WebElement Select_Airtel;
    @FindBy(xpath = "//li[@class='p-dropdown-item p-ripple']") WebElement Select_Andhrapradesh;
    @FindBy(xpath = "//button[@class='p-button-primary p-button p-component']") WebElement btn_CreateSim;
    @FindBy(xpath = "//div[contains(text(),'Error')]") WebElement toast_error;
    @FindBy(xpath = "//div[contains(text(),'Success')]") WebElement toast_success;



    public void clickbtnAdd_sim(){
        if (btnAdd_sim.isDisplayed())
        {
            btnAdd_sim.click();
            logger.log(LogStatus.PASS, "Clicked on Add Sim Successfully");
        }
        else
        {
            logger.log(LogStatus.FAIL, "Failed to Click ADD Sim:"+btnAdd_sim);
        }
    }

    public void enterMobilenumber(String EnterMobilenumber){
        if (Mobilenumber.isDisplayed())
        {
            Mobilenumber.sendKeys(EnterMobilenumber);
            logger.log(LogStatus.PASS, "Entered mobile number Successfully");
        }
        else
        {
            logger.log(LogStatus.FAIL, "Failed to entered mobile number:"+Mobilenumber);
        }
    }

    public void enterSimnumber(String EnterSimnumber)
    {
        if(Simnumber.isDisplayed())
        {
            Simnumber.sendKeys(EnterSimnumber);
            logger.log(LogStatus.PASS, "Entered Sim number Successfully");
        }
        else
        {
            logger.log(LogStatus.FAIL, "Failed to entered Sim number:"+Simnumber);
        }
    }

    public void selectOperator()
    {
        if(dropdown_operator.isDisplayed()){
            dropdown_operator.click();
            logger.log(LogStatus.PASS, "Click on Operator Successfully");

            if(Select_Airtel.isDisplayed()){
                Select_Airtel.click();
                logger.log(LogStatus.PASS, "Selected Airtel Successfully");
            }
        }
        else
        {
            logger.log(LogStatus.FAIL, "Failed to Select Operator:"+dropdown_operator);
        }
    }

    public void selectCircle()
    {
        if(dropdown_Cirlce.isDisplayed()){
            dropdown_Cirlce.click();
            logger.log(LogStatus.PASS, "Click on Circle Successfully");

            if(Select_Andhrapradesh.isDisplayed()){
                Select_Andhrapradesh.click();
                logger.log(LogStatus.PASS, "Selected Andhra Pradesh Successfully");
            }
        }
        else
        {
            logger.log(LogStatus.FAIL, "Failed to Select Operator:"+dropdown_Cirlce);
        }
    }

    public void clickbtnCreateSim() {
        if (btn_CreateSim.isDisplayed()) {
            btn_CreateSim.click();
            logger.log(LogStatus.PASS, "Sim Created Successfully");

        } else {
            logger.log(LogStatus.FAIL, "Failed to Click on Create Sim:" + btn_CreateSim);
        }
    }


    public WebDriver createSim(String mobilenumner, String simnumber) throws IOException {
        inventory.clickinventory();
        clickbtnAdd_sim();
        enterMobilenumber(mobilenumner);
        enterSimnumber(simnumber);
        selectOperator();
        selectCircle();
        clickbtnCreateSim();
        System.out.println(toast_success.getText());
        System.out.println(toast_error.getText());
        logger.log(LogStatus.INFO, toast_success.getText());
        logger.log(LogStatus.INFO, toast_error.getText());
        String screenshotPath = utilities.getScreenPath(driver, "44");
        System.out.println(toast_success.getText());
        System.out.println(toast_error.getText());
        logger.log(LogStatus.INFO, toast_success.getText());
        logger.log(LogStatus.INFO, toast_error.getText());
        if(toast_error.isDisplayed())
        {
            logger.log(LogStatus.FAIL, "Sim Creation Failed");
            logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
        }
        if(toast_success.getText() != null)
        {
            logger.log(LogStatus.PASS, "Sim Created Successfully");
            logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
        }
        return driver;
    }

}


