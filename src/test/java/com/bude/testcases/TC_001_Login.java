package com.bude.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bude.pages.LoginPage;

public class TC_001_Login extends BaseTest{

	@Test
	@Parameters(value={"username","password","browser"})
	public void loginToBude(String username, String password, String browser) throws Exception {
		LoginPage lpage = new LoginPage(driver,logger);
		lpage.login(username,password);
	}
}
