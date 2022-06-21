package com.bude.TestCases;

import com.bude.Pages.Changepwd;
import com.bude.Pages.LoginPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class TC_003_ChangePassword extends BaseTest {



    @Test
	@Parameters(value = {"username", "password","Currentpwd", "newpwd", "Confirmpwd","browser"})
	public void Changepwd(String username,String password,String currentpwd, String newpwd, String confirmpwd,String browser) throws Exception {
		
    	LoginPage lpage = new LoginPage(driver,logger);
		driver = lpage.login(username, password);
		Changepwd cp = new Changepwd(driver,logger);
		driver = cp.Changepassowrd(currentpwd, newpwd, confirmpwd);
	}


}
