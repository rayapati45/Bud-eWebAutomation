package com.bude.TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bude.Pages.LoginPage;

public class TC_005_CreateRiderGroup extends BaseTest{

	@Test
	@Parameters(value={"username","password","browser"})
	public void createRiderGroup(String username, String password, String browser) throws Exception {
		LoginPage lpage = new LoginPage(driver,logger);
		lpage.login(username,password);
		
	}
}
