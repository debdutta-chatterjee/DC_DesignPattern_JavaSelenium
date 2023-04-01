package com.test.runner;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.design.patterns.executeAround.ExecuteAround;
import com.design.patterns.singletonUtil.UrlResolver;
import com.design.principles.openclose.ConfigProfile;
import com.design.principles.openclose.ConfigProfilePropertyFile;
import com.design.principles.openclose.PropertyType;
import com.google.common.util.concurrent.Uninterruptibles;
import com.test.base.BaseTest;

public class ExecuteAround_Runner extends BaseTest{
	
  @Test
  public void factoryPatternTest_001() 
  {
	  ConfigProfile config = new ConfigProfilePropertyFile();
	  driver.get(UrlResolver.getUrl(config,PropertyType.EAPatternUrl.toString()));

	  ExecuteAround page = new ExecuteAround(driver);
	  	  
	  page.onFrameA(a -> 
	  {
		  page.setFirstName("FName1");
	  	  page.setLastName("LName1");
	  	  page.setAddress("Address");
	  });
	  
	  page.onFrameB(b -> 
	  {
		  page.setFirstName("FName2");
	  	  page.setLastName("LName2");
	  	  page.setAddress("Address2");
	  });
	  
	  page.onFrameC(c -> 
	  {
		  page.setFirstName("FName3");
	  	  page.setLastName("LName3");
	  	  page.setAddress("Address3");
	  });
	  
	  Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
  } 
}
