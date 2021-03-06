package com.inetBanking.PageObjects;


import java.io.File;
import java.io.IOException;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.ReadConfig;


public class BaseClass 
{
	
	ReadConfig readconfig=new ReadConfig();
	
	public static Logger logger;
	
public String URL=readconfig.getApplicationURL();
public String username=readconfig.getUsername();
public String password=readconfig.getPassword(); 
public static WebDriver driver;

@Parameters("browser")
@BeforeClass
public void setUp(String br)
{
	
	if(br.equals("chrome"))
	{
		System.setProperty("Webdriver.chrome.driver", readconfig.getChromePath());
		//System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(br.equals("firefox"))
	{
		System.setProperty("Webdriver.gecko.driver", readconfig.getFirefoxPath());
		driver=new FirefoxDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("http://demo.guru99.com/v3/index.php");
	//http://demo.guru99.com/v3/manager/addAccount.php
	//Logger logger=Logger.getLogger("InetBanking_v1");
	PropertyConfigurator.configure("Log4j.properties");

}
	
@AfterClass
public void tearDown()
{
	driver.quit();
}

public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	
	System.out.println("Screenshot taken");
	
}

public String randomestring()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
}
}


