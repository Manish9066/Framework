package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	//create one constructor to intialize the driver
public LoginPage(WebDriver ldriver) {
	this.driver =ldriver;
}

// store the element locator

//for username
@FindBy(name="name1")  WebElement username;
// for password
@FindBy(name="pass1") WebElement password;
//for login button
@FindBy(id="TW_loginImage") WebElement loginbtn;

// this method will login to app
public void LoginToHal(String usernameApp, String passwordApp) {
	username.sendKeys(usernameApp);
	password.sendKeys(passwordApp);
	loginbtn.click();
}
}
