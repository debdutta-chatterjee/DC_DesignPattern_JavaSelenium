package com.design.patterns.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserLoginInvalid implements UserLogin{

	@FindBy(xpath="//*[contains(text(),'Enter your email or mobile phone number')]")
	private WebElement alertText;
	
	WebDriver driver;
	WebDriverWait wait;
		
	public UserLoginInvalid(WebDriver driver)
	{
		this.driver = driver;
		wait= new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	}
		
	@Override
	public boolean verifyLogin() {
		return this.verifyAlertText();
	}
	
	public boolean verifyAlertText()
	{
		return wait.until(d -> this.alertText.isDisplayed());
	}	
}
