package com.ParaBank.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.LoggerHelper;

public class LoginPage {

	WebDriver driver;
	
	Logger log = LoggerHelper.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement txtbx_username;
	
	@FindBy(name = "password")
	private WebElement txtbx_password;

	@FindBy(xpath =  "//input[@type='submit']")
	private WebElement btn_logIn;

	@FindBy(css =  ".error")
	private WebElement txt_errorMsg;

	public void enter_Name(String name) {
		txtbx_username.sendKeys(name);
	}

	public void enter_Password(String password) {
		txtbx_password.sendKeys(password);
	}

	public void clicklogin() {
		btn_logIn.submit();
	}

	public String errormessage() {
		return txt_errorMsg.getText();

	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	// Login
	public void login(String userName, String passWord) {
		enter_Name(userName);
		log.info("User Name entered:"+ userName);
		enter_Password(passWord);
		log.info("Password entered:"+ passWord);
		clicklogin();
		log.info("Log in Button clicked successfully");
	}

}
