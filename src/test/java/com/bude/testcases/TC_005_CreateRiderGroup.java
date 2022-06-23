package com.bude.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bude.pages.CreateRiderGroupPage;
import com.bude.pages.LoginPage;

public class TC_005_CreateRiderGroup extends BaseTest{

	@Test
	@Parameters(value={"username","password","browser"})
	public void createRiderGroup(String username, String password, String browser) throws Exception {
		LoginPage lpage = new LoginPage(driver,logger);
		driver = lpage.login(username,password);
		CreateRiderGroupPage newGroup = new CreateRiderGroupPage(driver,logger);
		newGroup.createRiderGroup();
	}
}
