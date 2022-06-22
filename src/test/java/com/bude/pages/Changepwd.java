package com.bude.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bude.genericmethods.Utilities;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Changepwd {

	private WebDriver driver;
	Utilities utilities = new Utilities();
	ExtentTest logger;

	public Changepwd(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements( driver, this);
	}
	@FindBy(xpath = "//button[@class= 'p-splitbutton-menubutton p-button p-component p-button-icon-only']") WebElement Home_menuLogout;
	@FindBy(xpath = "//a[@class='p-menuitem-link p-ripple ng-star-inserted']") WebElement lnkchangepwd;
	@FindBy(xpath = "//input[@id='currentPassword']") WebElement Currentpwd;
	@FindBy(xpath = "//input[@id='newPassword']") WebElement NewPwd;
	@FindBy(xpath = "//input[@id='confirmPassword']") WebElement confirmpwd;
	@FindBy(xpath = "//button[contains(@class,'p-button-warning p-mr-2 p-button p-component')]") WebElement btnconfirmpwd;

	public void ChangepwdforBude() throws InterruptedException {
		Utilities.explicitWait(driver, Home_menuLogout, "clickable");
		if(Home_menuLogout.isDisplayed()) {
			Home_menuLogout.click();
			Utilities.explicitWait(driver, lnkchangepwd, "clickable");
			lnkchangepwd.click();
			logger.log(LogStatus.PASS, "Successfully Clicked on Change Password");
		}
	}

	public void SetCurrentpwd(String currentpwd) {
		//Currentpwd.click();
		Currentpwd.sendKeys(currentpwd);
		logger.log(LogStatus.PASS, "Successfully Entered Current Password");
	}

	public void SetNewpwd(String newpwd) {
		NewPwd.sendKeys(newpwd);
		logger.log(LogStatus.PASS, "Successfully Entered New Password");
		}

	public void SetConfirmpwd(String Confirmpwd){ 
		confirmpwd.sendKeys(Confirmpwd);
		logger.log(LogStatus.PASS, "Successfully Entered Confirm New Password");
		}

	public void btnconfirmpwd() { 
		btnconfirmpwd.click();
		logger.log(LogStatus.PASS, "Successfully clicked on Change Password & Password Changed Successfully");
		}

	public WebDriver Changepassowrd(String Currentpwd,String Newpwd,String Confirmpwd) throws InterruptedException
	{   
		Utilities.explicitWait(driver, Home_menuLogout, "clickable");
		ChangepwdforBude();
		
		SetCurrentpwd(Currentpwd);
		Utilities.implicitWait(driver,10);
		SetNewpwd(Newpwd);
		Utilities.implicitWait(driver,10);
		SetConfirmpwd(Confirmpwd);
		Utilities.implicitWait(driver,10);
		btnconfirmpwd();
		return driver;

	}


}
