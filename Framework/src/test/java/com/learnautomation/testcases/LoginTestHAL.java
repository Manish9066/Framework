package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.learnautomation.pages.Base;
import com.learnautomation.pages.LoginPage;



public class LoginTestHAL extends Base {
	
	@Test
	public void LoginTest() {
		
		// for report
		logger = report.createTest("LoginFunction");
		//this will return the username
		//excel.getSringData("Login", 0, 0);
		//this will return the password
		//excel.getSringData("Login", 0, 1);
	//here we are using abstraction concept. means hiding the user implementation and showing the functionality.
		//here i am hiding logic and showing how to login
		//intialize the object
		LoginPage loginpage =PageFactory.initElements(driver, LoginPage.class);
		logger.info("Application started");
		//call the loginpage method and pass the value
		loginpage.LoginToHal(excel.getSringData("Login", 0, 0),excel.getSringData("Login", 0, 1));
		logger.info("Login Successfully");
	}
	
	}

