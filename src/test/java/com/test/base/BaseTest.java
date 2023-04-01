package com.test.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.design.patterns.factory.WebDriverManagerFactory;
import com.design.patterns.factory.WebDriverType;
import com.google.common.util.concurrent.Uninterruptibles;

public class BaseTest {
	
	protected WebDriver driver; 
	private WebDriverManagerFactory driverManagerFactory;
	
	@BeforeTest
	public void beforeTest()
	{
		driverManagerFactory = new WebDriverManagerFactory();
		this.driver=driverManagerFactory.getDriverManager(WebDriverType.Chrome).getDriver();
	}
	
	
	@AfterTest
	public void adfterTest()
	{
		//Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		//driver.close();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		driver.close();
		driver.quit();
	}	
}
