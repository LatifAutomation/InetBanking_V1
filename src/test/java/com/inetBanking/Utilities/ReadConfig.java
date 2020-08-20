package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties prop;
	
	public ReadConfig()
	{
		
		File src=new File("./Configurations/config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
		
	}

	public String getApplicationURL()
	{
	String url = prop.getProperty("URL");
	return url;
	
	}
	
	public String getUsername()
	{
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String pass = prop.getProperty("password");
		return pass;
	}
	
	public String getChromePath()
	{
		String chrome= prop.getProperty("chromepath");
		return chrome;
	}
	
	public String getFirefoxPath()
	{
		String fireFox= prop.getProperty("firefoxpath");
		return fireFox;
	}
	
	
}


