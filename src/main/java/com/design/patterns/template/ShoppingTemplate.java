package com.design.patterns.template;

import org.openqa.selenium.WebDriver;

import com.design.principles.openclose.ConfigProfile;


public abstract class ShoppingTemplate{
	
	protected WebDriver driver;
	protected ConfigProfile config;
	
	public ShoppingTemplate(WebDriver driver,ConfigProfile config) {
		this.config=config;
		this.driver=driver;		
	}
	
	protected abstract void goTo();
	protected abstract void assertHomePage();
	protected abstract void navigateToProductPage();
	protected abstract void searchProduct();
	protected abstract String extractPrice();
	
	public void searchTemplate() {
		goTo();
		assertHomePage();
		searchProduct();
		navigateToProductPage();
		System.out.println(extractPrice());
	}
}
