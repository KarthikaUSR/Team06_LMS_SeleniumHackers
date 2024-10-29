package stepDefinition;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import comPages.program2Module;
import comUtils.driverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class manageProgramSearchBar {
private static final Logger log=LogManager.getLogger();

private program2Module progPage;
String progPage_ActualOutput;	
	public manageProgramSearchBar() {
		progPage=new program2Module(driverManager.getDriver());
	}
	
	@Given("Admin is on Program module")
	public void admin_is_on_program_module() {
		 log.info("Program Page displayed");
		   
		   progPage.landProgramPage();
	}

	@When("Admin enter the program to search By program name")
	public void admin_enter_the_program_to_search_by_program_name() {
	progPage.setSearchProgName();
	    
	}
	@Then("Admin should able to see Program name, description, and status for searched program name")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name() {
	 String searchResultProgName_Actual= progPage.searchResult();
	 Assert.assertEquals(searchResultProgName_Actual, "ChatBotSan");
	}

	@When("Admin enter the program to search By program description")
	public void admin_enter_the_program_to_search_by_program_description() {
		progPage.setSearchProgDescription();
	}

	@Then("Admin should able to see Program name, description, and status for searched program description")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_description() {
	 String searchResultProgDesc_Actual=progPage.searchResultProgDesc();
	 Assert.assertEquals(searchResultProgDesc_Actual, "ChatBotSan123");
	}

	@When("Admin enter the program to search By program name that does not exist")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist() {
	  progPage.setSearchProgNameInvalid();
	}

	@Then("There should be zero results.")
	public void there_should_be_zero_results() {
		String searchResultProgInvalid_Actual=progPage.searchResultProgNameInvalid();
	  Assert.assertEquals(searchResultProgInvalid_Actual, "Showing 0 to 0 of 0 entries");
	}

	@When("Admin enter the program to search By partial name of program")
	public void admin_enter_the_program_to_search_by_partial_name_of_program() {
	  progPage.setSearchProgNamePartial();
	}
}
