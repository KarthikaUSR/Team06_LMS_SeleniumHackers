package stepDefinition;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import comPages.programPage;
import comUtils.driverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class programAddUIValidation {

	private static final Logger log = LogManager.getLogger(programPageNavigation.class);
	private programPage programpage;

	public programAddUIValidation() {

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
	
	// Scenario: Verify enter program name	
	
	@Given("Admin is on program details form")
    public void admin_is_on_program_details_form() {
        // programpage.isPageDisplayed();
		programpage.clickCloseButton();
		programpage.programMenuclick();
		programpage.ClickSubMenu();

    }

    @When("Admin enters the Name {string} in the text box")
    public void admin_enters_the_name_in_the_text_box(String programname) {
        programpage.enterProgramName(programname);
    }

    @Then("Admin can see the text {string} entered")
    public void admin_can_see_the_text_entered(String expectedName) {
        String actualName = programpage.getProgramName();
        System.out.println(actualName);
        Assert.assertEquals( expectedName, actualName, "Entered program name should match");
        programpage.clickCloseButton();
    }	  
    
    //Scenario: Verify empty form submission						
    
    @When("Admin clicks save button without entering mandatory fields")
    public void admin_clicks_save_without_entering_mandatory_fields() {
    	
        programpage.clickSave();
    }

    @Then("Admin gets message '{string} is required'")
    public void admin_gets_message_is_required(String fieldName) {
    	String expectedMessage = fieldName + " is required"; // Create the expected message
     programpage.getErr();
        
        String actualMessage = programpage.getRequiredFieldMessage(); // Get the actual message
        
        // Assert that the expected message matches the actual message
        Assert.assertEquals("Required field message should match", expectedMessage, actualMessage);
    
}
    
    //	Scenario: Verify cancel button	

    @When("Admin clicks Cancel button")
    public void admin_clicks_cancel() {
        programpage.clickCancel();
    }

    @Then("Admin can see Program Details form disappears")
    public void verify_program_details_form_disappears() {
        Assert.assertFalse(programpage.isProgramDetailsFormDisplayed(),"Program Details form is still displayed");
    }
    
  
    //Scenario: Verify enter description	
    
    @When("Admin enters the Description {string} in text box")
    public void admin_enters_the_description_in_text_box(String description) {
        programpage.enterDescription(description);
    }

    @Then("Admin can see the text {string} entered in description box")
    public void admin_can_see_the_text_entered_in_description_box(String expectedDescription) {
        String actualDescription = programpage.getDescription();
        Assert.assertEquals( expectedDescription, actualDescription ,"Entered description should match");
    }

    //	 Scenario: Verify select Status	

    @When("Admin selects the status of the program by clicking on the radio button {string}")
    public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button(String status) {
        programpage.selectStatus(status);
    }

    @Then("Admin can see {string} status selected")
    public void admin_can_see_status_selected(String expectedStatus) {
        String actualStatus = programpage.getSelectedStatus();
        Assert.assertEquals("Selected status should match", expectedStatus, actualStatus);
    }
    
   // Scenario: Verify Admin is able to save the program details	

    @When("Admin enters valid details for mandatory fields and Click on save button")
    public void admin_enters_valid_details_for_mandatory_fields_and_click_on_save_button() {
        programpage.enterMandatoryDetails("Test Program", "This is a test description", "Active");
        programpage.clickSave();
    }

    @Then("Admin gets message {string}")
    public void admin_gets_message(String expectedMessage) {
        String actualMessage = programpage.getSuccessMessage();
        Assert.assertEquals( expectedMessage, actualMessage ,"Success message should match");
    }

	// Scenario: Verify cancel program details
    @When("Admin Click on cancel button")
    public void admin_click_on_cancel_button() {
        programpage.clickCancel();
    }

    @Then("Admin can see program details form disappear")
    public void admin_can_see_program_details_form_disappear() {
        Assert.assertTrue(programpage.isFormClosed(),"Program details form should disappear");
    }
    
	// Scenario: Verify added Program is created	
    
    @When("Admin searches with newly created {string}")
    public void admin_searches_with_newly_created(String programname) {
        programpage.searchProgram(programname);
    }

    @Then("Records of the newly created {string} are displayed and match the data entered")
    public void Records_of_the_newly_created_are_displayed_and_match_the_data_entered(String programname) {
        
        Assert.assertTrue(programpage.verifyProgramRecord(programname, "This is a test description", "Active"), 
                "New program record should match entered data");
    }  
	// Scenario: Verify close window with "X" 	

    @When("Admin Click on {string} button")
    public void Admin_click_on_button(String button) {
        if (button.equals("X")) {
            programpage.clickCloseButton();
        }
    }
}

	


