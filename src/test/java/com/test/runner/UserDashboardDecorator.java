package com.test.runner;


import java.util.List;
import java.util.function.Consumer;


import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.design.patterns.decorator.UserDashboardPage;

public class UserDashboardDecorator {
	
	private static void shouldDisplay(List<WebElement> elements){
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements){
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }
	
	//ingredients
    private static final Consumer<UserDashboardPage> adminComponentPresent = (dp) -> shouldDisplay(dp.getAdminComponents());
    private static final Consumer<UserDashboardPage> suComponentPresent = (dp) -> shouldDisplay(dp.getSuperUserComponents());
    private static final Consumer<UserDashboardPage> guestComponentPresent = (dp) -> shouldDisplay(dp.getGuestComponents());
    
    private static final Consumer<UserDashboardPage> adminComponentNotPresent = (dp) -> shouldNotDisplay(dp.getAdminComponents());
    private static final Consumer<UserDashboardPage> suComponentNotPresent = (dp) -> shouldNotDisplay(dp.getSuperUserComponents());
    private static final Consumer<UserDashboardPage> guestComponentNotPresent = (dp) -> shouldNotDisplay(dp.getGuestComponents());
    
    //role selection
    private static final Consumer<UserDashboardPage> adminSelection = (dp) -> dp.selectRole("admin");
    private static final Consumer<UserDashboardPage> suSelection = (dp) -> dp.selectRole("superuser");
    private static final Consumer<UserDashboardPage> guestSelection = (dp) -> dp.selectRole("guest");

    //user role pages
    public static final Consumer<UserDashboardPage> guestPage = guestSelection.andThen(guestComponentPresent).andThen(suComponentPresent).andThen(adminComponentNotPresent);
    public static final Consumer<UserDashboardPage> suPage = suSelection.andThen(guestComponentPresent).andThen(suComponentPresent).andThen(adminComponentNotPresent);
    public static final Consumer<UserDashboardPage> adminPage = adminSelection.andThen(guestComponentPresent).andThen(suComponentPresent).andThen(adminComponentPresent);
	
}
