package com.design.patterns.proxy;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserLoginProxy implements UserLogin{

	List<String> allowedConditions= Arrays.asList("qa","negative");
	UserLogin loginComponent;
	WebDriver driver;
	WebDriverWait wait;
	
	public UserLoginProxy(WebDriver driver)
	{
		this.driver = driver;
		wait= new WebDriverWait(driver,5);
		
		if(System.getProperty("env_condition").contains("positive"))
		{
			loginComponent = new UserLoginPositive(driver);
		}
		else if(allowedConditions.contains(System.getProperty("env_condition")))
		{
			loginComponent = new UserLoginNegative(driver);
		}
		else
		{
			loginComponent = new UserLoginInvalid(driver);
		}
			
	}
	
	
	@Override
	public boolean verifyLogin() {
		return loginComponent.verifyLogin();
	}

}
