package com.design.patterns.strategy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.design.patterns.base.BasePage;

public class StrategyFactory extends BasePage{
	
	protected StrategyFactory(WebDriver driver) {
		super(driver);
	}

	By sectionElement= By.id("flightSearchContainer");

    public Trip createStrategy(String strategyType)
    {
        if(strategyType.equalsIgnoreCase("multitrip"))
        {
           return new MultiTrip(driver,sectionElement);
        }
        if(strategyType.equalsIgnoreCase("roundtrip"))
        {
            return new RoundTrip(driver,sectionElement);
        }
        return null;
    }
}
