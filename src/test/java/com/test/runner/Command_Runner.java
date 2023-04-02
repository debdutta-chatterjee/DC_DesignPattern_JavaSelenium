package com.test.runner;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.design.patterns.command.NotificationPage;
import com.design.patterns.singletonUtil.UrlResolver;
import com.design.principles.openclose.ConfigProfile;
import com.design.principles.openclose.ConfigProfilePropertyFile;
import com.design.principles.openclose.PropertyType;
import com.google.common.util.concurrent.Uninterruptibles;
import com.test.base.BaseTest;

public class Command_Runner extends BaseTest{
	
	
	private NotificationPage page;
	String url;
	
	@BeforeTest
    public void setDetails()
	{
		ConfigProfile config = new ConfigProfilePropertyFile();
		
		url=UrlResolver.getUrl(config,PropertyType.CommandPatternUrl.toString());
		page= new NotificationPage(driver);
    }
	
  @Test()
  public void CommandPatternTest_001() 
  {
	  page.goTo(url);
	  this.page.getElementValidators()
      .stream()
      .parallel()
      .map(ev -> ev.validate())
      .forEach(b -> Assert.assertTrue(b));
	  Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
  }  
}
