package com.design.patterns.strategy;


import java.util.Map;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MultiTrip extends FlightBase implements Trip{

	protected MultiTrip(WebDriver driver, By sectionElement) {
		super(driver,sectionElement);
	}

	//private By submit = By.id("ctl00_mainContent_btn_FindFlights");
    private By multiCity_rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By destination_2= By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By modalPopUp = By.id("MultiCityModelAlert");
	
    @Override
	public void checkAvail(Map<String, String> reservationDetails) {
    	makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination2"));
	}

    public void selectOriginCity(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination)
    {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectDestinationCity2(String destination2)
    {
        findElement(destination_2).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }

    //EXECUTE AROUND
    public void makeStateReady(Consumer<MultiTrip> consumer)
    {
        System.out.println("I am inside Multi trip ");
        findElement(multiCity_rdo).click();
        findElement(modalPopUp).click();
        waitForElementToDisappear(modalPopUp);
        consumer.accept(this);
        System.out.println("am done");
    }
}
