package com.design.patterns.proxy;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.design.patterns.base.BasePage;

public class LoginPage extends BasePage{
	
	private Map<String,String> loginMap;
	private UserLogin loginOption;
	
	public LoginPage(WebDriver driver,Map<String,String> loginMap)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		this.loginMap=loginMap;
	}
	
	@FindBy(xpath="//a[contains(.,'Sign in securely')]")
	private WebElement loginBtn;
		
	@FindBy(xpath="//input[@name='password']")
	private WebElement pwdTxtBox;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTxtBox;
	
	@FindBy(css="input#continue")
	private WebElement continueBtn;	
		
	private void navigateToLogin()
	{
		wait.until(d -> this.loginBtn.isDisplayed());
		this.loginBtn.click();
	}
	
	public void continueToLogin()
	{
		wait.until(d -> this.continueBtn.isDisplayed());
		this.continueBtn.click();
	}
	
	public void setPassword(String pwd)
	{
		wait.until(d -> this.pwdTxtBox.isDisplayed());
		this.pwdTxtBox.sendKeys(pwd);
	}
	
	private void setUser(String mobile)
	{
		wait.until(d -> this.emailTxtBox.isDisplayed());
		this.emailTxtBox.sendKeys(mobile);
	}
		
	public void login() {
		this.navigateToLogin();
		this.setUser(loginMap.get("mobile"));
		this.continueToLogin();
	}
	
	public void setUserLogin()
	{
		loginOption= new UserLoginProxy(driver);
	}
	
	public UserLogin getUserLogin()
	{
		return loginOption;
	}
}
