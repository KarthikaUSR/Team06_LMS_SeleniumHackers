package stepDefinition;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import comPages.programPage;
import comUtils.LoggerLoad;
import comUtils.driverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class programPageNavigation {

	private static final Logger log = LogManager.getLogger(programPageNavigation.class);

	private programPage programpage;

	public programPageNavigation() {

		programpage = new programPage(driverManager.getDriver()); // Get the driver from driverManager
	}

	@When("Admin clicks {string} on the navigation bar")
	public void Admin_clicks_on_the_navigation_bar(String menuOption) throws InterruptedException {
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if (menuOption.equalsIgnoreCase("Program")) {

			programpage.programMenuclick();
		}
	}

	@Then("Admin should be navigated to Program module")
	public void admin_should_be_navigated_to_program_module() {
		String actualMessage = programpage.clickManageProgram();
		Assert.assertEquals(actualMessage, "Manage Program");

	}

}