package com.bude.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bude.genericmethods.Utilities;
import com.relevantcodes.extentreports.ExtentTest;

public class CreateRiderGroupPage {

	private WebDriver driver;
	Utilities utilities = new Utilities();
	ExtentTest logger;

	public CreateRiderGroupPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements( driver, this);
	}
	@FindBy(xpath = "") WebElement menu_Configurations;
	@FindBy(xpath = "") WebElement submenu_RiderGroup;
	@FindBy(xpath = "") WebElement btn_NewGroup;
}
