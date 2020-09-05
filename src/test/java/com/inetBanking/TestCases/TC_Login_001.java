package com.inetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.BaseClass;
import com.inetBanking.PageObjects.LoginPage;


public class TC_Login_001 extends BaseClass
{

   @Test
	public void loginTest() throws IOException
	 {
	      
	     //logger.info("URL is opened");
		 LoginPage lp=new LoginPage(driver);
		 
		//lp.setUsername(username);
		 lp.setUsername("mngr278151");
		 //logger.info("Entered Username");
		 lp.setPassword("UgajYmU");
		// lp.setPassword(password);
		//logger.info("Entered Password");
		 lp.loginClick();
		 
		 if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		 {
			 Assert.assertTrue(true);
			// logger.info("Test Case is passed");
		 }
		 
		 else
		 {
			 captureScreen(driver,"logintest");
			 Assert.assertTrue(false);
			logger.info("Test Case is failed"); 
		 }
	 }
}
