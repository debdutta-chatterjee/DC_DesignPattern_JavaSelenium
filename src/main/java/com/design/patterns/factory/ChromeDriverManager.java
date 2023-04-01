package com.design.patterns.factory;

import org.openqa.selenium.chrome.ChromeDriver;

import com.design.patterns.singletonUtil.PropertiesUtil;
import com.design.principles.openclose.PropertyType;

public class ChromeDriverManager extends WebDriverManager{

	public ChromeDriverManager()
	{
		setPath();
		launchBrowser();
	}
	
	@Override
	public void setPath() 
	{
		System.setProperty("webdriver.chrome.driver", 
				PropertiesUtil.getProperty(PropertyType.Chrome_Driver.toString()));
	}

	@Override
	public void launchBrowser() {
		driver= new ChromeDriver();
	}
}
