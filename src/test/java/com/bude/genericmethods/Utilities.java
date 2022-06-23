package com.bude.genericmethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Methods List
//------------explicitWait
//------------implicitWait
//------------scrollToElement
//------------captureScreen
//------------getScreenPath
//------------

public class Utilities {

	static WebDriverWait wait;
	static WebElement elements;	
	static boolean element;	

	//=========================================================================================================

	public static boolean explicitWait(WebDriver driver, WebElement element, String objectProperty)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		switch (objectProperty) 
		{
		case "clickable":
			elements = wait.until(ExpectedConditions.elementToBeClickable(element));
			break;

		case "visible":
			//elements = wait.until(ExpectedConditions.visibilityOfAllElements(element);
			break;

		case "invisible":
			//element = wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
			break;
		}
		return elements != null;		
	}

	//=========================================================================================================	

	public static void implicitWait(WebDriver driver,int Secs)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Secs));
		//driver.manage().timeouts().implicitlyWait(i);
	}

	//=========================================================================================================
	
	public static void scrollToElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	//=========================================================================================================
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
	}
	
	//=========================================================================================================
	
	public String getScreenPath(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\Screenshots\\" + tname + ".png";
		File target = new File(dest);
		FileUtils.copyFile(source, target);
		return dest;
	}
	
	//=========================================================================================================
	
	
	
	//=========================================================================================================
	
	
	
	//=========================================================================================================
	
	
	
	//=========================================================================================================
}