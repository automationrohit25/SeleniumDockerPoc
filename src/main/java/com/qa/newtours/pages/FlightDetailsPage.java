package com.qa.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "passCount")
	private WebElement passengerCount;
	
	@FindBy(name = "findFlights")
	private WebElement continuebtn;
	
	public FlightDetailsPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void selectpassengers(String noofpassengers){
		this.wait.until(ExpectedConditions.elementToBeClickable(passengerCount));
		Select select = new Select(passengerCount);
		select.selectByValue(noofpassengers);
	}
	
	public void goToFindFlightDetailsPage(){
		this.continuebtn.click();
		
	}
	
	

}
