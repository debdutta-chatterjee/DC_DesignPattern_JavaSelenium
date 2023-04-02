package com.test.runner;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.design.patterns.decorator.UserDashboardPage;
import com.design.patterns.singletonUtil.UrlResolver;
import com.design.principles.openclose.ConfigProfile;
import com.design.principles.openclose.ConfigProfilePropertyFile;
import com.design.principles.openclose.PropertyType;
import com.google.common.util.concurrent.Uninterruptibles;
import com.test.base.BaseTest;

public class Decorator_Runner extends BaseTest{
	
	
	private UserDashboardPage dashboardPage;
	String url;
	
	@BeforeTest
    public void setDetails()
	{
		ConfigProfile config = new ConfigProfilePropertyFile();
		
		url=UrlResolver.getUrl(config,PropertyType.DecoratorPatternUrl.toString());
    }
	
  @Test(dataProvider="dataProvider")
  public void DecoratorPatternTest_001(Consumer<UserDashboardPage> role) 
  {
	  driver.get(url);
	  this.dashboardPage = new UserDashboardPage(driver);
	  role.accept(this.dashboardPage);
	  Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
  } 
  
  @DataProvider(name="dataProvider")
  public Object[] dataProvider()
  {
	  return new Object[]{
			  UserDashboardDecorator.guestPage,
			  UserDashboardDecorator.suPage,
			  UserDashboardDecorator.adminPage
	        };
  }
}
