package com.design.patterns.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WebDriverManagerFactory {
	
	private static final Map<WebDriverType,Supplier<WebDriverManager>> driverMap = new HashMap<>();
	
	//Driver list
	private static final Supplier<WebDriverManager> chromeDriverManager = 
			() -> new ChromeDriverManager();
	
	static
	{
		driverMap.put(WebDriverType.Chrome, chromeDriverManager);
	}
		
	public  WebDriverManager getDriverManager(WebDriverType browser)
	{
		return driverMap.get(browser).get();
	}	
}
