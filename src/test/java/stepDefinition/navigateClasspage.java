package stepDefinition;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import comPages.batchModule;
import comUtils.driverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class navigateClasspage {
	

	private batchModule page;
	private SoftAssert S_Assert = new SoftAssert();

	public navigateClasspage() {
        page = new batchModule(driverManager.getDriver()); // Get the driver from driverManager
    }

	
    
@When("Click the Class Page tab")
public void click_the_class_page_tab() {
	page.classtabclick();
}

@Then("Admin is in Class Page")
public void admin_is_in_class_page() {
	  
 	  String title=page.currentUrl();
 	  
 	  
 	 S_Assert.assertEquals(title, "session", "mismatch!");
}

}
