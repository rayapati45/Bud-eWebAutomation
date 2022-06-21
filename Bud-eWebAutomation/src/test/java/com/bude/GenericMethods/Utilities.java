package com.bude.GenericMethods;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//Methods List
//------------explicitWait
//------------implicitWait

public class Utilities {

	static WebDriverWait wait;
	static WebElement elements;	
	static boolean element;	
	private enum  Property 
	{
		clickable, visible,invisible,display;
	}

	//=========================================================================================================

	public static boolean explicitWait(WebDriver driver, String locatorPath, String objectProperty)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		switch (objectProperty) 
		{
		case "clickable":
			elements = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorPath)));
			break;

		case "visible":
			elements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPath)));
			break;

		case "invisible":
			element = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorPath)));
			break;
		}
		return elements != null;		
	}

	//=========================================================================================================	

	public static void implicitWait(WebDriver driver,int Secs)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Secs));
	}

	//=========================================================================================================
	
	public static void scrollToElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	//=========================================================================================================
	
	//=========================================================================================================
	//=========================================================================================================
	//=========================================================================================================
	//=========================================================================================================
}