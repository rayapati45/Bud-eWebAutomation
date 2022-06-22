package com.bude.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bude.GenericMethods.Utilities;
import com.relevantcodes.extentreports.ExtentTest;

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

	public void clickMenuCofig() {
		if(Utilities.explicitWait(driver, menu_Configurations, "clickable"))
			menu_Configurations.click();
	}

	public void clickSunMenuCity() {
		if(Utilities.explicitWait(driver, submenu_City, "clickable"))
			submenu_City.click();
	}

	public void clickBtnAddCity() {
		if(Utilities.explicitWait(driver, btn_NewCity, "clickable"))
			btn_NewCity.click();
	}

	public WebDriver createNewCity() {
		clickMenuCofig();
		clickSunMenuCity();
		clickBtnAddCity();
		return driver;
	}
}
