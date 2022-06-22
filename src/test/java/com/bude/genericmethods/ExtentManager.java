package com.bude.genericmethods;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports instance;
	static String screenshotExtension,reportFolder,destination,screenshotPath,screenshotExtensions;
	static File folder;
	static String browserType,ImagePath,appVersion;
	static WebDriver drivers;
	static int iFlag=0;

	public static synchronized ExtentReports getInstance() {
		if (instance == null) {
			System.out.println("---------------"+System.getProperty("user.dir"));
			SimpleDateFormat sdfDateReport = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			Date now = new Date();
			screenshotExtension=sdfDateReport.format(now) +"_"+System.currentTimeMillis();
			if(iFlag == 0)
			{
				folder = new File(System.getProperty("user.dir") +"/ReportGenerator/Bud-e_Automation__"+screenshotExtension);
				
				if(!folder.exists())
				{
					folder.mkdir();
					iFlag=1;
				}
			}
			instance=new ExtentReports(folder+"/Bud-e_Automation"+ sdfDateReport.format(now) +".html",true);
		}
		return instance;
	}
}
