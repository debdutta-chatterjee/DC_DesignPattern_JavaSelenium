package com.design.patterns.factory;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager {
	
	WebDriver driver=null;
	
	public abstract void setPath();
	public abstract void launchBrowser();
	
	public void quitBrowser() 
	{
		driver.quit();
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
}
