package stepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
/*	
	@Then("Admin should see the module names as in order {string}")
	public void admin_should_see_the_module_names_as_in_order(String expectedModules) {
		
		 // Split the expected module names (coming from the feature file)
        String[] expectedModuleArray = expectedModules.split(" ");

        // Find all the modules in the navigation bar
        List<WebElement> moduleElements = driver.findElements(By.xpath("//nav//a"));  // Assuming they are within <nav> and are links <a>

        // Extract the text of each module element
        List<String> actualModules = new ArrayList<>();
        for (WebElement module : moduleElements) {
            actualModules.add(module.getText().trim());
        }

        // Verify if the actual module names match the expected module names
        for (int i = 0; i < expectedModuleArray.length; i++) {
            if (!actualModules.get(i).equals(expectedModuleArray[i])) {
                throw new AssertionError("Module name mismatch: expected " + expectedModuleArray[i] + " but found " + actualModules.get(i));
            }
        }
        
        // If everything is in order, print success message
        System.out.println("All module names are displayed in correct order: " + String.join(", ", expectedModuleArray));
    }
		
	
*/
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

//		WebElement subMenuItem = driver.findElement(By.xpath("//button[contains(text(),'" + expectedSubMenu + "')]"));
//
//		// Assert that the sub-menu item is displayed
//		Assert.assertEquals("Sub-menu item '" + expectedSubMenu + "' is not displayed under the Program menu.",
//				subMenuItem.isDisplayed());
//
//		// Print success message if the sub-menu item is displayed
//		System.out.println("Sub-menu item '" + expectedSubMenu + "' is displayed under the Program menu.");
		LoggerLoad.info("Admin able to see submenu");

    }
	
}
