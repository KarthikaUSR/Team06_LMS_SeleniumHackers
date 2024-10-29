package comPages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import comUtils.loggerLoad;
import io.github.bonigarcia.wdm.online.HttpClient;
import comUtils.commonFunctions;
import comUtils.excelReader;


import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import pojo.programRecords;

public class programPage {

	WebDriver driver;
	WebDriverWait wait;
	public commonFunctions comMethod;
	public excelReader readbatch = new excelReader();

	By programMenu = By.xpath("//button[@id='program']");
	By addNewProgram = By.xpath("//*[@class='mat-focus-indicator mat-menu-item ng-tns-c225-2']");
	By pageName = By.xpath("//*[@class='ng-star-inserted']/button[1]/span[1]");
	By manageProgram = By.xpath("//div[normalize-space()='Manage Program']");
	By programHeading = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	By Login_btn=By.xpath("//span[text()='Login']");

	// Table headers
	By columnHeaders = By.xpath("//table//th");
	By programName = By.xpath("//th[normalize-space()='Program Name']");
	By programDesc = By.xpath("//th[normalize-space()='Program Description']");
	By programStatus = By.xpath("//th[normalize-space()='Program Status']");
	By programEditDeleteColumn = By.xpath("//th[normalize-space()='Edit / Delete']");
	By otherModules = By.xpath("//nav//a");
	By deleteAllButton = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");

	By searchTab = By.xpath("//input[@id='filterGlobal']");

	By footerText = By.xpath("//div[@class='p-datatable-footer ng-star-inserted']");

	By paginationText = By.xpath("//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']");

	By sortIcon = By.xpath("//table//th[contains(@class, 'sortable')]");

	By rowCheckBox = By.xpath("//tbody[@class='p-datatable-tbody']");

	By headerCheckBox = By.xpath("//div[@class='p-checkbox-box']");

	By searchResultName = By.xpath("//table[@id='resultsTable']//tr[1]//td[1]");
	By searchResultDescription = By.xpath("//table[@id='resultsTable']//tr[1]//td[2]");
	By searchResultStatus = By.xpath("//table[@id='resultsTable']//tr[1]//td[3]");

	public programPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void programMenuclick() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(programMenu));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

	}

	public void clickNewProgram(String option, String menu) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add New Program']")));
		element.click();

	}

	public void programaddclick() {

		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add New Program']")));
		element.click();

	}

	public boolean isProgramDetailsPopupVisible() {
		return wait
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//*[contains(@class, 'p-dialog-header') and contains(@class, 'ng-star-inserted')]")))
				.isDisplayed();

	}

	public String getPopupTitle() {

		return driver.findElement(By.xpath("//span[text()='Program Details']")).getText();

	}

	public boolean isMandatoryFieldMarked(String fieldName) {
		WebElement fieldLabel = driver
				.findElement(By.xpath(" //label[@for='" + fieldName + "']//span[contains(text(),'*')]"));
		System.out.println(fieldLabel);
		return fieldLabel.isDisplayed();
	}

	public String clickManageProgram() {
		String actualMessage = driver.findElement(By.xpath("//div[normalize-space()='Manage Program']")).getText();
		System.out.println(actualMessage);
		return actualMessage;

	}

	public String getProgramHeading() {
		WebElement element = driver.findElement(programHeading);
		return element.getText();
	}

	public String getManageProgramHeading() {
		WebElement element = driver.findElement(manageProgram);
		return element.getText();
	}

	public String getSubMenu(String subMenuName) {
		driver.findElement(By.xpath("//button[contains(text(),'" + subMenuName + "')]"));
		String actual = driver.findElement(By.xpath("//button[@role='menuitem']")).getText();
		return actual;
		
	}

	public void ClickSubMenu() {

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(addNewProgram));
		element.click();
	}

	public String viewlogout() {

		String actual = driver.findElement(By.xpath("//button[normalize-space()='Logout']")).getText();
		return actual;

	}

	public List<String> getDisplayedModuleNames() {
		List<WebElement> moduleElements = driver.findElements(By.xpath("//div[@class='ng-star-inserted']//span[1]"));
		List<String> actualModules = new ArrayList<>();
		for (WebElement module : moduleElements) {
			actualModules.add(module.getText().trim());
		}
		return actualModules;
	}

	public void verifyModuleNamesInOrder(String expectedModules) {
//	   
		String[] expectedModuleArray = expectedModules.split(" ");
		List<String> actualModules = getDisplayedModuleNames();

		// Assert that the actual modules list size matches expected size
		Assert.assertEquals(actualModules.size(), expectedModuleArray.length,
				"Number of modules does not match expected count.");

		// Assert that each module name matches the expected order
		for (int i = 0; i < expectedModuleArray.length; i++) {
			Assert.assertEquals(actualModules.get(i), expectedModuleArray[i], "Module name mismatch at index " + i
					+ ": expected " + expectedModuleArray[i] + " but found " + actualModules.get(i));
		}

		// Print success message if all checks pass
		System.out
				.println("All module names are displayed in correct order: " + String.join(", ", expectedModuleArray));

	}

	public List<String> getColumnHeaders() {
		List<WebElement> headers = driver.findElements(columnHeaders);
		List<String> headerTexts = new ArrayList<>();
		for (WebElement header : headers) {
			headerTexts.add(header.getText());
		}
		return headerTexts;
	}

	public List<WebElement> getProgramDetails() {
		return driver.findElements(By.xpath("//tbody[@class='p-datatable-tbody']"));
	}

	public List<Program> getAllPrograms() {

		List<WebElement> programElements = driver.findElements(By.xpath("//div[@class='program']"));
		return programElements.stream().map(el -> {
			String name = el.findElement(programName).getText();
			String description = el.findElement(programDesc).getText();
			String status = el.findElement(programStatus).getText();
			return new Program(name, description, status);
		}).collect(Collectors.toList());
	}

	public WebElement getDeleteButton() {
		return driver.findElement(deleteAllButton);
	}

	public WebElement getSearchBar() {
		return driver.findElement(searchTab);
	}

	public boolean isHeaderCheckboxChecked() {
		WebElement headerCheckbox = driver.findElement(headerCheckBox);
		return headerCheckbox.isSelected();
	}

	public List<WebElement> getRowCheckboxes() {
		return driver.findElements(rowCheckBox);
	}


	public List<WebElement> getSortIcons() {
		return driver.findElements(sortIcon);

	}

//	public List<String> getHeadersWithSortIcon() {
//
//		List<WebElement> sortIconHeaders = driver.findElements(sortIcon);
//		return sortIconHeaders.stream().map(WebElement::getText).collect(Collectors.toList());
//	}

//	public boolean areEditAndDeleteIconsPresent() {
//		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody/tr"));
//		return rows.stream().allMatch(row -> row.findElements(By.id("editProgram")).size() > 0
//				&& row.findElements(By.id("deleteProgram")).size() > 0);
//	
//	}

	public List<WebElement[]> getEditDeleteIcons() {
		List<WebElement[]> icons = new ArrayList<>();
		List<WebElement> rows = driver.findElements(By.xpath("//tbody[@class='p-datatable-tbody']"));

		for (WebElement row : rows) {
			WebElement editIcon = row.findElement(By.id("editProgram"));
			WebElement deleteIcon = row.findElement(By.id("deleteProgram"));
			icons.add(new WebElement[] { editIcon, deleteIcon });
		}
		return icons;
	}

	public String getFooterMessage() {
		return driver.findElement(footerText).getText();

	}

	public String getPaginationText() {
		return driver.findElement(paginationText).getText();
	}

//Adding a program UI Validation

	By Name = By.xpath("//input[@id='programName']");

	By programNameTextBox = By.xpath("//input[@id='programName']");
	//// label[@for='programName']/following-sibling::input[1]
	By programdescriptionTextbox = By.xpath("//label[@for='programDescription']/following-sibling::input");

	By activeStatus = By.id("category");

	By inactiveStatus = By.xpath("//div[@class='p-radiobutton-box']/span[2]");

	By saveButton = By.xpath("//button[@label='Save']");

	By cancel = By.xpath("//button[@label='Cancel']");

	By closeButton = By.xpath("//*[@header='Batch Details']//button[@type='button']");
//Error
	By toatsmessage = By.xpath("//div[contains(@class, 'p-toast-summary') and text()='Successful']");

	By toastCheckMessage = By
			.xpath("//div[contains(@class, 'p-toast-detail ng-tns-c91-73') and text()='Program Created Successfully']");

	By BlankFieldError = By.xpath("//*[@class='p-invalid ng-star-inserted'][1]");
	By programDetailsTitle = By.xpath("//span[text()='Program Details']");
	By requiredFieldMessage = By.className("p-invalid");

	public boolean isPageDisplayed() {

		// return driver.findElement(programNameTextBox).isDisplayed();
		return wait.until(ExpectedConditions.visibilityOfElementLocated(programNameTextBox)).isDisplayed();

	}

	public By getRequiredFieldMessageLocator() {
		return requiredFieldMessage;
	}

	public String getRequiredFieldMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(requiredFieldMessage));
		return driver.findElement(requiredFieldMessage).getText();
	}

	public void getErr() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(getRequiredFieldMessageLocator()));
	}

	public void enterProgramName(String programname) {
		WebElement nameField = driver.findElement(programNameTextBox);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nameField);
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", nameField); // Clear
		((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", nameField, programname); // Enter
																													// text
	}

//    public void enterDescription(String description) {
//    	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(programdescriptionTextbox));
//		element.clear();
//    	element.sendKeys(description);
//        
//    }

	public void enterDescription(String description) {

		WebElement descriptionField = driver.findElement(programNameTextBox);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", descriptionField);
		((JavascriptExecutor) driver).executeScript("arguments[0].value='';", descriptionField); // Clear
		((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", descriptionField, description); // Enter
																														// text
	}

	public String getDescription() {
		return driver.findElement(programdescriptionTextbox).getAttribute("value");
	}

	public String getProgramName() {
		return driver.findElement(programNameTextBox).getAttribute("value");
	}

	public void selectStatus(String status) {
		if (status.equalsIgnoreCase("Active")) {
			driver.findElement(activeStatus).click();
		} else {
			driver.findElement(inactiveStatus).click();
		}

	}

	public String getSelectedStatus() {
		if (driver.findElement(activeStatus).isSelected()) {
			return "Active";
		} else {
			return "Inactive";
		}

	}

	public void enterMandatoryDetails(String programname, String description, String status) {
		enterProgramName(programname);
		enterDescription(description);
		selectStatus(status);
	}

	public String getSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		String element1 = wait.until(ExpectedConditions.elementToBeClickable(toastCheckMessage)).getText();
		return element1;
	}

	public void clickSave() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void clickCloseButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(closeButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
//        WebElement closeBtn = driver.findElement(closeButton);
//        closeBtn.click();
	}

	public void clickCancel() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(cancel));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

	}

	public boolean isFormClosed() {

		try {
			// Wait for the form to close (or for the element to disappear)
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(programNameTextBox));
			return true; // Form is confirmed closed if this line is reached
		} catch (TimeoutException e) {
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}

		// return !driver.findElement(programNameTextBox).isDisplayed();
	}

	public boolean verifyProgramRecord(String expectedName, String expectedDescription, String expectedStatus) {
		String actualName = driver.findElement(searchResultName).getText();
		String actualDescription = driver.findElement(searchResultDescription).getText();
		String actualStatus = driver.findElement(searchResultStatus).getText();

		return actualName.equals(expectedName) && actualDescription.equals(expectedDescription)
				&& actualStatus.equals(expectedStatus);
	}

	public boolean isProgramDetailsFormDisplayed() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(programDetailsTitle)).isDisplayed();
		// return driver.findElement(programDetailsTitle).isDisplayed();
	}

	public String getErrorMessage() {

		return driver.findElement(BlankFieldError).getText();
	}

	public void verifyMandatoryFieldError(String fieldName) {
		Assert.assertTrue(getErrorMessage().contains(fieldName + " is required"));

	}

	public String currentUrl() {
		return driver.getCurrentUrl();
	}
	/// auto add batch start

	public String addprogram(String Name) throws IOException {

		List<programRecords> programRecordlist = new ArrayList<>();
		programRecordlist = readbatch.readExcel_ProgramRecords(Name);

		try {
			if (programRecordlist != null) {

				for (programRecords record : programRecordlist) {

					programMenuclick();
					System.out.println("Click program");
					programaddclick();
					System.out.println("Click Add new program");

//   		WebElement program_progmatch=comMethod.presenceOfElementLocated(programNameTextBox);
//	   program_progmatch.clear();
					// comMethod.presenceOfElementLocated
					// comMethod.visibilityOfElementLocated
					WebElement name = driver.findElement(programNameTextBox);
					name.click();
					name.sendKeys(record.getName());
					loggerLoad.info("Name from the excel");

					WebElement prg_Desc = driver.findElement(programdescriptionTextbox);
					prg_Desc.click();
					prg_Desc.sendKeys(record.getDescription());
					loggerLoad.info("Description from excel");
					// comMethod.elementToBeClickable
					WebElement prgstatus_Active = driver.findElement(activeStatus);
					prgstatus_Active.click();
					// comMethod.elementToBeClickable
					WebElement prg_Savebutton = driver.findElement(saveButton);
					prg_Savebutton.click();
				}
			}
		} catch (Exception e) {
			System.out.println("Record completed");
		}
		String Succes_msg = handlealert();

		return Succes_msg;

	}

	public String handlealert() {
		By toastLocator = By.cssSelector("div.p-toast-message-content[role='alert']");

		// Wait for the toast to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));

		// Retrieve and print the toast message text
		String toastMessage = toastElement.getText();
		System.out.println("Toast Message: " + toastMessage);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toatsmessage));
		return toastMessage;
	}

	// Delete Program

	By programNameLocator = By.xpath("//tr[1]/td[2]"); // Program Name of the first record
	By checkFirstProgram = By.xpath("(//div[@role='checkbox'])[2]");
	// tr[2]/..//div[@class='p-checkbox p-component']
	By deleteButtonLocator = By.xpath("//tr[1]//button[contains(@id, 'deleteProgram')]"); // First delete button
	By confirmYesButton = By.xpath("//span[contains(text(),'Yes')]"); // Confirm delete button
	By confirmNoButton = By.xpath("//span[contains(text(),'No')]"); // Confirm delete button
	By confirmationFormElement=By.xpath("/div[@class='ng-trigger ng-trigger-animation ng-tns-c204-7 p-dialog p-confirm-dialog p-component ng-star-inserted']");

	By closeDelete=By.xpath("//div[@class='p-dialog-header-icons ng-tns-c204-7']/button[@type='button']");
	
	By searchBoxLocator = By.xpath("//input[@placeholder='Search...']"); // Search box locator
	By noResultsMessage = By.xpath("//div[text()='No results found']"); // No results message locator
	By batchButton=By.xpath("//*[@class='ng-star-inserted']/button[2]");


	public List<WebElement[]> getDeleteIcons() {
		List<WebElement[]> icons = new ArrayList<>();
		List<WebElement> rows = driver.findElements(By.xpath("//tbody[@class='p-datatable-tbody']"));

		for (WebElement row : rows) {
			WebElement deleteIcon = row.findElement(By.id("deleteProgram"));
			icons.add(new WebElement[] { deleteIcon });
		}
		return icons;
	}

	public void clickanywhere() {

		// Use JavaScript to click at the (0, 0) coordinate to clear any overlays
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.elementFromPoint(0, 0).click();");
	}

	// Method to get program name of the first record
	public String getFirstProgramName() {

		clickanywhere();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement programNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(programNameLocator));
		System.out.println(programNameElement.getText());
		return programNameElement.getText();
	}

	public void checkFirstProgram() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement checkbox = driver.findElement(checkFirstProgram);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);

	}

	// Method to delete the first record
	public void deleteFirstProgram() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement delete = driver.findElement(deleteButtonLocator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete);
	}

	public String confirmYesDelete() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(confirmYesButton));
		button.click();
		System.out.println("Clicked Yes");
		String Succes_msg = handlealertdelete();

		return Succes_msg;

	}
	
	public void confirmNoDelete() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(confirmNoButton));
		button.click();
		System.out.println("Clicked No");
//		String Succes_msg = handlealertdelete();
//
//		return Succes_msg;

	}
	public boolean isConfirmationFormVisible() {
		
	    try {
	        // Check visibility of the form element
          return driver.findElement(confirmationFormElement).isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false; // Returns false if the element is not found (i.e., it's gone)
	    }
	}


	public String handlealertdelete() {
		By toastLocator = By.cssSelector("div.p-toast-message-content[role='alert']");
		By deletemsg = By.xpath("//div[text()='Program Deleted']");
		// Wait for the toast to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
		WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(deletemsg));

		String toastMessage = toastElement.getText();
		System.out.println("Toast Message: " + toastMessage);

		String Message = delete.getText();
		System.out.println("Toast Message: " + Message);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toatsmessage));
		return toastMessage;

	}

	public void closePopDeleted() {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement closeConfirm = driver.findElement(By.xpath("//span[contains(@class, 'pi pi-times')]"));    
		//WebElement closeConfirm = driver.findElement(By.xpath("//*[@class='pi pi-times ng-tns-c204-22']"));
		closeConfirm.click();
	}
	// Method to search for a program

	public void searchProgram(String programName) {
		clickanywhere();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchTab));
		searchField.click();
		System.out.println("clicks search");
		searchField.sendKeys(programName);
		// searchField.submit();
	}

	public void searchClear() {
		driver.findElement(searchTab).clear();
		driver.findElement(batchButton).click();
		

	}
	// Method to verify that no results are displayed
	public boolean isNoResultsMessageDisplayed() {
		By zero = By.xpath("//span[text()='Showing 0 to 0 of 0 entries']");
		return wait.until(ExpectedConditions.visibilityOfElementLocated(zero)).isDisplayed();
	}
	
	
}
