package com.bude.genericmethods;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extent_Reports extends TestListenerAdapter {
	public ExtentTest testReporter;
	public static ExtentReports extentReport;
	public static ExtentTest logger;
	static String screenshotExtension,reportFolder,destination,screenshotPath,screenshotExtensions;
	//public String screenshotExtensions;
	static File folder;
	static String browserType,ImagePath;
	static WebDriver drivers;
	static int iFlag=0,intPos=0;
	//static String appVersion;
	public static String logExpected="<br><b><font color=#0d0d0f>Expected Result: </font></b>" ;
	public static String logActual="<br><b><font color=#0d0d0f>Actual  Result: </font></b>" ;

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.isSuccess()) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Test Case Pass :"+result.getName());
		}
		else if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Case Failed :"+result.getName());

		}
		else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(LogStatus.SKIP,"Test Case Skipped is :"+"_"+result.getName());

		}

		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public static void executionLog(String status,String Description,WebDriver driver) throws Exception
	{
		drivers=driver;
		switch(status.toUpperCase())
		{
		case "PASS":
			ExtentTestManager.getTest().log(LogStatus.PASS,driver.getCurrentUrl()+"\n"+Description);
			break;
		case "FAIL":
			ExtentTestManager.getTest().log(LogStatus.FAIL,driver.getCurrentUrl()+"\n"+Description);
			break;
		case "INFO":
			ExtentTestManager.getTest().log(LogStatus.INFO,driver.getCurrentUrl()+"\n"+Description);
			break;
		}

	}
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		getResult(result);


	}
	@AfterSuite
	public void afterSuite() {
		//System.out.println(ExtentManager.appVersion);

		extentReport.endTest(logger);
		ExtentManager.getInstance().flush();

	}
}