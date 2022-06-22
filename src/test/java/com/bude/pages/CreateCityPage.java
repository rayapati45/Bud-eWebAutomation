package com.bude.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bude.genericmethods.Utilities;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateCityPage {

	private WebDriver driver;
	Utilities utilities = new Utilities();
	ExtentTest logger;

	public CreateCityPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements( driver, this);
	}
	@FindBy(xpath = "//span[text()='Configurations']") WebElement menu_Configurations;
	@FindBy(xpath = "//span[text()='Cities']") WebElement submenu_City;
	@FindBy(xpath = "//button[@class='p-button-success p-mr-2 p-button p-component']") WebElement btn_NewCity;
	@FindBy(xpath = "//input[@formcontrolname=\"cityName\"]") WebElement txt_cityName;
	@FindBy(xpath = "//textarea[@formcontrolname=\"description\"]") WebElement txt_cityDescription;
	@FindBy(xpath = "//button[@class='p-button p-button-warning p-component ng-star-inserted']") WebElement btn_AddCity;

	public void clickMenuCofig() {
		if(Utilities.explicitWait(driver, menu_Configurations, "clickable"))
		{
			menu_Configurations.click();
			logger.log(LogStatus.PASS, "Successfully clicked on Cofig Menu");
		}
		else
			logger.log(LogStatus.FAIL, "Unable to find Cofig Menu");
	}

	public void clickSunMenuCity() {
		if(Utilities.explicitWait(driver, submenu_City, "clickable"))
		{
			submenu_City.click();
			logger.log(LogStatus.PASS, "Successfully clicked on City sub Menu");
		}
		else
			logger.log(LogStatus.FAIL, "Unable to find City sub Menu");
	}

	public void clickBtnAddCity() {
		if(Utilities.explicitWait(driver, btn_NewCity, "clickable"))
		{
			btn_NewCity.click();
			logger.log(LogStatus.PASS, "Successfully clicked on Add City Button");
		}
		else
			logger.log(LogStatus.FAIL, "Unable to find Add City Button");
	}

	public void setCityName(String name) {
		logger.log(LogStatus.INFO, "City Name---- "+name);
		//if(txt_cityName.isDisplayed())
		//{
		txt_cityName.sendKeys(name);
		logger.log(LogStatus.PASS, "Entered City Name Successfully");
		//}else {
		//	logger.log(LogStatus.FAIL, "Failed to Enter Text in Name Field "+txt_cityName);
		//}
	}

	public void setCityDesc(String desc) {
		//if(txt_cityDescription.isDisplayed())
		//{
		txt_cityDescription.sendKeys(desc);
		logger.log(LogStatus.PASS, "Entered City Description Successfully");
		//}else {
		//	logger.log(LogStatus.FAIL, "Failed to Enter Text in Description");
		//}
	}
	
	public void clickBtnAddCityFinal() {
		//if(Utilities.explicitWait(driver, btn_NewCity, "clickable"))
		//{
			btn_AddCity.click();
			logger.log(LogStatus.PASS, "Clicked on Add City Successfully");
		//}
		//else
			//logger.log(LogStatus.FAIL, "Unable to find Add City Button");
	}

	public WebDriver createNewCity(String name,String desc) throws InterruptedException, IOException {
		clickMenuCofig();
		clickSunMenuCity();
		clickBtnAddCity();
		utilities.captureScreen(driver,"11");
		setCityName(name);
		setCityDesc(desc);
		utilities.captureScreen(driver,"22");
		clickBtnAddCityFinal();
		Thread.sleep(2000);
		utilities.captureScreen(driver,"33");
		return driver;
	}
}
