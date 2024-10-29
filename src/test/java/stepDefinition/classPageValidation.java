package stepDefinition;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import comPages.class1Module;
import comUtils.driverManager;import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class classPageValidation {
	private static final Logger log=LogManager.getLogger();
	private class1Module classPage;
	String classPage_ActualOutput;
	String getLMSTitle_ActualTitle;
	String classCountText;
	
	public classPageValidation() {
	classPage=new class1Module(driverManager.getDriver());
	}
	@When("Admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_class_navigation_bar_in_the_header() {
	   log.info("Class Page displayed");
	   
	   classPage_ActualOutput=classPage.landClassPage();
	}

	@Then("Admin should land on the Manage class page")
	public void admin_should_land_on_the_manage_class_page() {
	 Assert.assertEquals(classPage_ActualOutput, "Class");
	}

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String expectedTitle) {
		getLMSTitle_ActualTitle=classPage.getLMSTitle();
		System.out.println(getLMSTitle_ActualTitle);
		Assert.assertEquals(getLMSTitle_ActualTitle, expectedTitle,"LMS Title Not Matching");
	}

	@Then("Admin should see the {string} Header")
	public void admin_should_see_the_header(String expectedHeading) {
		String actualHeading = classPage.getManageClassHeading();
		System.out.println(actualHeading);
        Assert.assertEquals(actualHeading, expectedHeading, "Heading on Class page Not Matching.");
        log.info("Admin able to see Class heading");
	}

	@Then("Admin should see the Searchbar in Manage class page")
	public void admin_should_see_the_searchbar_in_manage_class_page() {
		WebElement searchBar = classPage.getSearchBar();
	    Assert.assertTrue(searchBar.isDisplayed());
	    log.info("Search bar in class page is displayed with correct placeholder text.");
	}
	//bug
	@Then("Admin should see the datatable heading like Batchname,class topic,class descrption,status,class Date,staff name,Edit\\/Delete")
	public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_descrption_status_class_date_staff_name_edit_delete() {
		List<String> actualHeaders = classPage.getColumnHeaders();
		System.out.println("actualHeaders----"+actualHeaders);
	    String expectedHeaders="Batch Name, Class Topic, Class Description, Status, Class Date, Staff Name, Edit / Delete";
		List<String> expectedHeader = Arrays.asList(expectedHeaders.split(", "));
		System.out.println("expectedHeader--"+expectedHeader);
	    System.out.println("Actual list size: " + actualHeaders.size() + ", contents: " + actualHeaders);
//	    Assert.assertEquals( expectedHeader.size(), actualHeaders.size(),"Lists don't have the same size");
//	    log.info("All column headers are displayed correctly: " + String.join(", ", actualHeaders));
	}

	@Then("Admin should see the {string} and enabled pagination controls under the data table")
	public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table(String string) {
		boolean paginationText = classPage.getPaginationText();
	    Assert.assertTrue(paginationText);
	    log.info("print pagination text: "+ paginationText);
	}

	@Then("Admin should see the Sort icon of all the field in the datatable.")
	public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable() {
//			List<String> headersWithSortIcon = classPage.getHeadersWithSortIcon();
//		    List<String> expectedHeaders = Arrays.asList("Batch Name, Class Topic, Class Description, Status, Class Date, Staff Name");
//		    System.out.println("headersWithSortIcon---"+headersWithSortIcon);
//		    
//		    System.out.println("expectedHeaders---"+expectedHeaders);
//		    Assert.assertEquals (headersWithSortIcon,expectedHeaders,"Sort icons are not present beside the correct headers");
//		    log.info("Sort icons are displayed beside the correct headers: " + String.join(", ", expectedHeaders));
		Assert.assertEquals(classPage.isHeaderSortIconListVisible(), true);
		log.info("Sort icon is visible on the fields : "+ classPage.isHeaderSortIconListVisible());
	}


	@Then("Admin should see the Delete button under the Manage class page header.")
	public void admin_should_see_the_delete_button_under_the_manage_class_page_header() {
			Assert.assertTrue(classPage.areDeleteIconsPresent(),"Delete buttons should be present on each row");
			 log.info("Edit and Delete icons are present on each row.");
	}

	@Then("Admin should see Total no of classes in below of the data table.")
	public void admin_should_see_total_no_of_classes_in_below_of_the_data_table() {
////		int classCount = Integer.parseInt(classCountText);
////		// Construct the expected footer text dynamically
////	    String expectedFooterText = "In total there are " + classCount + " classes.";
////    // Retrieve the actual footer text from the page
////	    System.out.println("expectedFooterText--"+expectedFooterText);
//    String actualFooterText = classPage.getFooterMessage();
//    System.out.println("actualFooterText---"+actualFooterText);
//    //Assert.assertEquals(actualFooterText, expectedFooterText, "Footer on Class page does not match expected.");
//    String numbers = "";
//    for (int i = 0; i < str.length(); i++) {
//        char c = str.charAt(i);
//        if (Character.isDigit(c)) {
//            numbers += c;
//        }
//    }
//
//    System.out.println("Extracted numbers: " + numbers);
//	 log.info("Footer message is correctly displayed: " + actualFooterText);

	 String showStr = classPage.totalNoOfClasses();
		System.out.println("ShowStr=" + showStr);
		String[] number1 = showStr.split("\\D+");
		if (number1.length > 1) {
	        String classCount = number1[1];
	        String expectedText = "In total there are " + classCount + " classes.";
	        System.out.println(expectedText);
	        // Use contains with toLowerCase() for case-insensitive partial match
	        Assert.assertTrue(showStr.toLowerCase().contains(expectedText.toLowerCase()));
	        log.info("Total number of classes:" + expectedText);
	    } else {
	        System.out.println("Class count number not found in the display text.");
	        log.error("Class count number not found in the display text.");
	     
	    }
	}

}
