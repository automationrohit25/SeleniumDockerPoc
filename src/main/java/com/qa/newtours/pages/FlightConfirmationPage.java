package com.qa.newtours.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightConfirmationPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath ="//font[contains(text(),'Flight Itinerary Page')]")
	private WebElement flightConfirmationHeader;
	
	@FindBy(xpath = "//font[contains(text(),'USD')]")
	private List<WebElement> flightprices;
	
	@FindBy(xpath = "//a[contains(text(),'SIGN-OFF')]")
	private WebElement signoff;
	
	public FlightConfirmationPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	public String getPrice(){
		this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader));
		System.out.println(this.flightConfirmationHeader.getText());
		System.out.println(this.flightprices.get(1).getText());
		String price = this.flightprices.get(1).getText();
		this.signoff.click();
		return price;
	}
}
