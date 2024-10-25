package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import comPages.LoginPage;
import comPages.programPage;
import comUtils.ConfigReader;
import comUtils.DriverManager;
public class programSteps {
	
	
	WebDriver driver;
	ConfigReader configReader = new ConfigReader();
	WebDriverWait wait;
	LoginPage loginPage;
	programPage programpage;
	
	public programSteps() {
		driver = DriverManager.getDriver();
		loginPage = new LoginPage(driver);
		programpage=new programPage(driver);
		
	}

	//Scenario: Verify that Admin is able to navigate to Program module
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		System.out.println(driver.getTitle());
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	}
	@When("Admin clicks {string} on the navigation bar")
	public void Admin_clicks_on_the_navigation_bar(String menuOption) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if (menuOption.equalsIgnoreCase("Program")) {

			programpage.programMenuclick();
		}
	}
	@Then("Admin should be navigated to Program module")
	public void admin_should_be_navigated_to_program_module() {
		
		String actualMessage = driver.findElement(By.xpath("//div[normalize-space()='Manage Program']")).getText();
		System.out.println(actualMessage);
		Assert.assertEquals(actualMessage, "Manage Program");
	
	
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
	
}
