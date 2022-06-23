package com.bude.testrunner;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.TestNG;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.bude.genericmethods.DatabaseFunction;

public class TestRunner
{
	public Hashtable<String, String> htTestRunner;
	public List<String> lstBrowser,lstExecutionType,lstBrowserVersion,lstOS,lstOSVersion;
	public int poolSize=0,executionCnt=0;
	public String browsers;

	@Test
	//@Parameters(value={"aut"})
	public void tRun(String aut)
	{

		DatabaseFunction objDBF= new DatabaseFunction();

		switch (aut.toUpperCase()) 
		{	
		case "CHROME":
			lstExecutionType = objDBF.getTestDataObject("Select ExecutionType from TestSuite Where Execution ='Yes' and Browser='Chrome'","TestRunner");
			if(!lstExecutionType.isEmpty())
			{
				if(lstExecutionType.get(0).compareToIgnoreCase("Remote")== 0)
				{
					poolSize=2;
					htTestRunner=objDBF.getHashTestData("Select * from TestSuite Where Execution ='Yes' AND Browser='Chrome'","TestRunner");
					aut="REMOTE";
					executionCnt=htTestRunner.size();
					System.out.println("Chrome:"+htTestRunner.size());
				}
				else if(lstExecutionType.get(0).compareToIgnoreCase("Grid")== 0)
				{
					htTestRunner=objDBF.getHashTestData("Select * from TestSuite Where Execution ='Yes' AND Browser='Chrome'","TestRunner");
					aut="Grid";
					poolSize=6;
					executionCnt=htTestRunner.size();
					System.out.println("Chrome:"+htTestRunner.size());

				}
				else
				{
					htTestRunner=objDBF.getHashTestData("Select * from TestSuite Where Execution ='Yes' AND ExecutionType='" +aut+"'","TestRunner");
					poolSize=1;
					executionCnt=htTestRunner.size();
					System.out.println("Chrome:"+htTestRunner.size());

				}
			}
		}
	}

}