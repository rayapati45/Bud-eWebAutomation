package com.bude.pages;

import com.bude.genericmethods.Utilities;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory_battery {
    private WebDriver driver;
    Utilities utilities = new Utilities();
    ExtentTest logger;
    Inventory inventory = new Inventory(driver,logger);

    public Inventory_battery(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
        PageFactory.initElements( driver, this);
    }

    @FindBy(xpath = "//button[@label=\"Add Battery\"]")  WebElement btnAdd_battery;
    @FindBy(xpath = "//input[@id=\"serialNum\"]") WebElement txt_serialnumber;
    @FindBy(xpath = "//div[@class=\"p-dropdown-trigger ng-tns-c95-68\"]") WebElement dropdown_ManufacturerName;
    @FindBy(xpath = "//li[@aria-label=\"Micronix\"]") WebElement Micronix;
    @FindBy(xpath = "//div[@class=\"p-dropdown-trigger ng-tns-c95-69\"]") WebElement dropdown_BatteryType;
    @FindBy(xpath = "//li[@aria-label=\"Litiumion\"]") WebElement Lithiumion;
    @FindBy(xpath = "//input[@class=\"ng-tns-c148-70 p-inputtext p-component ng-star-inserted\"]") WebElement txt_PurchaseDate;
    @FindBy(xpath = "//input[@id=\"qrCode\"]") WebElement txt_qrcode;
    @FindBy(xpath = "//button[@class=\"p-button p-button-warning p-component ng-star-inserted\"]") WebElement btnCreatebattery;


    public void clickbtnAddbattery()
    {
        if(Utilities.explicitWait(driver, btnAdd_battery, "clickable")){
            btnAdd_battery.click();
            logger.log(LogStatus.PASS, "Successfully clicked on Add battery");
        }
        else
            logger.log(LogStatus.FAIL, "Unable to find Add Battery");
    }

    public void enterserialnumber(String serialnumber) {
        if(txt_serialnumber.isDisplayed())
        {
            txt_serialnumber.sendKeys(serialnumber);
            logger.log(LogStatus.PASS, "entered serial number Successfully");
        }
        else
        {
            logger.log(LogStatus.FAIL, "failed to enter serial number");
        }
    }

    public void enterqrcode(String qrcode)
    {
        if(txt_qrcode.isDisplayed())
        {
            txt_qrcode.sendKeys(qrcode);
            logger.log(LogStatus.PASS, "entered Qr code Successfully");
        }
        else
        {
            logger.log(LogStatus.FAIL, "failed to enter Qr code");
        }
    }

    public void selectManufacturerName(){
        if(dropdown_ManufacturerName.isDisplayed())
        {
            dropdown_ManufacturerName.click();
            logger.log(LogStatus.PASS, "Successfully clicked on ManufacturerName");

        }
        else
        {
            logger.log(LogStatus.FAIL, "failed to click ManufacturerName");
        }
    }

    public void selectMicronix()
    {
        if(Utilities.explicitWait(driver, Micronix, "clickable")){
            Micronix.click();
            logger.log(LogStatus.PASS, "Successfully selected micronix");
        }
        else
            logger.log(LogStatus.FAIL, "Unable to find micronix");

    }

    public void selectbatterytype(){
        if(dropdown_BatteryType.isDisplayed()){
            dropdown_BatteryType.click();
            logger.log(LogStatus.PASS, "Successfully clicked on batterytype");
        }
        else {
            logger.log(LogStatus.FAIL, "Unable to select batterytype");
        }
    }

    public void selectLithiumion()
    {
        if(Lithiumion.isDisplayed()){
            Lithiumion.click();

        }
        else
        {

        }
    }

    public void purchaseDate(String mm, String dd, String yyyy) {

        if (txt_PurchaseDate.isDisplayed()) {
            txt_PurchaseDate.sendKeys(mm);
            txt_PurchaseDate.sendKeys(dd);
            txt_PurchaseDate.sendKeys(yyyy);
            logger.log(LogStatus.PASS, "entered purchase date Successfully");
        }
        else
        {
            logger.log(LogStatus.FAIL, "failed to enter Purchase date");
        }
    }

    public void clickbtnCreatebattery()
    {
        if(btnCreatebattery.isDisplayed())
        {
            btnCreatebattery.click();
            logger.log(LogStatus.PASS, "Successfully click on btncreatebattery");
        }
        else {
            logger.log(LogStatus.FAIL, "failed to click btncreatebattery");
        }
    }

    public void createbattery(String serialnumber,String qrcode,String mm, String dd, String yyyy){
        inventory.clickbatteries();
        clickbtnAddbattery();
        enterserialnumber(serialnumber);
        selectManufacturerName();
        selectMicronix();
        selectbatterytype();
        selectMicronix();
        purchaseDate(mm,dd,yyyy);
//        purchaseDate("","","");
        enterqrcode(qrcode);
        clickbtnCreatebattery();

    }
}
