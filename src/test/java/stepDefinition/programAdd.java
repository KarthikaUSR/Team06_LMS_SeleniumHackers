package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import comPages.programPage;
import comUtils.driverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class programAdd {

	private static final Logger log = LogManager.getLogger(programPageNavigation.class);
	private programPage programpage;
	public programAdd() {

		programpage = new programPage(driverManager.getDriver()); // Get the driver from driverManager
	}

	// Scenario: Verify add New Program
		@Given("Admin is on Program module")
		public void admin_is_on_program_module() {
			
			programpage.programMenuclick();
		}

		@When("Admin clicks on {string} under the {string} menu bar")
		public void admin_clicks_on_under_the_menu_bar(String menu, String option) {
			programpage.clickNewProgram(menu, option);
		}
		
		@Then("Admin should see pop up window for program details")
		public void admin_should_see_pop_up_window_for_program_details() {
			programpage.isProgramDetailsPopupVisible();
		}

		// Scenario: Verify title of the pop up window

		@Then("Admin should see window title as {string}")
		public void admin_should_see_window_title_as(String string) {
			programpage.getPopupTitle();
		}

		// Scenario: Verify mandatory fields with red "*" mark


		@Then("Admin should see red '*' mark beside mandatory field {string}")
		public void admin_should_see_red_mark_beside_mandatory_field(String fieldName) {
			programpage.isMandatoryFieldMarked(fieldName);
		}

}
