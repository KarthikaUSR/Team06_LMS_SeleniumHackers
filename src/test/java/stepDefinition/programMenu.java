package stepDefinition;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;

import comPages.programPage;
import comUtils.LoggerLoad;
import comUtils.driverManager;
import io.cucumber.java.en.Then;

public class programMenu {



	private static final Logger log = LogManager.getLogger(programMenu .class);

	private programPage programpage;
	
	public programMenu() {
		programpage = new programPage(driverManager.getDriver()); // Get the driver from driverManager
   
	}
	
	
	/*  Scenario: Verify any broken links on program page  

	@Then("Admin should not have any broken links for Program module")
	public void admin_should_not_have_any_broken_links_for_program_module() {
		boolean noBrokenLinks = programpage.checkForBrokenLinks();
	    Assert.assertTrue(noBrokenLinks, "There are broken links on the Program module page.");
	}
*/
	
	
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
		LoggerLoad.info("Admin able to see Logout");
	}

	
   // Scenario: Verify sub menu displayed in program menu bar

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String expectedSubMenu) {
		
        String actual= programpage.getSubMenu(expectedSubMenu)	;
        System.out.println(actual);
         Assert.assertEquals(actual, expectedSubMenu, "SubMenu doesnot match.");
		LoggerLoad.info("Admin able to see submenu");
		

    }
	
}
