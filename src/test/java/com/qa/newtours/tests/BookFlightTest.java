package com.qa.newtours.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.newtours.pages.FindFlightPage;
import com.qa.newtours.pages.FlightConfirmationPage;
import com.qa.newtours.pages.FlightDetailsPage;
import com.qa.newtours.pages.RegistrationConfirmationPage;
import com.qa.newtours.pages.RegistrationPage;
import com.qa.tests.BaseTest;

public class BookFlightTest extends BaseTest{
	
	private String noOfPassengers;
	private String expectedPrice;
	
	@BeforeTest
	@Parameters({"noOfPassengers", "expectedPrice"})
	public void setupParameters(String noOfPassengers, String expectedPrice){
		this.noOfPassengers = noOfPassengers;
		this.expectedPrice = expectedPrice;
			
	}
	
	@Test(priority=1)
	public void registrationPageTest(){
		RegistrationPage registrationpage = new RegistrationPage(driver);
		registrationpage.goTo();
		registrationpage.enterUserDetails("Test","Docker");
		registrationpage.enterCredentials("selenium", "docker");
		registrationpage.submit();
	}
	
	@Test(priority=2)
	public void registerConfirmationPageTest(){
		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		registrationConfirmationPage.gotoFlightsDetailPage();
	}
	
	@Test(priority=3)
	public void flightDetailsPageTest(){
		FlightDetailsPage flightdetailsPage = new FlightDetailsPage(driver);
		flightdetailsPage.selectpassengers(noOfPassengers);
		flightdetailsPage.goToFindFlightDetailsPage();
	}
	
	@Test(priority=4)
	public void findFlightPageTest(){
		FindFlightPage findflightPage = new FindFlightPage(driver);
		findflightPage.submitFindFlightPage();
		findflightPage.submitBillingFlightPage();
	}
	
	@Test(priority=5)
	public void flightConfirmationPageTest(){
		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		String actualPrice = flightConfirmationPage.getPrice();
		Assert.assertEquals(actualPrice, expectedPrice);
	}
	
	
}
