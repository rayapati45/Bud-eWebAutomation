package com.bude.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bude.genericmethods.Utilities;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage {

	private WebDriver driver;
	Utilities utilities = new Utilities();
	ExtentTest logger;

	public LoginPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements( driver, this);
	}

	@FindBy(name="name") WebElement txtUsername;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(xpath = "//span[normalize-space()='Login']") WebElement btnLogin;
	@FindBy() WebElement lnkForgotPassword; 
	@FindBy() WebElement txtEmailForForgotPassword;

	public void setUsername(String username) throws Exception {
		if(txtUsername.isDisplayed())
		{
			txtUsername.sendKeys(username);
			logger.log(LogStatus.PASS, "Username: "+username+" Entered Successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Failed to Enter Username: "+username);
		}
	}
	public void setPassword(String password) throws Exception {
		if(txtPassword.isDisplayed())
		{
			txtPassword.sendKeys(password);
			logger.log(LogStatus.PASS, "Password: "+password+" Entered Successfully");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Failed to Enter Username: "+password);
		}
	}
	public void clkLogin(String username,String password) throws Exception {
		if(btnLogin.isDisplayed() && btnLogin.isEnabled())
		{
			btnLogin.click();
			logger.log(LogStatus.PASS, "Clicked Login Button");
			Thread.sleep(2000);
			String screenshotPath = utilities.getScreenPath(driver, "CityCreation");
			if(driver.getCurrentUrl().contains("/#/main/")){
				logger.log(LogStatus.PASS, "Login is Successfull");
				logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));
			}
			else {
				
				logger.log(LogStatus.FAIL, "Failed to Login with username: "+username+" & password: "+password);
				logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
			}
		}
		else
		{
			logger.log(LogStatus.FAIL, "Failed click login button");
		}
	}

	public WebDriver login(String username, String password) throws Exception
	{
		setUsername(username);
		setPassword(password);
		clkLogin(username,password);
		return driver;
	}


}
