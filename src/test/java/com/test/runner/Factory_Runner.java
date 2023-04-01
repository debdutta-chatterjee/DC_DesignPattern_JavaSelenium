package com.test.runner;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.design.patterns.singletonUtil.PropertiesUtil;
import com.design.principles.openclose.PropertyType;
import com.test.base.BaseTest;

public class Factory_Runner extends BaseTest{
	
  @Test(dataProvider="dataProvider")  
  public void factoryPatternTest_001(String url,String title) 
  {
	  driver.get(url);
	  Assert.assertTrue(driver.getCurrentUrl().contains(title));
  }
  
  @DataProvider(name="dataProvider")
  public Object[][] dataProvider()
  {
	  return new String[][]
	  {
		  {PropertiesUtil.getProperty(PropertyType.FlipkartUrl.toString()),"flipkart"},
		  {PropertiesUtil.getProperty(PropertyType.AmazonUrl.toString()),"amazon"}
	  };
  }
  
}
