package comPages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;

public class programPage {

	WebDriver driver;
	WebDriverWait wait;
	public Alert alert;

	By programMenu = By.xpath("//button[@id='program']");
	By addNewProgram = By.xpath("//button[@role='menuitem']");
	By pageName = By.xpath("//*[@class='ng-star-inserted']/button[1]/span[1]");
	By manageProgram = By.xpath("//div[normalize-space()='Manage Program']");
	By programHeading = By.xpath("//span[normalize-space()='LMS - Learning Management System']");

	// Table headers
	By columnHeaders = By.xpath("//table//th");
	By programName = By.xpath("//th[normalize-space()='Program Name']");
	By programDesc = By.xpath("//th[normalize-space()='Program Description']");
	By programStatus = By.xpath("//th[normalize-space()='Program Status']");
	By programEditDeleteColumn = By.xpath("//th[normalize-space()='Edit / Delete']");

	By deleteAllButton = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");

	By searchTab = By.xpath("//input[@id='filterGlobal']");

	By footerText = By.xpath("//div[@class='p-datatable-footer ng-star-inserted']");

	public programPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void programMenuclick()  {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(programMenu));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

	}
	public void clickNewProgram(String option,String menu) {
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add New Program']")));
		element.click();
//		 WebElement menuElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='"+ menu +"']")));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuElement);
//
//			
//			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='"+ option +"']")));
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

//	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[(text()='" + option + "']")));
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);	       

	}
	
	public boolean isProgramDetailsPopupVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'p-dialog-header') and contains(@class, 'ng-star-inserted')]"))).isDisplayed();

        
    }
	
	 public String getPopupTitle() {
		 
	        return driver.findElement(By.xpath("//span[text()='Program Details']")).getText();
	   
	    }
	
	 public boolean isMandatoryFieldMarked(String fieldName) {
	        WebElement fieldLabel = driver.findElement(By.xpath(" //label[@for='"+ fieldName +"']//span[contains(text(),'*')]"));
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

	public String viewlogout() {

		String actual = driver.findElement(By.xpath("//button[normalize-space()='Logout']")).getText();
		return actual;

	}

	public List<String> getColumnHeaders() {
		List<WebElement> headerElements = driver.findElements(columnHeaders);
		return headerElements.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public List<Program> getAllPrograms() {
		List<WebElement> programElements = driver.findElements(By.xpath("//div[@class='program']"));
		return programElements.stream().map(el -> {
			String name = el.findElement(By.className("program-name")).getText();
			String description = el.findElement(By.className("program-description")).getText();
			String status = el.findElement(By.className("program-status")).getText();
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
		WebElement headerCheckbox = driver.findElement(By.xpath("//div[@class='p-checkbox-box']"));
		return headerCheckbox.isSelected();
	}

	public boolean areAllRowCheckboxesUnchecked() {
		List<WebElement> rowCheckboxes = driver.findElements(By.xpath(
				"/html[1]/body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]"));
		// table//td/input[@type='checkbox']
		return rowCheckboxes.stream().noneMatch(WebElement::isSelected);
	}

	public String getFooterMessage() {
		driver.findElement(footerText).getText();
		String programCountText = driver.findElement(By.id("program-count")).getText(); // Adjust selector as needed
		return programCountText;

	}

	public List<String> getHeadersWithSortIcon() {

		List<WebElement> sortIconHeaders = driver.findElements(By.xpath("//table//th[contains(@class, 'sortable')]"));
		return sortIconHeaders.stream().map(WebElement::getText).collect(Collectors.toList());
	}

	public boolean areEditAndDeleteIconsPresent() {
		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody/tr"));
		return rows.stream().allMatch(row -> row.findElements(By.id("editProgram")).size() > 0
				&& row.findElements(By.id("deleteProgram")).size() > 0);
	}

	/*
	 * // Finding all the available links on webpage
	 * 
	 * List<WebElement> links = driver.findElements(By.tagName("a"));
	 * 
	 * 
	 * // Iterating each link and checking the response status for (WebElement link
	 * : links) { String url = link.getAttribute("href"); checkForBrokenLinks(url);
	 * }
	 * 
	 * public static void checkForBrokenLinks(String url) { try { URL link = new
	 * URL(url); HttpURLConnection httpURLConnection = (HttpURLConnection)
	 * link.openConnection(); httpURLConnection.setConnectTimeout(3000); // Set
	 * connection timeout to 3 seconds httpURLConnection.connect();
	 * 
	 * 
	 * if (httpURLConnection.getResponseCode() == 200) { System.out.println(url +
	 * " - " + httpURLConnection.getResponseMessage()); } else {
	 * System.out.println(url + " - " + httpURLConnection.getResponseMessage() +
	 * " - " + "is a broken link"); } } catch (Exception e) { System.out.println(url
	 * + " - " + "is a broken link"); } }
	 * 
	 */

}
