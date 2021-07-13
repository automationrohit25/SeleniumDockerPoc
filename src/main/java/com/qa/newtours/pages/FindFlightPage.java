package com.qa.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(name = "reserveFlights")
	private WebElement firstsubmitbtn;
	
	@FindBy(name = "buyFlights")
	private WebElement secondsubmitbtn;
	
	public FindFlightPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void submitFindFlightPage(){
		this.wait.until(ExpectedConditions.elementToBeClickable(firstsubmitbtn));
		this.firstsubmitbtn.click();
	}
	
	public void submitBillingFlightPage(){
		this.wait.until(ExpectedConditions.elementToBeClickable(secondsubmitbtn));
		this.secondsubmitbtn.click();
		
	}

}
