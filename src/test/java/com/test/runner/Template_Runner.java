package com.test.runner;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.design.patterns.template.AmazonShopping;
import com.design.patterns.template.FlipkartShopping;
import com.design.patterns.template.ShoppingTemplate;
import com.design.principles.openclose.ConfigProfile;
import com.design.principles.openclose.ConfigProfilePropertyFile;

import com.test.base.BaseTest;

public class Template_Runner extends BaseTest{
	
	
  @Test(dataProvider="dataProvider")  
  public void factoryPatternTest_001(ShoppingTemplate template) 
  {
	  template.searchTemplate();
  }
  
  @DataProvider(name="dataProvider")
  public Object[][] dataProvider()
  {
	  ConfigProfile config = new ConfigProfilePropertyFile();
	  return new Object[][]
	  {
		  {new AmazonShopping(driver, "Redmi 10 (Midnight Black, 6GB RAM, 128GB Storage)",config)},
		  {new FlipkartShopping(driver, "REDMI 10 (Midnight Black, 128 GB)",config)}
	  };
  }
  
}
