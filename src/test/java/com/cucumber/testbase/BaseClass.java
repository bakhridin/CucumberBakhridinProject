package com.cucumber.testbase;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.utils.CommonMethods;
import com.cucumber.utils.ConfigsReader;
import com.cucumber.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static WebDriver setUp() {
		
		ConfigsReader.readProperties(Constants.CONFIGURATIONS_FILEPATH);
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		String headless=ConfigsReader.getProperty("headless");
		
		switch(ConfigsReader.getProperty("browser").toLowerCase()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if(headless.equalsIgnoreCase("true")) {
				options.setHeadless(true);
				driver= new ChromeDriver(options);
				
			}else {
				driver= new ChromeDriver();
				
			}
			
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
			default:
				throw new RuntimeException("Browser is not supported");
		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLISIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("url"));
		
		PageInitializer.initialize();
		
		
		 return driver;
		
	}
	
	public static void tearDown() {
		if(driver!=null) {
			CommonMethods.sleep(3);
			driver.quit();
			
		}
	}
	

}
