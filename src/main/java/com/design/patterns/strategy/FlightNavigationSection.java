package com.design.patterns.strategy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightNavigationSection extends FlightBase
{
	
	By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FlightNavigationSection(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);

    }

    public String getFlightAttribute()
    {
        return findElement(flights).getAttribute("class");
    }
    
    public int getLinkCount()
    {
    return findElements(links).size();
    }
	
}
