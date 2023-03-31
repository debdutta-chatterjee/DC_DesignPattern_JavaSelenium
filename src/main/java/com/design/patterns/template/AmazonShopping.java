package com.design.patterns.template;

import org.openqa.selenium.WebDriver;

import com.design.patterns.singleton.util.UrlResolver;
import com.design.patterns.template.pages.AmazonHomePage;
import com.design.patterns.template.pages.AmazonSearchPage;
import com.design.principles.openclose.ConfigProfile;
import com.design.principles.openclose.PropertyType;

public class AmazonShopping  extends ShoppingTemplate{

	private AmazonHomePage homePage;
	private AmazonSearchPage searchPage;
		
	String productName;
		
	public AmazonShopping(WebDriver driver,String productName,ConfigProfile config)
	{
		super(driver,config);
		homePage= new AmazonHomePage(driver);
		searchPage= new AmazonSearchPage(driver);
		this.productName=productName;
	}
		
	@Override
	public void assertHomePage() {
		this.homePage.assertHomePageLogo();		
	}

	@Override
	public void navigateToProductPage() {
		this.searchPage.navigateToProductPage(productName);		
	}

	@Override
	public void searchProduct() {
		this.homePage.searchProduct(productName);
	}

	@Override
	public String extractPrice() {
		return this.searchPage.extractPrice(productName);
	}
	
	@Override
	public void goTo() {
		driver.get(UrlResolver.getUrl(config,PropertyType.AmazonUrl.toString()));
	}
}
