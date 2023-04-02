package com.design.patterns.strategy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.design.patterns.base.BasePage;

public class FlightBase extends BasePage 
{

	WebElement sectionElement;
	protected By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	protected By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");	

	public FlightBase(WebDriver driver, By sectionElement) 
	{
		super(driver);
	    this.sectionElement =driver.findElement(sectionElement);
	}

	public WebElement findElement(By findElementBy) 
	{
		return sectionElement.findElement(findElementBy);
	}

	public void waitForElementToDisappear(By findBy) 
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}

	public List<WebElement> findElements(By findElementBy) 
	{
		return sectionElement.findElements(findElementBy);
	}
}
