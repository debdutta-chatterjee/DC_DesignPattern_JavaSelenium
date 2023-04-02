package com.design.patterns.decorator;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.design.patterns.base.BasePage;

public class UserDashboardPage extends BasePage{
	
	public UserDashboardPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id = "role")
    private WebElement role;

    @FindBy(css ="div.guest")
    private List<WebElement> guestComponents;

    @FindBy(css ="div.superuser")
    private List<WebElement> superUserComponents;

    @FindBy(css ="div.admin")
    private List<WebElement> adminComponents;

    public void selectRole(String role){
        Select select = new Select(this.role);
        select.selectByValue(role);
    }

    public List<WebElement> getAdminComponents() {
        return adminComponents;
    }

    public List<WebElement> getGuestComponents() {
        return guestComponents;
    }

    public List<WebElement> getSuperUserComponents() {
        return superUserComponents;
    }
}
