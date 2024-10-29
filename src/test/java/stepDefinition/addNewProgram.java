package stepDefinition;
import comUtils.driverManager;
import comUtils.excelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import comPages.programPage;
public class addNewProgram {
	
	private SoftAssert S_Assert = new SoftAssert();
	private programPage programpage;

	public addNewProgram() {

		programpage = new programPage(driverManager.getDriver()); // Get the driver from driverManager
	}
	
	@Given("Admin in Program page")
	public void admin_in_program_page() {
	    
	}
		

		@When("Click Add New Program")
		public void click_add_new_program()  {
			
			String title=programpage.currentUrl();
			System.out.println("title: "+title);
			
			//Assert.assertTrue(title.contains("batch"));
		   
		}
		@Then("^Create New Program(.+)$")
		public void Create_New_Program(String SheetName)throws IOException {
			System.out.println("Sheetname: "+SheetName);
		    String S=programpage.addprogram(SheetName);
		    S_Assert.assertEquals(S, "Successful", "mismatch!");
		}



}
