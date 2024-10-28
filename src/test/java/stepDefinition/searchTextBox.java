package stepDefinition;

import org.testng.asserts.SoftAssert;

import comPages.batchModule;
import comUtils.driverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchTextBox {
	

	private batchModule page;
	private SoftAssert S_Assert = new SoftAssert();

	public searchTextBox() {
        page = new batchModule(driverManager.getDriver()); // Get the driver from driverManager
    }
	
	@When("Enter Text in search TextBox")
	public void enter_in_search_text_box() {
		
		page.searchtext();
	  
	}

	@Then("Searched text should come on the top of the batch page")
	public void searched_text_should_come_on_the_top_of_the_batch_page() {
		Boolean result=page.searchtextvalidation();
		S_Assert.assertTrue(result);
	
	}

}
