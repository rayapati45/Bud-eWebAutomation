package com.bude.testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.bude.genericmethods.ExtentManager;
import com.bude.genericmethods.ExtentTestManager;
import com.bude.genericmethods.Readconfig;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class BaseTest {

	Readconfig readconfig=new Readconfig();
	public String baseURL=readconfig.getApplicationURL();

	public static ExtentTest logger;
	public static ExtentReports extentReport;
	
	protected WebDriver driver;
	public static String env;
	public static  String buildNumber=" ";
	private static String  genericPath=System.getProperty("user.dir").concat("\\DriverExecutable\\");

	@BeforeMethod
	public  void getBrowser(ITestContext context) throws MalformedURLException 
	{	
		String browser = "Chrome";
		logger=ExtentTestManager.startTest(this.getClass().getSimpleName());
		logger.log(LogStatus.INFO,"Test "+this.getClass().getSimpleName()+ " Started");
		switch (browser.toUpperCase()) 
		{
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", genericPath+"geckodriver.exe");
			if (driver == null) 
			{
				System.out.println("baseURL---------"+baseURL);
				driver = new FirefoxDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.get(baseURL);
			}
			break;
		case "IE":
			if (driver == null) 
			{
				System.setProperty("webdriver.ie.driver", genericPath+"IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();

				driver.get(baseURL);
			}
			break;

		case "CHROME":
			if (driver == null) 
			{
				System.setProperty("webdriver.chrome.driver",genericPath+"chromedriver.exe");
				driver = new ChromeDriver();
				logger.log(LogStatus.PASS, browser+" Browser Launched Successfully");
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.get(baseURL);
				System.out.println("baseURL---------"+baseURL);
			}
			break;

		}
	}
	
//	@AfterSuite
//	public void afterSuite() {
//		extentReport.endTest(logger);
//		ExtentManager.getInstance().flush();
//
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

}
