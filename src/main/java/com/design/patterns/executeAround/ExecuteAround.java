package com.design.patterns.executeAround;

import java.util.function.Consumer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.design.patterns.base.BasePage;

public class ExecuteAround extends BasePage{
			
		public ExecuteAround(WebDriver driver)
		{
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(name="fn")
	    private WebElement firstName;

	    @FindBy(name="ln")
	    private WebElement lastName;

	    @FindBy(name="addr")
	    private WebElement address;
		
	    @FindBy(id = "a")
	    private WebElement frameA;

	    @FindBy(id = "b")
	    private WebElement frameB;

	    @FindBy(id = "c")
	    private WebElement frameC;
	    
	    
	    public void setValue(WebElement we, String val){
	        we.sendKeys(val);
	    }	     

	    public void setLastName(String val){
	        this.setValue(lastName, val);
	    }

	    public void setAddress(String val){
	    	this.setValue(address, val);
	    }
	    
	    public void setFirstName(String val){
	    	this.setValue(firstName, val);
	    }
		
	    public void onFrameA(Consumer<WebDriver> consumer){
	        this.onFrame(consumer,frameA);
	    }

	    public void onFrameB(Consumer<WebDriver> consumer){
	        this.onFrame(consumer,frameB);
	    }

	    public void onFrameC(Consumer<WebDriver> consumer){
	        this.onFrame(consumer,frameC);
	    } 
	    
	    private void onFrame(Consumer<WebDriver> consumer, WebElement element){
	        this.driver.switchTo().frame(element);
	        consumer.accept(driver);
	        this.driver.switchTo().defaultContent();
	    }
	    
	    
	    
	    
}
