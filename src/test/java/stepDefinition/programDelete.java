package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import comPages.programPage;
import comUtils.loggerLoad;
import comUtils.driverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class programDelete {
	private static final Logger log = LogManager.getLogger(programPageValidation.class);

	private programPage programpage;
	String deletedProgramName;
	public programDelete() {
		programpage = new programPage(driverManager.getDriver()); // Get the driver from driverManager
	}
	
	
	//  Scenario: Verify delete feature

	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() {
		
		deletedProgramName = programpage.getFirstProgramName();
		System.out.println(deletedProgramName);
		programpage.checkFirstProgram();
        programpage.deleteFirstProgram();
        loggerLoad.info("Deleted first row in table.");
	}
	
	@Then("Admin will get confirm deletion popup")
	public void admin_will_get_confirm_deletion_popup( ) {
	   programpage.confirmYesDelete();
		
	}
	
	//   Scenario: Verify Admin is able to deleted program	
	@When("Admin Searches for {string}")
	public void admin_searches_for(String deletedProgramName ) {
        programpage.searchProgram(deletedProgramName);
        
	}
	@Then("There should be zero results.")
	public void there_should_be_zero_results() {
		
        Assert.assertTrue(programpage.isNoResultsMessageDisplayed(),"No results should be displayed for the deleted program name");
	}
	
	//Scenario: Verify Admin is able to click 'No'
	
	@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete() {
		
		programpage.searchClear();
	   programpage.clickanywhere();
	  programpage.programMenuclick();
	   programpage.clickanywhere();

	}
	@When("Admin clicks on {string} button")
	public void admin_clicks_on_button(String string) {
		programpage.getFirstProgramName();
		   programpage.checkFirstProgram();
	       programpage.deleteFirstProgram();	
		   programpage.confirmNoDelete();
	

	}
	@Then("Admin can see Confirmation form disappears")
	public void admin_can_see_confirmation_form_disappears() {
	    Assert.assertFalse(programpage.isConfirmationFormVisible(), "The confirmation form should disappear but is still visible.");

	
	}
	
	//  Scenario: Verify Admin is able to close the window with "X" 
	@Given("Admin is on Program Confirm Deletion Page after selecting any program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_any_program_to_delete() {
		
	  // programpage.clickanywhere();
		programpage.getFirstProgramName();
		   programpage.checkFirstProgram();
	       programpage.deleteFirstProgram();	
	}
	@When ("Admin Clicks on {string} button")
	public void Admin_clicks_on_button(String button) {
            programpage.closePopDeleted();
        
    }

	@Then("Admin can see Confirm Deletion form disappear")
	public void admin_can_see_confirm_deletion_form_disappear() {
	    Assert.assertFalse(programpage.isConfirmationFormVisible(), "The confirmation form should disappear but is still visible.");

	}
	
}














