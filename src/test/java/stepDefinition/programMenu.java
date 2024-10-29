package stepDefinition;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import comPages.programPage;
import comUtils.loggerLoad;
import comUtils.driverManager;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.online.HttpClient;

public class programMenu {



	private static final Logger log = LogManager.getLogger(programMenu .class);

	private programPage programpage;
	
	public programMenu() {
		programpage = new programPage(driverManager.getDriver()); // Get the driver from driverManager
   
	}
	

	
	
	//Scenario: Verify heading in menu bar
	
	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String expectedHeading) {
		String actualHeading = programpage.getProgramHeading();
		System.out.println(actualHeading);
        Assert.assertEquals(actualHeading, expectedHeading, "Heading on Program page does not match expected.");
    }   
	
	
	//Verify other modules name displayed in menu bar
	
	@Then("Admin should see the module names as in order {string}")
	public void admin_should_see_the_module_names_as_in_order(String expectedModules) {
		 
        programpage.verifyModuleNamesInOrder(expectedModules);
        
    }
		
	

   // Scenario: Verify Logout displayed in menu bar
	
	
	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {
	 
		String actual = programpage.viewlogout();
        System.out.println(actual);

		Assert.assertEquals(actual, "Logout");
		loggerLoad.info("Admin able to see Logout");
	}

	
   // Scenario: Verify sub menu displayed in program menu bar

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String expectedSubMenu) {
		
        String actual= programpage.getSubMenu(expectedSubMenu)	;
        System.out.println(actual);
         Assert.assertEquals(actual, expectedSubMenu, "SubMenu doesnot match.");
         loggerLoad.info("Admin able to see submenu");
		

    }
	
//  Scenario: Verify any broken links on program page  

//	@Then("Admin should recieve {int} page not found error")
//	public void admin_should_recieve_page_not_found_error(Integer int1) throws IOException, InterruptedException  {
//		HttpClient client = HttpClient.newHttpClient();
//
//        // Create a HttpRequest with HEAD method
//        HttpRequest request = HttpRequest.newBuilder()
//            .uri(URI.create("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com"))
//            .method("HEAD", HttpRequest.BodyPublishers.noBody()) // Replacing URL usage
//            .build();
//
//        // Send the request and receive response
//        HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding()); // No body expected
//
//        // Get response code
//        int r = response.statusCode();
//        System.out.println("Http code: " + r);
//       // Assert.assertEquals(int1, r);
//		
//		}
	
}
