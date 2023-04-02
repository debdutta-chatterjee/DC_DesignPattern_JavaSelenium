package com.design.patterns.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AlertValidator  implements Validator{

	private final WebElement dismissalAlert;
	
	public AlertValidator(final WebElement element){
        this.dismissalAlert = element;
    }
	
	@Override
	public boolean validate() {
		boolean result1 = this.dismissalAlert.isDisplayed(); //true
        this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean result2 = false;
        try{
        	result2 = this.dismissalAlert.isDisplayed(); //false;
        }catch(Exception e){}
        return result1 && (!result2);
	}
}
