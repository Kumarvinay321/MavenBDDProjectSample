package stepDefinitions;

import java.util.List;
import com.ParaBank.pageObjects.TransferFundsPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.Base;

public class TransferFundSteps {

	TransferFundsPage transferFundsPage = new TransferFundsPage(Base.getDriver());

	@When("^user click on Transfer Funds$")
	public void user_click_on_Transfer_Funds() throws Throwable {
		transferFundsPage.clickTransferFunds();
	}

	@Then("^user enter the \"([^\"]*)\" amount to be transfer$")
	public void user_enter_the_amount_to_be_transfer(String amount) throws Throwable {
		transferFundsPage.enterAmount(amount);
	}

	@Then("^select the from account and to account$")
	public void select_the_from_account_and_to_account(DataTable accountNo) throws Throwable {

		List<List<String>> data = accountNo.raw();
		System.out.println(data);

		String fromAccount = data.get(0).get(0);
		System.out.println(fromAccount);

		String toAccount = data.get(0).get(1);
		System.out.println(toAccount);

		transferFundsPage.selectFromAccount(fromAccount);
		transferFundsPage.selectToAccount(toAccount);

	}

	@Then("^click on Transfer$")
	public void click_on_Transfer() throws Throwable {
		transferFundsPage.clickTransfer();

	}

	@Then("^Transfer Complete text displayed$")
	public void transfer_Complete_text_displayed() throws Throwable {
		transferFundsPage.transferComplete();

	}

	@Then("^closes browser$")
	public void closes_browser() throws Throwable {
		Base.tearDown();
	}
}
