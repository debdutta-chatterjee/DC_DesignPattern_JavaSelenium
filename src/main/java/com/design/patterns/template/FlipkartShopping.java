package com.design.patterns.template;

import org.openqa.selenium.WebDriver;

import com.design.patterns.singleton.util.UrlResolver;
import com.design.patterns.template.pages.FlipkartHomePage;
import com.design.principles.openclose.ConfigProfile;
import com.design.principles.openclose.PropertyType;

public class FlipkartShopping extends ShoppingTemplate{

	FlipkartHomePage homePage;	
	String productName;
	
	public FlipkartShopping(WebDriver driver,String productName,ConfigProfile config)
	{
		super(driver,config);
		homePage= new FlipkartHomePage(driver);
		this.productName=productName;
	}
	
	
	@Override
	public void assertHomePage() {
		this.homePage.assertHomePageLogo();		
	}

	@Override
	public void navigateToProductPage() {
		this.homePage.navigateToProductPage(productName);		
	}

	@Override
	public void searchProduct() {
		this.homePage.searchProduct(productName);
	}

	@Override
	public String extractPrice() {
		return this.homePage.extractPrice(productName);
	}

	@Override
	public void goTo() {
		super.driver.get(UrlResolver.getUrl(config,PropertyType.FlipkartUrl.toString()));
	}	
}
