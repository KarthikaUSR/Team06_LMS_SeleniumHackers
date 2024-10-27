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
	
	
	private static final Logger log = LogManager.getLogger(programPageValidation .class);

	private programPage programpage;
	String programCountText;
	
	public programPageValidation() {
		programpage = new programPage(driverManager.getDriver()); // Get the driver from driverManager
    }
	
	/*WebDriver driver;
	configReader configReader = new configReader();
	WebDriverWait wait;
	LoginPage loginPage;
	programPage programpage;
	
	public programSteps() {
		driver = DriverManager.getDriver();
		loginPage = new LoginPage(driver);
		programpage=new programPage(driver);
		
	}*/

	//Scenario: Verify that Admin is able to navigate to Program module
	
//	@Given("Admin is on dashboard page after Login")
//	public void admin_is_on_dashboard_page_after_login() {
//		System.out.println(driver.getTitle());
//		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//	}
	
	

	//    Scenario: Verify heading in manage program
	@Then("Admin should see the heading as {string}")
	public void admin_should_see_the_heading_as(String expectedHeading) {
		
		String actualHeading = programpage.getManageProgramHeading();
		System.out.println(actualHeading);
        Assert.assertEquals(actualHeading, expectedHeading, "Heading on Program page does not match expected.");
		LoggerLoad.info("Admin able to see heading");
    
	}

  //  Scenario: Verify view details of programs

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

    
  //  Scenario: Verify the Search button 


	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String expectedPlaceholder) {
		WebElement searchBar = programpage.getSearchBar();
	    Assert.assertTrue(searchBar.isDisplayed());
	    Assert.assertEquals("Search...", expectedPlaceholder, searchBar.getAttribute("placeholder")); 
	    LoggerLoad.info("Search bar is displayed with correct placeholder text.");

	}

    //Scenario: Verify column header name of data table--------------------------NOt SURE
	
	
	@Then("Admin should see data table with column header on the Manage Program Page as {string}")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as(String expectedHeaders) {
		
		List<String> actualHeaders = programpage.getColumnHeaders();
	    List<String> expectedHeader = Arrays.asList(expectedHeaders.split(", "));

	    System.out.println("Expected list size: " + expectedHeader.size() + ", contents: " + expectedHeader);
	    System.out.println("Actual list size: " + actualHeaders.size() + ", contents: " + actualHeaders);
	    Assert.assertEquals( expectedHeader.size(), actualHeaders.size(),"Lists don't have the same size");
	    LoggerLoad.info("All column headers are displayed correctly: " + String.join(", ", actualHeaders));
	  
	}

	//    Scenario: Verify checkbox default state beside Program Name column header

	@Then("Admin should see checkbox default state as unchecked beside Program Name column header as")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header_as() {
		
		Assert.assertFalse(programpage.isHeaderCheckboxChecked(),"Checkbox beside Program Name column should be unchecked");
		 LoggerLoad.info("Checkbox beside Program Name column header is unchecked by default.");
	}

	

	
	//  Scenario: Verify checkboxes default state beside each Program names in the data table 
	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		
		Assert.assertTrue(programpage.areAllRowCheckboxesUnchecked(),"All row checkboxes should be unchecked by default");
		 LoggerLoad.info("All row checkboxes are unchecked by default.");
	
	}



	
	//     Scenario: Verify Sort icon in manage program
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		List<String> headersWithSortIcon = programpage.getHeadersWithSortIcon();
	    List<String> expectedHeaders = Arrays.asList("Program Name", "Program Description", "Program Status");

	    Assert.assertEquals (expectedHeaders, headersWithSortIcon,"Sort icons are not present beside the correct headers");
	    LoggerLoad.info("Sort icons are displayed beside the correct headers: " + String.join(", ", expectedHeaders));
	}

	

	
	//    Scenario: Verify edit and delete icon in manage program
	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		Assert.assertTrue(programpage.areEditAndDeleteIconsPresent(),"Edit and Delete buttons should be present on each row");
		 LoggerLoad.info("Edit and Delete icons are present on each row.");
	}
	
		

	//    Scenario: Verify pagination icons below data table in manage program
	
//	@Then("Admin should see the text as {string} along with Pagination icon below the table.")--------------LAST
//	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {
//		String paginationText = programpage.getPaginationText();
//	    Assert.assertTrue("Pagination text format is incorrect", paginationText.matches("Showing \\d+ to \\d+ of \\d+ entries"));
//	    Assert.assertTrue("Pagination icon is not displayed", programpage.isPaginationIconDisplayed());
//	    System.out.println("Pagination text and icons are correctly displayed.");
//	}



	
	//    Scenario: Verify footer message in manage program

//
//	@Then("Admin should see the footer as {string}.")
//	public void admin_should_see_the_footer_as(String expectedFooterText) {
		
		@Then("Admin should see the footer as In total there are z programs.")
		public void admin_should_see_the_footer_as_In_total_there_are_z_programs() {
		
			int programCount = Integer.parseInt(programCountText);
			// Construct the expected footer text dynamically
		    String expectedFooterText = "In total there are " + programCount + " programs";
	    // Retrieve the actual footer text from the page
	    String actualFooterText = programpage.getFooterMessage();

	    // Assert that the actual footer matches the expected footer
	    Assert.assertEquals(actualFooterText, expectedFooterText, "Footer on Program page does not match expected.");

		 LoggerLoad.info("Footer message is correctly displayed: " + actualFooterText);

	    
	}



	
}
