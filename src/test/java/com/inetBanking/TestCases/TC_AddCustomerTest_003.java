package com.inetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.AddCustomerPage;
import com.inetBanking.PageObjects.BaseClass;
import com.inetBanking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
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
	 Thread.sleep(3000);
	 
	 AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		Thread.sleep(3000);
		//addcust.clickAddNewCustomer();
		addcust.custName("Latif");
		addcust.custgender("Male");
		addcust.custdob("15", "06","19994");
		addcust.custaddress("Pune");
	    addcust.custcity("Pune");
	    addcust.custstate("Maharashtra");
	    addcust.custpinno("414402");
	    addcust.custtelephoneno("4569871230");
	    String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
	    Thread.sleep(3000);
	    
	    Alert alert=driver.switchTo().alert();
	    String alerttext = alert.getText();
	    System.out.println(alerttext);
	
	  /*  boolean res=driver.getPageSource().contains("please fill all fields");
		
	    
	    
	    
	 
	
	if(res==true)
	{
		Assert.assertTrue(true);
		logger.info("test case passed....");
		
	}
	else
	{
		logger.info("test case failed....");
		captureScreen(driver,"addNewCustomer");
		Assert.assertTrue(false);
	}
	
	*/
	    
	    if(alerttext=="please fill all fields")
	    {
	    	alert.accept();
	    	Assert.assertTrue(true);
	    }
	    
	    else
	    {
	    	//alert.accept();
	    	Assert.assertTrue(false);
	    }
	    	
	    }
	

 
}