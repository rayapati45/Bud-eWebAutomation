package com.bude.TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bude.Pages.CreateCityPage;
import com.bude.Pages.LoginPage;

public class TC_004_CreateCity extends BaseTest{

	@Test
	@Parameters(value={"username","password","browser"})
	public void createCity(String username, String password, String browser) throws Exception {
		LoginPage lpage = new LoginPage(driver,logger);
		driver = lpage.login(username,password);
		CreateCityPage newCity = new CreateCityPage(driver,logger);
		newCity.createNewCity();
	}
}
