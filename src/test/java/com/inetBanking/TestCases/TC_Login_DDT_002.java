package com.inetBanking.TestCases;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.BaseClass;
import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.Utilities.XLUtils;

import junit.framework.Assert;

public class TC_Login_DDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginddt(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(user);
		lp.setPassword(pwd);
		lp.loginClick();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			lp.logoutClick();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent(); 
		}
	}
	
	public boolean isAlertPresent() //user defined method
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path="C://Latif-Self-Automation//InetBanking_V1//src//test//java//com//inetBanking//TestData//LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1",1);
		String logindata[][]= new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
		
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", 1, 0);
			}
		}
		return logindata;
	}
}
