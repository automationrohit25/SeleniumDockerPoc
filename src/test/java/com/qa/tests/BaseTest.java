package com.qa.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setupDriver() throws MalformedURLException{
		
		String host = "localhost";
		DesiredCapabilities cap;
			
		if(System.getProperty("Browser") != null && 
				System.getProperty("Browser").equalsIgnoreCase("chrome")){
			cap = DesiredCapabilities.chrome();
//			cap.setCapability("no-sandbox",true);
			
		}else{
			cap = DesiredCapabilities.firefox();
			cap.setCapability("enableVNC", true);
//			cap.setCapability("enableVideo", true);
		}
		
		if(System.getProperty("Hub_Host") != null){
			host=System.getProperty("Hub_Host");	
		}
		
//		String compurl = "http://" + host + ":4444/wd/hub";
//		String compurl = "http://3.231.56.152:4444/wd/hub";
//		this.driver = new RemoteWebDriver(new URL(compurl), cap);

		WebDriverManager.firefoxdriver().setup();
		this.driver = new FirefoxDriver();
		this.driver.manage().window().maximize();
	}
	
	@AfterTest
	public void quitBrowser(){
		this.driver.quit();
	}

}
