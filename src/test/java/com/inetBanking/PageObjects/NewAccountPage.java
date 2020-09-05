package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage extends BaseClass
{
	
		WebDriver ldriver;
		
		
		public NewAccountPage(WebDriver rdriver)
		{
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
			
		}
	
	
		@FindBy(name="cusid")
		@CacheLookup
		WebElement custID;
		
		
		@FindBy(name="selaccount")
		@CacheLookup
		WebElement selectDropDown;
		
		
		
		@FindBy(name="inideposit")
		@CacheLookup
		WebElement initialDepo;
		
		@FindBy(name="button2")
		@CacheLookup
		WebElement submitBtn;
		
		
		public void setCustId(String custid)
		{
			custID.sendKeys(custid);
		}
		
		
		public void selectDropdown()
		{
			selectDropDown.click();
			Select select=new Select(selectDropDown);
			select.selectByVisibleText("Current");	
		}
		
		
		public void setinitialDepo(String initdepo)
		{
			initialDepo.sendKeys(initdepo);
		}
		
		
		public void submitClick()
			
		{
			submitBtn.click();
		}

		
		
		
		
		
}
