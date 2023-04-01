package com.test.runner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.design.patterns.proxy.LoginPage;
import com.design.patterns.singletonUtil.UrlResolver;
import com.design.principles.openclose.ConfigProfile;
import com.design.principles.openclose.ConfigProfilePropertyFile;
import com.design.principles.openclose.PropertyType;
import com.google.common.util.concurrent.Uninterruptibles;
import com.test.base.BaseTest;

public class Proxy_Runner extends BaseTest{
	
	
	LoginPage page;
	String url;
	
	@BeforeTest
    public void setDetails()
	{
		ConfigProfile config = new ConfigProfilePropertyFile();
		
		url=UrlResolver.getUrl(config,PropertyType.AmazonUrl.toString());
    }
	
  @Test(dataProvider="dataProvider")
  public void proxyPatternTest_001(Map<String,String> mapLogin) 
  {
	  System.setProperty("env_condition", mapLogin.get("condition"));
	  driver.get(url);
	  page = new LoginPage(driver,mapLogin);
	  page.login();
	  page.setUserLogin();
	  page.getUserLogin().verifyLogin();	
	  
	  Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
  } 
  
  @DataProvider(name="dataProvider")
  public Object[][] dataProvider()
  {
	  Map<String,String> positive= new HashMap<String,String>();
	  positive.put("mobile", "1234567890");
	  positive.put("pwd", "12345678890");
	  positive.put("condition", "positive");
	  
	  Map<String,String> negative= new HashMap<String,String>();
	  negative.put("mobile", "1234567889");
	  negative.put("pwd", "12345678890");
	  negative.put("condition", "negative");
	  
	  Map<String,String> invalid= new HashMap<String,String>();
	  invalid.put("mobile", "");
	  invalid.put("pwd", "1000000");
	  invalid.put("condition", "invalid");
	  
	  return new Object[][]
	  {
		  {positive},
		  {negative},
		  {invalid}
	  };
  }
}
