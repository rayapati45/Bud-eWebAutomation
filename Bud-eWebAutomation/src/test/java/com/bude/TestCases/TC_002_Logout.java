package com.bude.TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bude.Pages.LoginPage;
import com.bude.Pages.Logoutpage;

public class TC_002_Logout extends BaseTest{

	@Test
	@Parameters(value={"username","password","browser"})
	public void logoutFromBude(String username, String password, String browser) throws Exception {
		LoginPage lpage = new LoginPage(driver,logger);
		driver = lpage.login(username, password);
		Logoutpage loutpage = new Logoutpage(driver,logger);
		loutpage.logout();
	}
}
