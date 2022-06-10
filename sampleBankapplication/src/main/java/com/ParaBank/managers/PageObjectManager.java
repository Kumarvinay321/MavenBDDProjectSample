package com.ParaBank.managers;

import org.openqa.selenium.WebDriver;


import com.ParaBank.pageObjects.BillPayPage;
//import com.ParaBank.pageObjects.LogOutPage;
import com.ParaBank.pageObjects.LoginPage;
import com.ParaBank.pageObjects.NewAccountPage;
import com.ParaBank.pageObjects.TransferFundsPage;
import com.ParaBank.pageObjects.UpdateContactInfoPage;

public class PageObjectManager {
	
	private WebDriver driver;

	private LoginPage loginPage;
	private NewAccountPage newAccountPage;
	private TransferFundsPage transferFundsPage;
	private BillPayPage billPayPage;
	private UpdateContactInfoPage updateContactInfoPage;
	//private LogOutPage logOutPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage(){
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public NewAccountPage getNewAccountPage() {
		return (newAccountPage == null) ? newAccountPage = new NewAccountPage(driver) : newAccountPage;
	}

	public TransferFundsPage getTransferFundsPage() {
		return (transferFundsPage == null) ? transferFundsPage = new TransferFundsPage(driver) : transferFundsPage;
	}

	public BillPayPage getBillPayPage() {
		return (billPayPage == null) ? billPayPage = new BillPayPage(driver) : billPayPage;
	}

	public UpdateContactInfoPage getUpdateContactInfoPage() {
		return (updateContactInfoPage == null) ? updateContactInfoPage = new UpdateContactInfoPage(driver) : updateContactInfoPage;
	}

	/*
	 * public LogOutPage getLogOutPage() { return (logOutPage == null) ? logOutPage
	 * = new LogOutPage(driver) : logOutPage; }
	 */
}
