package stepDefinitions;

import java.io.IOException;

import java.util.List;
import org.junit.Assert;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.Base;

import com.ParaBank.pageObjects.LoginPage;

public class LoginSteps extends Base {

	public LoginSteps() throws IOException {
		super();
	}

	LoginPage loginPage;

	@When("^User enters Credentials to LogIn$")
	public void user_enters_Credentials_to_LogIn(DataTable usercredentials) {

		List<String> data = usercredentials.asList(String.class);
		System.out.println(data);

		String userName = data.get(0);
		String passWord = data.get(1);

		loginPage = new LoginPage(driver);
		loginPage.login(userName, passWord);
	}

	@Then("^The Title of the Page should be \"([^\"]*)\"$")
	public void the_Title_of_the_Page_should_be(String title) {
		String actualTitle = loginPage.getPageTitle();
		System.out.println("page title is: " + actualTitle);
		Assert.assertEquals(actualTitle, title);
	}

	@Then("^The error message should be \"([^\"]*)\"$")
	public void the_error_message_should_be(String actualError) {
		String expected = loginPage.errormessage();
		Assert.assertEquals(actualError, expected);
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		Base.tearDown();
	}
}
