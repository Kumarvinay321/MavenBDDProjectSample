package com.ParaBank.pageObjects;

import org.apache.log4j.Logger;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.LoggerHelper;

public class TransferFundsPage {

	WebDriver driver;
	Logger log = LoggerHelper.getLogger(TransferFundsPage.class);

	public TransferFundsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[href*='transfer']")
	private WebElement lnk_transferFund;

	@FindBy(id = "amount")
	private WebElement txtbx_amount;

	@FindBy(xpath = "//select[@id='fromAccountId']")
	private WebElement drpdwn_fromAccount;

	@FindBy(xpath = "//select[@id='toAccountId']")
	private WebElement drpdwn_toAccount;

	@FindBy(xpath = "//input[@value='Transfer']")
	private WebElement btn_Transfer;

	@FindBy(xpath = "//h1[text()='Transfer Complete!']")
	private WebElement txt_TransferComplete;

	public void clickTransferFunds() throws InterruptedException {
		lnk_transferFund.click();
		log.info("Transfer Funds link clicked successfully");
		Thread.sleep(3000);
	}

	public void enterAmount(String amount) {
		txtbx_amount.sendKeys(amount);
		log.info("Amount:" + amount);
	}

	public void selectFromAccount(String fromAccountNo) throws InterruptedException {

		Select fromAccount = new Select(drpdwn_fromAccount);
		fromAccount.selectByVisibleText(fromAccountNo);
		log.info("From Account No:" + fromAccountNo);
	}

	public void selectToAccount(String toAccountNo) throws InterruptedException {
		Select toAccount = new Select(drpdwn_toAccount);
		toAccount.selectByVisibleText(toAccountNo);
		log.info("To Account No:" + toAccountNo);
	}

	public void clickTransfer() throws InterruptedException {
		Thread.sleep(2000);
		btn_Transfer.click();
	}

	public void transferComplete() {
		txt_TransferComplete.getText();
		log.info("Transfer Complete");
	}
}