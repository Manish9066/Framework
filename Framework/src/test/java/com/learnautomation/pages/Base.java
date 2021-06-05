package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class Base {

	public WebDriver driver;
	public ExcelDataProvider excel;
	ConfigDataProvider config;
	//for report
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {
	excel = new ExcelDataProvider();
	config = new ConfigDataProvider();
	
	//create and give the path of extent report
			ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/extent_"+Helper.getCurrentDateTime()+".html"));
			//crete the object of Extent report
			report = new ExtentReports();
			//attach the extent report
			report.attachReporter(extent);
			

	}
	@BeforeClass
	public void setup() {
		//driver = BrowserFactory.startApplication(driver, "Chrome", "https://eproc.hal-india.co.in");
		//call the method
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getUrl());
		driver.switchTo().frame("AppTop");
	}
	@AfterClass
	public void teardownclose() {
		//close the driver
				BrowserFactory.quitBrowser(driver);
			}
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
			if(ITestResult.FAILURE== result.getStatus()) {
				//Utility.getScreenshot(driver, result.getName());
				logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(driver,result.getName())).build());
			}
			// i want to take for pass also
			else if(result.getStatus()== ITestResult.SUCCESS) {
				logger.pass("Test passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenshot(driver,result.getName())).build());
			}
			report.flush();

}
}
