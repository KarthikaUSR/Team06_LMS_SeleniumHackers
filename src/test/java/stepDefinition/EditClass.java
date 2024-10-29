package stepDefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;

import comPages.ClassModulePage;
import comPages.batchModule;
import comUtils.driverManager;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertTrue;

public class EditClass {
	
	
	ClassModulePage classPage ;
	
	public EditClass() {
        classPage = new ClassModulePage(driverManager.getDriver()); // Get the driver from driverManager
    }
	

	@Given("Admin is on the Manage Class page after login")
	public void admin_is_on_the_manage_class_page_after_login() {
		classPage.landClassPage();
		
	}
	
	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
		classPage.clickOnEditbutton();
		
	}

	
//	@Then("^ Admin edit class Program(.+)$")
//	public void  Admin_edit_class_Program(String Sheet)throws IOException {
//		System.out.println("Sheetname: "+Sheet);
//	    String S=classPage.addClass(Sheet);
//		Assert.assertEquals(S, "Successful");
//	}
	
	
	
	@Then("A new pop up with {string} appears")
	public void a_new_pop_up_with_appears(String expectedMessage) {
		try {
	       
	        String actualMessage = classPage.alertText();
	        assertTrue("Alert message does not match", actualMessage.equals(expectedMessage));
	        
	    } catch (NoAlertPresentException e) {
	        assertTrue("Alert was not displayed", false);
	    }
	    
	}




	
	

	@Then("edit class  {string}")
	public void edit_class(String Sheet) throws IOException {
		System.out.println("Sheetname: "+Sheet);
	    String S = classPage.addClass(Sheet);
		Assert.assertEquals(S, "Successful");
		
		
	}






	
	@Then("Admin should see batch name field is disabled")
	public void admin_should_see_batch_name_field_is_disabled() {
	   classPage.BatchFieldIsEnable();
	}

	@Then("Admin should see class topic field is disabled")
	public void admin_should_see_class_topic_field_is_disabled() {
		classPage.classTopicFieldIsEnable();
	}

	@Given("Admin is on the Edit Class Popup window")
	public void admin_is_on_the_edit_class_popup_window() {
		classPage.clickOnEditbutton();
		
	}

	@When("Update the fields with valid data and click save")
	public void update_the_fields_with_valid_data_and_click_save() {
		classPage.EditSaveButton();
	   
	}
	
	
	@When("Update the fields with invalid values and click save")
	public void update_the_fields_with_invalid_values_and_click_save() {
		classPage.EditSaveButton();
	}
	
	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
	   System.out.println("successful");
	}

	@Then("Admin should get Error message")
	public void admin_should_get_error_message() {
		classPage.message();
	}

	@When("Update the mandatory fields with valid values and click save")
	public void update_the_mandatory_fields_with_valid_values_and_click_save() {
		classPage.EditSaveButton();
	}

	@When("Update the optional fields with valid values and click save")
	public void update_the_optional_fields_with_valid_values_and_click_save() {
		classPage.EditSaveButton();
	}

	@When("Admin enters only numbers or special char in the text fields")
	public void admin_enters_only_numbers_or_special_char_in_the_text_fields() {
		classPage.EditSaveButton();
	}

	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
	  classPage.Editcrossbutton ();
	}

	



}
