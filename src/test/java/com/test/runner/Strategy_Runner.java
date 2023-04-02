package com.test.runner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.design.patterns.singletonUtil.UrlResolver;
import com.design.patterns.strategy.FlightHomePage;
import com.design.principles.openclose.ConfigProfile;
import com.design.principles.openclose.ConfigProfilePropertyFile;
import com.design.principles.openclose.PropertyType;
import com.design.testdata.reader.DataReader;

import com.test.base.BaseTest;

public class Strategy_Runner extends BaseTest 
{

	private FlightHomePage page;
	String url;

	@BeforeTest
	public void setDetails() 
	{
		ConfigProfile config = new ConfigProfilePropertyFile();

		url = UrlResolver.getUrl(config, PropertyType.StrategyPatternUrl.toString());
	}

	@Test(dataProvider = "reservationdata")
	public void StrategyPatternTest_001(Map<String, String> reservationDetails) 
	{
		page = new FlightHomePage(driver);
		driver.get(url);
		System.out.println(page.getFooterNav().getFlightAttribute());
		System.out.println(page.getNavigationBar().getFlightAttribute());
		System.out.println(page.getFooterNav().getLinkCount());
		System.out.println(page.getNavigationBar().getLinkCount());
		page.setBookingStrategy("multitrip");

		page.checkAvail(reservationDetails);
	}

	@DataProvider(name = "reservationdata")
	public Object[][] getData() throws IOException 
	{
		List<HashMap<String, String>> lstData = DataReader.getJsonData("./Test_Data/TestData.json");

		return new Object[][] { { lstData.get(0) }, { lstData.get(1) } };
	}
}
