package stepDefinition;

import org.testng.asserts.SoftAssert;

import comPages.batchModule;
import comUtils.driverManager;
import io.cucumber.java.en.Then;

public class addNewBatchUI {

	private batchModule page;
	private SoftAssert S_Assert = new SoftAssert();

	public addNewBatchUI() {
        page = new batchModule(driverManager.getDriver()); // Get the driver from driverManager
    }
	
	@Then("Verify sub menu displayed in batch menu bar")
	public void verify_sub_menu_displayed_in_batch_menu_bar() {
		String name=page.addbatchUI();
		S_Assert.assertEquals(name, "Add New Batch", "Add batch mismatch!");

	}

	@Then("Validate Admin able to click on the Add new Batch Option")
	public void validate_admin_able_to_click_on_the_add_new_batch_option() {
		String name=page.addbatchpopup();
		S_Assert.assertEquals(name, "Batch Details", "AddBatch header mismatch!");

	}

}
