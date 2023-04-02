package com.design.patterns.strategy;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.design.patterns.base.BasePage;

public class FlightHomePage extends BasePage
{
	public FlightHomePage(WebDriver driver) {
		super(driver);
	}
	
	By sectionElement = By.id("traveller-home");
    By footerNavSectionElement = By.id("buttons");
    
    Trip trip;


    public FlightNavigationSection getNavigationBar()
    {
        return new FlightNavigationSection(driver,sectionElement);
    }

    public FooterSection getFooterNav()
    {
        return new FooterSection(driver,footerNavSectionElement);
    }

    public void setBookingStrategy(String strategyType)
    {
        trip = new StrategyFactory(driver).createStrategy(strategyType);
    }

    public void checkAvail(Map<String,String> reservationDetails)
    {
    	trip.checkAvail(reservationDetails);
    }
    
    public String getTitle()
    {
        System.out.println("Hello");
        return driver.getTitle();
    }	
}
