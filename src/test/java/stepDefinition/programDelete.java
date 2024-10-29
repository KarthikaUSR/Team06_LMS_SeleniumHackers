package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import comPages.programPage;
import comUtils.LoggerLoad;
import comUtils.driverManager;
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
		LoggerLoad.info("Deleted first row in table.");
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
	
}
