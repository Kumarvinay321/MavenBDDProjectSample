package stepDefinitions;

import java.io.IOException;
import org.junit.Assert;
import com.ParaBank.pageObjects.TransferFundsPage;
import com.ParaBank.pageObjects.LoginPage;
import com.ParaBank.pageObjects.NewAccountPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.Base;

public class NewAccountSteps extends Base {

	public NewAccountSteps() throws IOException {
		super();
	}

	LoginPage loginPage;
	NewAccountPage newAccountPage;
	
	TransferFundsPage transferFundsPage;

	@Given("^User Is loggedin$")
	public void user_Is_loggedin() {
		loginPage = new LoginPage(driver);
		loginPage.login("john", "demo");
		System.out.println("User loggedin");
	}

	@When("^User click on Open New Account$")
	public void user_click_on_Open_New_Account() throws Throwable {
		newAccountPage = new NewAccountPage(driver);
		newAccountPage.clickOpenAccount();
	}

	@When("^user selects the account type as \"([^\"]*)\"$")
	public void user_selects_the_account_type_as(String account) throws Throwable {
		newAccountPage.selectAccountType(account);
	}

	@When("^user selects the existing \"([^\"]*)\" accountNo$")
	public void user_selects_the_existing_accountNo(String accountNo) throws Throwable {
		newAccountPage.selectFromAccount(accountNo);
	}

	@When("^user click on Open New Account Button$")
	public void user_click_on_Open_New_Account_Button() throws Throwable {
		newAccountPage.clickOpenNewAccount();
		Thread.sleep(3000);
	}

	@Then("^Message displayed \"([^\"]*)\"$")
	public void message_displayed(String expectmsg) {
		String actSuccessMessage = newAccountPage.accountOpened();
		Assert.assertEquals(actSuccessMessage, expectmsg);
	}

	@When("click on Account Number")
	public void click_on_account_number() {
		newAccountPage.clickOnNewAccountID();
	}

	@Then("^Verify Account Type as \"([^\"]*)\"$")
	public void verify_Account_Type_as(String expectActType) throws Throwable {

		String accntType = newAccountPage.accountTypeVerify();
		Assert.assertEquals(accntType, expectActType);
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
		Base.tearDown();
	}
}
