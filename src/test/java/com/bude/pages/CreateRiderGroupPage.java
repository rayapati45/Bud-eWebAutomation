package com.bude.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bude.genericmethods.Utilities;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateRiderGroupPage {

	private WebDriver driver;
	Utilities utilities = new Utilities();
	ExtentTest logger;

	public CreateRiderGroupPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements( driver, this);
	}
	@FindBy(xpath = "//span[text()='Configurations']") WebElement menu_Configurations;
	@FindBy(xpath = "//span[text()='Rider Groups']") WebElement submenu_RiderGroup;
	@FindBy(xpath = "//button[@class='p-button-success p-button p-component']") WebElement btn_NewGroup;
	
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
		if(Utilities.explicitWait(driver, submenu_RiderGroup, "clickable"))
		{
			submenu_RiderGroup.click();
			logger.log(LogStatus.PASS, "Successfully clicked on Rider Groups sub Menu");
		}
		else
			logger.log(LogStatus.FAIL, "Unable to find Rider Groups sub Menu");
	}
	
	public void clickBtnAddCity() {
		if(Utilities.explicitWait(driver, btn_NewGroup, "clickable"))
		{
			btn_NewGroup.click();
			logger.log(LogStatus.PASS, "Successfully clicked on New Group Button");
		}
		else
			logger.log(LogStatus.FAIL, "Unable to find New Group Button");
	}
	
	public void createRiderGroup() {
		clickMenuCofig();
		clickSunMenuCity();
		clickBtnAddCity();
	}
}
