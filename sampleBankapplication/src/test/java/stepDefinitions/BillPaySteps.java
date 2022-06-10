package stepDefinitions;

import java.util.List;

import java.util.Map;
import com.ParaBank.pageObjects.BillPayPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.Base;

public class BillPaySteps {

	BillPayPage billPayPage = new BillPayPage(Base.getDriver());

	@When("^User click on Bill Pay$")
	public void user_click_on_Bill_Pay() throws Throwable {
		billPayPage.clickBillPay();
	}

	@Then("^User enter the following details$")
	public void user_enter_the_following_details(DataTable userDetails) throws Throwable {
		List<Map<String, String>> userDetailsForm = userDetails.asMaps(String.class, String.class);
		for (Map<String, String> row : userDetailsForm) {

			String name = row.get("PayeeName");
			String street = row.get("Address");
			String city = row.get("City");
			String state = row.get("State");
			String zipcode = row.get("ZipCode");
			String phoneNo = row.get("Phone");
			String accountNo = row.get("Account");
			String reaccountNo = row.get("VerifyAccount");
			String amount = row.get("Amount");
			String fromAccount = row.get("Fromaccount");

			billPayPage.enterDetails(name, street, city, state, zipcode, phoneNo, accountNo, reaccountNo, amount,
					fromAccount);
		}
	}

	@Then("^click on send payment$")
	public void click_on_send_payment() throws Throwable {
		billPayPage.clickSendPayment();
	}

	@Then("^Message displayed Transfer Complete$")
	public void message_displayed_Transfer_Complete() throws Throwable {
		billPayPage.paymentComplete();
	}

	@Then("^close the browser successfully$")
	public void close_the_browser_successfully() throws Throwable {
		Base.tearDown();
	}
}