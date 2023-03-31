package com.design.patterns.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.design.patterns.base.BasePage;

public class AmazonHomePage extends BasePage
{

	public AmazonHomePage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(css="#twotabsearchtextbox")
	private WebElement searchTxtBox;
	
	@FindBy(css="#nav-search-submit-button")
	private WebElement searchBtn;
	
	@FindBy(css="#nav-logo-sprites")
	private WebElement homePageLogo;
		
	public void searchProduct(String productName) 
	{
		wait.until(d -> this.searchTxtBox.isDisplayed());
		this.searchTxtBox.sendKeys(productName);
		this.searchBtn.click();
	}	
	
	public void assertHomePageLogo() 
	{
		wait.until(d -> this.homePageLogo.isDisplayed());
	}
}
