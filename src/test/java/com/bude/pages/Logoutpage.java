package com.bude.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Logoutpage {


	private WebDriver driver;
	ExtentTest logger;

	public Logoutpage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath="//button[@class= 'p-splitbutton-menubutton p-button p-component p-button-icon-only']") WebElement Home_menuLogout;
	@FindBy(xpath = "//span[@class='p-menuitem-text ng-star-inserted' and text() ='Logout']") WebElement lnklogout;
	@FindBy(xpath = "//span[@class='p-button-label' and text() ='Yes, Logout']") WebElement btnconfrimLogout;

	public void logout() throws InterruptedException {
		Thread.sleep(4000);
		if(Home_menuLogout.isDisplayed())
		{
			Home_menuLogout.click();
			Thread.sleep(4000);
			if(lnklogout.isDisplayed())
			{
				lnklogout.click();
				Thread.sleep(4000);
				if(btnconfrimLogout.isDisplayed())
				{
					btnconfrimLogout.click();
					logger.log(LogStatus.PASS, "Successfully Logged out from Application");
				}
				else {
					logger.log(LogStatus.FAIL, "Unable to Logout");
				}
			}else {
				logger.log(LogStatus.FAIL, "Unable to Logout");
			}
		}
		else {
			logger.log(LogStatus.FAIL, "Unable to Logout");
		}
	}
}
