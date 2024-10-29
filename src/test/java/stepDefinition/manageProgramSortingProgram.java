package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import comPages.program2Module;
import comUtils.driverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class manageProgramSortingProgram {
private static final Logger log=LogManager.getLogger();
	
	private program2Module progPage;
	
	String progPage_ActualOutput;
	
	public manageProgramSortingProgram() {
		progPage=new program2Module(driverManager.getDriver());
	}
	
	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() throws InterruptedException {
		progPage.clickProgramName();
	}

	@Then("Admin See the Program Name is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_order_descending_order() {
		progPage.sortingProgramName();
	}

	@When("Admin clicks on Arrow next to Program Description")
	public void admin_clicks_on_arrow_next_to_program_description() throws InterruptedException {
	   progPage.clickProgramDescription();
	}

	@Then("Admin See the program Description is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_description_is_sorted_in_ascending_order_descending_order() {
	  progPage.sortingProgDescription();
	}

	@When("Admin clicks on Arrow next to Program status")
	public void admin_clicks_on_arrow_next_to_program_status() throws InterruptedException {
	  progPage.clickProgramStatus();
	}

	@Then("Use See the Program Status is sorted in Ascending order\\/Descending order")
	public void use_see_the_program_status_is_sorted_in_ascending_order_descending_order() {
	   progPage.sortingProgramStatus();
	}

	}
