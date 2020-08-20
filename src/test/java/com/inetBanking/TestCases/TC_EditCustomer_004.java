package com.inetBanking.TestCases;

import org.testng.annotations.Test;

import com.inetBanking.PageObjects.BaseClass;
import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.PageObjects.EditCustomer;
public class TC_EditCustomer_004 extends BaseClass
{
	
    @Test
    public void EditCustomer()
    {
    	
    
	LoginPage lp=new LoginPage(driver);
	lp.setUsername("mngr278151");
	lp.setPassword("UgajYmU");
	lp.loginClick();
	 EditCustomer ec=new EditCustomer(driver);
	 ec.clickEdit();
	 ec.custid("123456");
	 ec.submitButton();
	 
	 

	 
	
}
}