package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import appHooks.applicationHooks;
import comPages.batchModule;
import comUtils.driverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class batchPageNavigation {
	private static final Logger log = LogManager.getLogger(batchPageNavigation .class);

	private batchModule page;
	
	String batchlabel;
	public batchPageNavigation() {
        page = new batchModule(driverManager.getDriver()); // Get the driver from driverManager
    }
	@When("Click Batch tab on top right corner of the LMS page")
	public void Click_Batch_tab_on_top_right_corner_of_the_LMS_page() {
		page.landbatchpage();
		batchlabel=page.checkBatchpage();
	}
	@Then("Verify the Batch page is displayed")
	public void Verify_the_Batch_page_is_displayed() {
	   	  Assert.assertEquals(batchlabel, "Batch");
	   	  String title=page.currentUrl();
	   	  System.out.println("batch url: "+title);
	   	  Assert.assertTrue(title.contains("batch"));
	}

}
