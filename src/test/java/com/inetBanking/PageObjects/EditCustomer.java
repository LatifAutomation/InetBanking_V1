package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer
{

	WebDriver ldriver;
	
	public EditCustomer(WebDriver rdriver)
	
	{   ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(partialLinkText="Edit Customer")
	@CacheLookup
	WebElement editlink;
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement custId;

   @FindBy(name="AccSubmit")
   @CacheLookup
   WebElement submitButton;

   
   @FindBy(name="res")
   @CacheLookup
   WebElement resettButton;
   
   
   public void clickEdit()
   {
      editlink.click();
   }
   
   public void custid(String custid)
   
   {
	  custId.sendKeys(custid);   
   }
   
   public void submitButton()
   {
	   submitButton.click();
   }
   
   public void resettButton()
   {
	   resettButton.click();
   }
   
   
   
}
