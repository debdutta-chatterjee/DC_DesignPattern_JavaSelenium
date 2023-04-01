package com.design.patterns.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserLoginNegative implements UserLogin{
	
	@FindBy(css="div#auth-error-message-box")
	private WebElement errorMessage;
	
	WebDriver driver;
	WebDriverWait wait;
		
	public UserLoginNegative(WebDriver driver)
	{
		this.driver = driver;
		wait= new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	}
		
	@Override
	public boolean verifyLogin() {
		return this.verifyErrorText();
	}
	
	public boolean verifyErrorText()
	{
		return wait.until(d -> this.errorMessage.isDisplayed());
	}
}
