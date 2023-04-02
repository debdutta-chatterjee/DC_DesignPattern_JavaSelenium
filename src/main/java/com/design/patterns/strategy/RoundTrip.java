package com.design.patterns.strategy;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RoundTrip  extends FlightBase implements Trip{

	private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
	private By cb = By.id("ctl00_mainContent_chk_IndArm");
	private By search = By.id("ctl00_mainContent_btn_FindFlights");

	public RoundTrip(WebDriver driver, By sectionElement) 
	{
		super(driver, sectionElement);
	}

	@Override
	public void checkAvail(Map<String, String> reservationDetails) 
	{
		System.out.println("I am inside round trip ");
		findElement(rdo).click();
		findElement(from).click();
		selectOriginCity(reservationDetails.get("origin"));
		selectDestinationCity(reservationDetails.get("destination"));
		findElement(cb).click();
		findElement(search).click();
	}

	public void selectOriginCity(String origin) 
	{
		findElement(from).click();
		findElement(By.xpath("//a[@value='" + origin + "']")).click();
	}

	public void selectDestinationCity(String destination) 
	{
		findElement(to).click();
		findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
	}
}
