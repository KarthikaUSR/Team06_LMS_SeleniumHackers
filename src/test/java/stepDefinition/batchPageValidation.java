package stepDefinition;

import org.testng.Assert;

import comPages.batchModule;
import comUtils.driverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class batchPageValidation {

	private batchModule page;

	public batchPageValidation() {
        page = new batchModule(driverManager.getDriver()); // Get the driver from driverManager
    }
	
	
	
	@When("Admin in batch page")
	public void admin_in_batch_page() {
		String batchlabel=page.labelBatch();
		Assert.assertEquals(batchlabel, "Batch");

	}

	@Then("Validate Title in Batch Page")
	public void validate_title_in_batch_page() {
		String title=page.title();
		Assert.assertEquals(title, "LMS");
		

	}

	@Then("Validate Heading in Batch Page")
	public void validate_heading_in_batch_page() {
		String batchlabel=page.batchheading();
		Assert.assertEquals(batchlabel, "Manage Batch");

	}


}
