package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName,String appUrl)
	{
		//put the condition
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			
} else if (browserName.equals("Firefox")) {
	System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
	driver = new FirefoxDriver();
	
} else if(browserName.equals("IE")) {
	
}
else {
	System.out.println("Sorry we do not support this browser");
}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
		
	}
	}
