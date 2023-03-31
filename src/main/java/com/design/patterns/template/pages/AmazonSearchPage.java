package com.design.patterns.template.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.design.patterns.base.BasePage;

public class AmazonSearchPage extends BasePage
{	
	public AmazonSearchPage(WebDriver driver) {
		super(driver);
	}
		
	public String extractPrice(String productName) {
		return this.wait.until(ExpectedConditions.
				visibilityOfElementLocated((By.xpath("//a[contains(.,'"+productName+"')]"
						+ "/ancestor::*[@class='sg-row']//*[@class='a-price-whole']"))))
				.getText();
	}	
	
	public void navigateToProductPage(String productName) {
		this.wait.until(ExpectedConditions.
				visibilityOfElementLocated((By.xpath("//a[contains(.,'"+productName+"')]"))))
		.click();		
	}
}
