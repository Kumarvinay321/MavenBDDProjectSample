package com.ParaBank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2E {
	private static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\703319288\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://parabank.parasoft.com/parabank/index.htm");

		// Login Page
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("john");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("demo");

		WebElement logIn = driver.findElement(By.xpath("//input[@type='submit']"));
		logIn.click();

		/*
		 * //Open Account Page
		 * 
		 * WebElement openAccount =
		 * driver.findElement(By.cssSelector("a[href*='openaccount']"));
		 * openAccount.click();
		 * 
		 * Select accountType = new Select(driver.findElement(By.id("type")));
		 * //accountType.selectByVisibleText("CHECKING");
		 * accountType.selectByVisibleText("SAVINGS"); //accountType.selectByIndex(0);
		 * //accountType.selectByValue("CHECKING");
		 * 
		 * Select fromAccountID = new
		 * Select(driver.findElement(By.id("fromAccountId")));
		 * //fromAccountID.selectByVisibleText("13344");
		 * fromAccountID.selectByValue("13344");
		 * 
		 * WebElement openNewAccountButton =
		 * driver.findElement(By.xpath("//input[@value='Open New Account']"));
		 * openNewAccountButton.click();
		 * 
		 * WebElement accountOpened =
		 * driver.findElement(By.xpath("//h1[text()='Account Opened!']"));
		 * accountOpened.isDisplayed();
		 */

		// Transfer Funds Page
		WebElement transferFunds = driver.findElement(By.cssSelector("a[href*='transfer']"));
		transferFunds.click();

		WebElement amount = driver.findElement(By.id("amount"));
		amount.sendKeys("1");
		
		Thread.sleep(5000);

		Select fromAccountID1 = new Select(driver.findElement(By.id("fromAccountId")));
		// fromAccountID1.selectByVisibleText("13344");
		//fromAccountID1.selectByValue("13344");
		fromAccountID1.selectByVisibleText("13344");

		Select toAccountID = new Select(driver.findElement(By.id("toAccountId")));
		// toAccountID.selectByVisibleText("13566");
		//toAccountID.selectByValue("13788");
		toAccountID.selectByVisibleText("13788");

		WebElement transferButton = driver.findElement(By.xpath("//input[@value='Transfer']"));
		transferButton.click();

		WebElement transferComplete = driver.findElement(By.xpath("//h1[text()='Transfer Complete!']"));
		transferComplete.isDisplayed();

		/*
		 * //Bill Pay Page
		 * 
		 * WebElement billPay =
		 * driver.findElement(By.cssSelector("a[href*='billpay']")); billPay.click();
		 * 
		 * WebElement payeeName = driver.findElement(By.name("payee.name"));
		 * payeeName.sendKeys("kav");
		 * 
		 * WebElement address = driver.findElement(By.name("payee.address.street"));
		 * address.sendKeys("abc");
		 * 
		 * WebElement city = driver.findElement(By.name("payee.address.city"));
		 * city.sendKeys("bhi");
		 * 
		 * WebElement state = driver.findElement(By.name("payee.address.state"));
		 * state.sendKeys("cg");
		 * 
		 * WebElement zipCode = driver.findElement(By.name("payee.address.zipCode"));
		 * zipCode.sendKeys("34567");
		 * 
		 * WebElement phoneNumer = driver.findElement(By.name("payee.phoneNumber"));
		 * phoneNumer.sendKeys("310-447-4121");
		 * 
		 * WebElement accountNumber =
		 * driver.findElement(By.name("payee.accountNumber"));
		 * accountNumber.sendKeys("13344");
		 * 
		 * WebElement verifyAccountNumber =
		 * driver.findElement(By.name("verifyAccount"));
		 * verifyAccountNumber.sendKeys("13344");
		 * 
		 * 
		 * WebElement amount1 = driver.findElement(By.name("amount"));
		 * amount1.sendKeys("1");
		 * 
		 * Select fromAccountID2 = new
		 * Select(driver.findElement(By.name("fromAccountId")));
		 * 
		 * fromAccountID2.selectByValue("13788");
		 * 
		 * WebElement sendPayment =
		 * driver.findElement(By.xpath("//input[@value='Send Payment']"));
		 * sendPayment.click();
		 * 
		 * WebElement billPaymentComplete =
		 * driver.findElement(By.xpath("//h1[text()='Bill Payment Complete']"));
		 * billPaymentComplete.isDisplayed();
		 * System.out.println(billPaymentComplete.getText());
		 */

		/*
		 * //Update contact Info Page
		 * 
		 * WebElement updateContactInfo =
		 * driver.findElement(By.cssSelector("a[href*='updateprofile']"));
		 * updateContactInfo.click();
		 * 
		 * Thread.sleep(2000);
		 * 
		 * 
		 * WebElement phoneNumber = driver.findElement(By.id("customer.phoneNumber"));
		 * phoneNumber.clear(); phoneNumber.sendKeys("310-447-4125");
		 * 
		 * 
		 * 
		 * WebElement updateProfileButton =
		 * driver.findElement(By.xpath("//input[@value='Update Profile']"));
		 * updateProfileButton.click();
		 * 
		 * WebElement profileupdated =
		 * driver.findElement(By.xpath("//h1[text()='Profile Updated']"));
		 * profileupdated.isDisplayed(); System.out.println(profileupdated.getText());
		 */

		// driver.close();

	}

}
