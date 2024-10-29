package stepDefinition;

import java.io.IOException;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import comPages.batchModule;
import comUtils.driverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addNewBatch {
	

	private batchModule page;
	private SoftAssert S_Assert = new SoftAssert();

	public addNewBatch() {
        page = new batchModule(driverManager.getDriver()); // Get the driver from driverManager
    }

		

		@When("Click Add New Batch")
		public void click_add_new_batch()  {
			
			String title=page.currentUrl();
			System.out.println("title: "+title);
			
			//Assert.assertTrue(title.contains("batch"));
		   
		}
		@Then("^Create New Batches(.+)$")
		public void Create_New_Batches(String Sheet)throws IOException {
			System.out.println("Sheetname: "+Sheet);
		    String S=page.addbatch(Sheet);
		    S_Assert.assertEquals(S, "Successful", "mismatch!");
		}


}
