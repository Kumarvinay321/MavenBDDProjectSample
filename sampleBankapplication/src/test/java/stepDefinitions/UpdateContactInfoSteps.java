package stepDefinitions;

import java.util.List;

import java.util.Map;
import com.ParaBank.pageObjects.UpdateContactInfoPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.Base;

public class UpdateContactInfoSteps {

	UpdateContactInfoPage updateContactInfoPage = new UpdateContactInfoPage(Base.getDriver());

	@When("^User click on Update Contact Info$")
	public void user_click_on_Update_Contact_Info() throws Throwable {
		updateContactInfoPage.clickUpdateContactInfo();
	}

	@Then("^User enter the following user details$")
	public void user_enter_the_following_user_details(DataTable userDetails) throws Throwable {
		List<Map<String, String>> userDetailsForm = userDetails.asMaps(String.class, String.class);
		for (Map<String, String> row : userDetailsForm) {
			String fName = row.get("FirstName");
			String lName = row.get("LastName");
			String address = row.get("Address");
			String city = row.get("City");
			String state = row.get("State");
			String zipCode = row.get("ZipCode");
			String phoneNo = row.get("PhoneNo");
			updateContactInfoPage.enterDetails(fName, lName, address, city, state, zipCode, phoneNo);
		}
	}

	@Then("^click on Update Profile$")
	public void click_on_Update_Profile() throws Throwable {
		updateContactInfoPage.clickUpdateProfile();
	}

	@Then("^Message displayed Profile Updated$")
	public void message_displayed_Profile_Updated() throws Throwable {
		updateContactInfoPage.profileUpdated();
	}

	@Then("^close browser success$")
	public void close_browser_success() throws Throwable {
		Base.tearDown();
	}
}
