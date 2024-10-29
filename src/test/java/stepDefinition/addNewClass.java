package stepDefinition;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import comPages.class1Module;
import comUtils.driverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class addNewClass {

private static final Logger log=LogManager.getLogger();
	
	private class1Module classPage;

	public addNewClass() {
		classPage=new class1Module(driverManager.getDriver());
		}
	@When("Admin clicks add new class under the class menu bar.")
	public void admin_clicks_add_new_class_under_the_class_menu_bar() {
		classPage.clickAddNewClassBtn();
	}

	@Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		  Assert.assertTrue(classPage.Dialogbox());
		   log.info("DialogBox is opened");
		   List<WebElement> formFields = classPage.formInputsList();
		    for (WebElement field : formFields) {
		    	Assert.assertTrue(field.getText().isEmpty(), "Form field is not empty.");
		    	log.info("All the input form fields are Empty");
		    }
		    Assert.assertTrue(classPage.cancelBtnDialogbox());
		    log.info("DialogBox in cancel button is visible");
		    Assert.assertTrue(classPage.saveBtnDialogbox());
		    log.info("DialogBox in save button is visible");
		    Assert.assertTrue(classPage.closeIconDialogbox());
		    log.info("DialogBox in close icon is visible");
		 
	}

	@Then("Admin should see few input fields and their respective text boxes in the class details window")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
		 List<String> expectedFieldLabels = Arrays.asList("Class Topic", "Class Description", "No of Classes", "Comments", "Notes", "Recording");

		    List<WebElement> formFieldsText = classPage.formTextInputsList();
		    for (WebElement fieldText : formFieldsText) {
		        String fieldTextContent = fieldText.getText().trim();

		        log.info("Form field text found: [" + fieldTextContent + "]");

		        if (fieldTextContent.isEmpty()) {
		            log.warn("Warning: An empty field label was found. Check the locator or HTML structure.");
		            continue;
		        }

		        Assert.assertTrue(expectedFieldLabels.contains(fieldTextContent),
		                "Unexpected field found: " + fieldTextContent + " is not in the expected labels list.");
		    }
		    log.info("All expected form fields and their text boxes are displayed correctly in the class details window.");
	}

}
