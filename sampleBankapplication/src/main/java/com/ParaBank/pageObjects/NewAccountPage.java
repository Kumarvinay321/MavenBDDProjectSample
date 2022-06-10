package com.ParaBank.pageObjects;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.LoggerHelper;

public class NewAccountPage {

	WebDriver driver;

	Logger log = LoggerHelper.getLogger(NewAccountPage.class);

	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href*='openaccount']")
	private WebElement lnk_openAccount;

	@FindBy(id = "type")
	private WebElement drpdwn_accountType;

	@FindBy(xpath = "//select[@id='fromAccountId']")
	private WebElement drpdwn_fromAccountID;

	@FindBy(xpath = "//input[@value='Open New Account']")
	private WebElement btn_openNewAccount;

	@FindBy(xpath = "//h1[text()='Account Opened!']")
	private WebElement txt_accountOpened;

    @FindBy(xpath = "//a[@id='newAccountId']")
	WebElement getAccountNo;

	@FindBy(xpath = "//table/tbody/tr/td[text()='Account Number:']/following-sibling::td[@id='accountId']")
	WebElement verifyAccountNo;

	@FindBy(xpath = "//table/tbody/tr/td[text()='Account Type:']/following-sibling::td[@id='accountType']")
	WebElement verifyAccountType;

	public void clickOpenAccount() {
		lnk_openAccount.click();
		log.info("Open New Account Link clicked successfully");
	}

	public void selectAccountType(String account) throws InterruptedException {

		Select accountType = new Select(drpdwn_accountType);
		accountType.selectByVisibleText(account);
		log.info("Account type:" + account);
	}

	public void selectFromAccount(String accountNo) {

		Select fromAccount = new Select(drpdwn_fromAccountID);
		fromAccount.selectByVisibleText(accountNo);
		log.info("Account Number:" + accountNo);
	}

	public void clickOpenNewAccount() {
		btn_openNewAccount.click();
		log.info("Open New Account Button clicked successfully");
	}

	public String accountOpened() {
		return txt_accountOpened.getText();
	}

	public void clickOnNewAccountID() {
		getAccountNo.click();

	}

	public String getNewAccountID() {
		return getAccountNo.getText();
	}

	public String accountTypeVerify() throws InterruptedException {
		Thread.sleep(2000);
		return verifyAccountType.getText();
	}

	public String accountNoVerify() throws InterruptedException {
		Thread.sleep(2000);
		return verifyAccountNo.getText();
	}
}