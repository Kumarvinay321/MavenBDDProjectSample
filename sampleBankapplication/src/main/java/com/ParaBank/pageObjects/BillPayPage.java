package com.ParaBank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.LoggerHelper;

public class BillPayPage {

	WebDriver driver;
	Logger log = LoggerHelper.getLogger(BillPayPage.class);

	public BillPayPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href*='billpay']")
	private WebElement lnk_billPay;

	@FindBy(name = "payee.name")
	private WebElement txtbx_payeeName;

	@FindBy(name = "payee.address.street")
	private WebElement txtbx_street;

	@FindBy(name = "payee.address.city")
	private WebElement txtbx_city;

	@FindBy(name = "payee.address.state")
	private WebElement txtbx_state;

	@FindBy(name = "payee.address.zipCode")
	private WebElement txtbx_zipCode;

	@FindBy(name = "payee.phoneNumber")
	private WebElement txtbx_phoneNo;

	@FindBy(name = "payee.accountNumber")
	private WebElement txtbx_accountNo;

	@FindBy(name = "verifyAccount")
	private WebElement txtbx_verifyAccountNo;

	@FindBy(name = "amount")
	private WebElement txtbx_amount;

	@FindBy(xpath = "//select[@name='fromAccountId']")
	private WebElement drpdwn_fromAccount;

	@FindBy(xpath = "//input[@value='Send Payment']")
	private WebElement btn_sendPayment;

	@FindBy(xpath = "//h1[text()='Bill Payment Complete']")
	private WebElement txt_billPaymentComplete;

	public void clickBillPay() {
		lnk_billPay.click();
	}

	public void enterName(String name) {
		txtbx_payeeName.sendKeys(name);
	}

	public void enterStreet(String street) {
		txtbx_street.sendKeys(street);
	}

	public void enterCity(String city) {
		txtbx_city.sendKeys(city);
	}

	public void enterState(String state) {
		txtbx_state.sendKeys(state);
	}

	public void enterZipCode(String zipCode) {
		txtbx_zipCode.sendKeys(zipCode);
	}

	public void enterphoneNo(String phoneNo) {
		txtbx_phoneNo.sendKeys(phoneNo);
	}

	public void enterAccountNo(String accountNo) {
		txtbx_accountNo.sendKeys(accountNo);
	}

	public void verifyAccountNo(String verifyAccountNo) {
		txtbx_verifyAccountNo.sendKeys(verifyAccountNo);
	}

	public void enterAmount(String amount) {
		txtbx_amount.sendKeys(amount);
	}

	public void selectFromAccount(String fromAccountNo) {

		Select fromAccount = new Select(drpdwn_fromAccount);
		fromAccount.selectByVisibleText(fromAccountNo);
	}

	public void clickSendPayment() {
		btn_sendPayment.click();
	}

	public void paymentComplete() {
		txt_billPaymentComplete.getText();
	}

	public void enterDetails(String name, String street, String city, String state, String zipcode, String phoneNo,
			String accountNo, String reaccountNo, String amount, String fromAccount) throws InterruptedException {

		enterName(name);
		enterStreet(street);
		enterCity(city);
		enterState(state);
		enterZipCode(zipcode);
		enterphoneNo(phoneNo);
		enterAccountNo(accountNo);
		verifyAccountNo(reaccountNo);
		enterAmount(amount);
		selectFromAccount(fromAccount);
	}
}
