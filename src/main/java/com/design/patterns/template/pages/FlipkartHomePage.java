package com.design.patterns.template.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.design.patterns.base.BasePage;

public class FlipkartHomePage extends BasePage
{

	public FlipkartHomePage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//a/img[@title='Flipkart']")
	private WebElement homePageLogo;
	
	@FindBy(xpath="//input[contains(@title,'Search for products')]")
	private WebElement searchTxtBox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchBtn;
	
	By homePageCrossLogin_btn=By.xpath("//span[contains(text(),'Get access')]/ancestor::div[@tabIndex]/div/button");
		
	private WebElement productLink(String productName) 
	{
		return this.wait.until(ExpectedConditions.
				visibilityOfElementLocated((By.xpath("//div[contains(text(),'"
		+productName+"')]/ancestor::a"))));
	}
	
	public String extractPrice(String productName) {
		return this.wait.until(ExpectedConditions.
				visibilityOfElementLocated((By.xpath("(//div[contains(text(),'"+productName+"')]"
						+ "/ancestor::a//div[contains(text(),'₹')])[1]"))))
				.getText();
	}	
	
	public void navigateToProductPage(String productName) {
		productLink(productName).click();		
	}
	
	public void searchProduct(String productName) 
	{
		wait.until(d -> this.searchTxtBox.isDisplayed());
		this.searchTxtBox.sendKeys(productName);
		this.searchBtn.click();
	}	
	
	public void assertHomePageLogo() 
	{
		try {
			this.wait.until(ExpectedConditions.
					visibilityOfElementLocated((homePageCrossLogin_btn))).click();
		} catch (Exception e) {}
		
		wait.until(d -> this.homePageLogo.isDisplayed());
	}
}
