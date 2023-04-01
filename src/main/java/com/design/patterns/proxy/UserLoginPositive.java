package com.design.patterns.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserLoginPositive implements UserLogin{

	@FindBy(css="a#ap_change_login_claim")
	private WebElement changeLogin;
		
	WebDriver driver;
	WebDriverWait wait;
		
	public UserLoginPositive(WebDriver driver)
	{
		this.driver = driver;
		wait= new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	}
		
	@Override
	public boolean verifyLogin() {
		return this.verifyChangeLoginClaim();
	}

	public boolean verifyChangeLoginClaim()
	{
		return wait.until(d -> this.changeLogin.isDisplayed());
	}
}
