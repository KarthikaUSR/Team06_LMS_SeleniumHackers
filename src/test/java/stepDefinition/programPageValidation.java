package stepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import comPages.Program;
import comPages.programPage;
import comUtils.LoggerLoad;
import comUtils.driverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class programPageValidation {

	private static final Logger log = LogManager.getLogger(programPageValidation.class);

	private programPage programpage;
	String programCountText;

	public programPageValidation() {
		programpage = new programPage(driverManager.getDriver()); // Get the driver from driverManager
	}

	// Scenario: Verify heading in manage program
	@Then("Admin should see the heading as {string}")
	public void admin_should_see_the_heading_as(String expectedHeading) {

		String actualHeading = programpage.getManageProgramHeading();
		System.out.println(actualHeading);
		Assert.assertEquals(actualHeading, expectedHeading, "Heading on Program page does not match expected.");
		LoggerLoad.info("Admin able to see heading");

	}

	// Scenario: Verify view details of programs

	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {

		List<Program> programs = programpage.getAllPrograms();

		// Assert each program has name, description, and status displayed
		for (Program program : programs) {
			Assert.assertNotNull("Program name is missing", program.getName());
			Assert.assertNotNull("Program description is missing", program.getDescription());
			Assert.assertNotNull("Program status is missing", program.getStatus());
		}

		LoggerLoad.info("All programs have name, description, and status displayed.");
	}

	// Scenario: Verify the Multiple Delete button state

	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {

		WebElement deleteButton = programpage.getDeleteButton();
		Assert.assertFalse(deleteButton.isEnabled());
		LoggerLoad.info("Delete button is confirmed to be disabled.");
	}

	// Scenario: Verify the Search button

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String expectedPlaceholder) {
		WebElement searchBar = programpage.getSearchBar();
		Assert.assertTrue(searchBar.isDisplayed());
		Assert.assertEquals("Search...", expectedPlaceholder, searchBar.getAttribute("placeholder"));
		LoggerLoad.info("Search bar is displayed with correct placeholder text.");

	}

	// Scenario: Verify column header name of data table

	@Then("Admin should see data table with column header on the Manage Program Page as Program Name,Program Description,Program Status,Edit\\/Delete")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {

		List<String> expectedHeaders = Arrays.asList("Program Name", "Program Description", "Program Status",
				"Edit/Delete");
		List<String> actualHeaders = programpage.getColumnHeaders();
		LoggerLoad.info("Verifying that the data table has the correct headers: " + expectedHeaders);
		Assert.assertEquals(actualHeaders, expectedHeaders, "Column headers do not match expected values.");
	}


	// Scenario: Verify checkbox default state beside Program Name column header

	@Then("Admin should see checkbox default state as unchecked beside Program Name column header as")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header_as() {

		Assert.assertFalse(programpage.isHeaderCheckboxChecked(),
				"Checkbox beside Program Name column should be unchecked");
		LoggerLoad.info("Checkbox beside Program Name column header is unchecked by default.");
	}

	// Scenario: Verify checkboxes default state beside each Program names in the
	// data table
	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		for (WebElement checkbox : programpage.getRowCheckboxes()) {
			Assert.assertFalse(checkbox.isSelected(), "Row checkbox should be unchecked by default.");
		}
	
		LoggerLoad.info("All row checkboxes are unchecked by default.");

	}

	// Scenario: Verify Sort icon in manage program
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {

		int actualSortIconsCount = programpage.getSortIcons().size();
		LoggerLoad.info("Verifying sortable columns have the required number of sort icons. Expected: 3, Actual: "
				+ actualSortIconsCount);
		Assert.assertEquals(actualSortIconsCount, 3, "Not all sortable columns have a sort icon.");

	}

	// Scenario: Verify edit and delete icon in manage program
	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		// Assert.assertTrue(programpage.,"Edit and Delete buttons should be present on
		// each row");

		for (WebElement[] icons : programpage.getEditDeleteIcons()) {
			Assert.assertTrue(icons[0].isDisplayed(), "Edit icon is missing.");
			Assert.assertTrue(icons[1].isDisplayed(), "Delete icon is missing.");
		}
		LoggerLoad.info("Edit and Delete icons are present on each row.");
	}

	// Scenario: Verify pagination icons below data table in manage program

	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {
		String paginationText = programpage.getPaginationText();
		Assert.assertTrue(
				programpage.getPaginationText().contains("Showing")
						&& programpage.getPaginationText().contains("entries"),
				"Pagination info text is missing or incorrect.");
		LoggerLoad.info("Pagination text is correctly displayed: " + paginationText);

	}

	// Scenario: Verify footer message in manage program

	@Then("Admin should see the footer as In total there are z programs.")
	public void admin_should_see_the_footer_as_In_total_there_are_z_programs() {

		String actualFooterText = programpage.getFooterMessage();

		Assert.assertTrue(programpage.getFooterMessage().contains("In total there are"),
				"Footer message is missing or incorrect.");

		LoggerLoad.info("Footer message is correctly displayed: " + actualFooterText);

	}
}

