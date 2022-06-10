package com.ParaBank.pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.LoggerHelper;

public class UpdateContactInfoPage {

	Logger log = LoggerHelper.getLogger(UpdateContactInfoPage.class);

	public UpdateContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href*='updateprofile']")
	private WebElement lnk_updateContactInfo;

	@FindBy(id = "customer.firstName")
	private WebElement txtbx_firstName;

	@FindBy(id = "customer.lastName")
	private WebElement txtbx_lastName;

	@FindBy(id = "customer.address.street")
	private WebElement txtbx_address;

	@FindBy(id = "customer.address.city")
	private WebElement txtbx_city;

	@FindBy(id = "customer.address.state")
	private WebElement txtbx_state;

	@FindBy(id = "customer.address.zipCode")
	private WebElement txtbx_zipCode;

	@FindBy(id = "customer.phoneNumber")
	private WebElement txtbx_phoneNumber;

	@FindAll(@FindBy(how = How.XPATH, using = "//input[@type='text']"))
	private List<WebElement> userDetails;

	@FindBy(xpath = "//input[@value='Update Profile']")
	private WebElement btn_updateProfile;

	@FindBy(xpath = "//h1[text()='Profile Updated']")
	private WebElement txt_updateProfile;
//	String[] value = { "Kavita", "pra", "add1", "add2", "add3", "add4", "998983999" };

	public void clickUpdateContactInfo() {
		lnk_updateContactInfo.click();
	}

	public void enter_firstName(String firstName) throws InterruptedException {
		txtbx_firstName.sendKeys(firstName);
	}

	public void enter_lastName(String lastName) throws InterruptedException {
		txtbx_lastName.sendKeys(lastName);
	}

	public void enter_address(String address) throws InterruptedException {
		txtbx_address.sendKeys(address);
	}

	public void enter_city(String city) throws InterruptedException {
		txtbx_city.sendKeys(city);
	}

	public void enter_state(String state) throws InterruptedException {
		txtbx_state.sendKeys(state);
	}

	public void enter_zipcode(String zipcode) throws InterruptedException {
		txtbx_zipCode.sendKeys(zipcode);
	}

	public void enter_PhoneNo(String phoneNo) throws InterruptedException {
		txtbx_phoneNumber.sendKeys(phoneNo);
	}

	/*
	 * public void enterUserDetails() { for (int i = 0; i < userDetails.size(); i++)
	 * { userDetails.get(i).clear(); userDetails.get(i).sendKeys(value[i]); }
	 * 
	 * }
	 */

	public void enterDetails(String fName, String lName, String address, String city, String state, String zipCode,
			String phoneNo) throws InterruptedException {
		userDetails.clear();
		enter_firstName(fName);
		enter_lastName(lName);
		enter_address(address);
		enter_city(city);
		enter_state(state);
		enter_zipcode(zipCode);
		enter_PhoneNo(phoneNo);
	}

	public void clickUpdateProfile() {
		btn_updateProfile.click();
		log.info("Profile Updated");
	}

	public void profileUpdated() {
		txt_updateProfile.getText();
	}
}