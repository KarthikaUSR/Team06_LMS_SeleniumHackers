package stepDefinition;

import comPages.Loginpage;
import comUtils.DriverFactory;
import comUtils.ExcelReader;
import io.cucumber.java.en.*;

public class DashStepDefination {
	private ExcelReader excelnew=new ExcelReader();
	private Loginpage loginPage = new Loginpage(DriverFactory.getDriver());
	@When("Admin enter valid credentials and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		String username=excelnew.getCellData(1, 0);;
		String password=excelnew.getCellData(1, 1);
		System.out.println(username+" "+password);
		loginPage.Enter_username_password(username, password);
	}

	@Then("Admin should see dashboard")
	public void admin_should_see_dashboard() {
	}
}
