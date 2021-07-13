package com.qa.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {

	private WebDriver driver;
	private WebDriverWait wait;

//	@FindBartialLinkText = " sign-in ")
//	private Weby(pElement signinLink;

	@FindBy(partialLinkText = "Flights")
	private WebElement flightsLink;
	
	
	public RegistrationConfirmationPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public void gotoFlightsDetailPage(){
		this.wait.until(ExpectedConditions.visibilityOf(flightsLink));
		this.flightsLink.click();
	}
}
