package com.bude.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bude.pages.CreateCityPage;
import com.bude.pages.LoginPage;


public class TC_004_CreateCity extends BaseTest{

	@Test
	@Parameters(value={"username","password","browser"})
	public void createCity(String username, String password, String browser) throws Exception {
		LoginPage lpage = new LoginPage(driver,logger);
		driver = lpage.login(username,password);
		CreateCityPage newCity = new CreateCityPage(driver,logger);
		newCity.createNewCity("Automation","Automation1 by Venkat");
	}
}
