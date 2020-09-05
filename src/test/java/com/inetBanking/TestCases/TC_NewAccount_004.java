package com.inetBanking.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.PageObjects.BaseClass;
import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.PageObjects.NewAccountPage;

public class TC_NewAccount_004 extends BaseClass
{
	
	@Test
	public void NewAccountCration() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername("mngr283121");
		
		
		lp.setPassword("AqYduhu");
		lp.loginClick();
	
		driver.get("http://demo.guru99.com/v3/manager/addAccount.php");
		NewAccountPage na=new NewAccountPage(driver);
		na.setCustId("12345");
		na.selectDropdown();
		na.setinitialDepo("2000");
		na.submitClick();
		
		
	}

}
