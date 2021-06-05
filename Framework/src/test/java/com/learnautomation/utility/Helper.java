package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String getScreenshot(WebDriver driver,String screenshotName) {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.dir")+"/Screenshot/Application_"+screenshotName+ "_"+getCurrentDateTime()+".png";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return path;
		}

	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate= new Date();
		return customFormat.format(currentDate);
		
	}
}


