package comPages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Then;

public class class1Module {
	private WebDriver driver;
	

		By clkClassBtn=By.xpath("//*[@class='ng-star-inserted']/button[3]");
		By classPageName=By.xpath("//*[@class='ng-star-inserted']/button[3]/span[1]");
		By getLMSTitle=By.xpath("//span[.=' LMS - Learning Management System ']");
		By manageclass=By.xpath("//div//div[.=' Manage Class']");
		By searchTab=By.id("filterGlobal");
		By dataTableHeaders=By.xpath("//table//th");
		By sortIconClassHeader=By.xpath("//table//th[contains(@class, 'sortable')]");
		By sortIconList=By.xpath("//*[@psortablecolumn]//i");
		By deleteButtonTable=By.xpath("//table//tbody/tr");
		By deleteButton=By.xpath("//table//tbody/tr//div[@class='action']//span[@class='p-button-icon pi pi-trash']");
		By totalClass=By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");
		By paginationText=By.xpath("//span[@class='p-paginator-current ng-star-inserted']");	
		
		
		 By addNewClass=By.xpath("//button[normalize-space()='Add New Class']");
		 By dialog=By.xpath("//div[@role='dialog']");
		 By dialogCancelBtn=By.xpath("//button[@class='p-button-rounded p-button-danger p-button p-component ng-star-inserted']");
		 By dialogSaveBtn=By.xpath("//button[@id='saveClass']");
		 By dialogCloseBtn=By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[1]/div/button");
		 By forminputs=By.tagName("input");
		 By formTextInputs=By.xpath("//*[@type='text']");
		  		
		public class1Module(WebDriver driver) {
			this.driver=driver;
	        }
		public String landClassPage() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
			wait.until(
		            ExpectedConditions.elementToBeClickable(clkClassBtn));	        
			driver.findElement(clkClassBtn).click();
			String classPageName_Actual =driver.findElement(classPageName).getText();
			return classPageName_Actual;
}
		public String getLMSTitle() {
			String getLMSTitle_Actual=driver.findElement(getLMSTitle).getText();
		return getLMSTitle_Actual;
		}
		
		public String getManageClassHeading() {
			WebElement element = driver.findElement(manageclass);
			return element.getText();
		}
		public WebElement getSearchBar() {
			return driver.findElement(searchTab);
		}
		
		public boolean isHeaderSortIconListVisible() {
			boolean state = true;
			List<WebElement> headerSortIconList=driver.findElements(sortIconList);
			for(WebElement sortIcon: headerSortIconList ) {
				state = sortIcon.isDisplayed();
				if (!state)
				 {
					break;  
				}
			}
			return state;
		}
		
		public List<String> getColumnHeaders() {
			List<WebElement> headerElements = driver.findElements(dataTableHeaders);
			return headerElements.stream().map(WebElement::getText).collect(Collectors.toList());
		}
		
		public boolean areDeleteIconsPresent() {
			List<WebElement> rows = driver.findElements(deleteButtonTable);
			return rows.stream().allMatch(row -> row.findElements(deleteButton).size() > 0);
		}
		public String totalNoOfClasses() {
			String totalClassValue=driver.findElement(totalClass).getText().toString();
			return totalClassValue;
		}
		
		public boolean getPaginationText() {	
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(paginationText));
			return subMenuItem.getText() != null;
		}
		
		
		public void clickAddNewClassBtn() {
			driver.findElement(addNewClass).click();
		}
		public boolean Dialogbox() {
			return driver.findElement(dialog).isDisplayed();
		}
		public boolean cancelBtnDialogbox() {
			return driver.findElement(dialogCancelBtn).isDisplayed();
		}
		public boolean saveBtnDialogbox() {
			return driver.findElement(dialogSaveBtn).isDisplayed();
		}
		public boolean closeIconDialogbox() {
			return driver.findElement(dialogCloseBtn).isDisplayed();
		}
		
		public List<WebElement> formInputsList(){
			List<WebElement> formInputsList=driver.findElements(forminputs);
			return formInputsList;
		}
		public List<WebElement> formTextInputsList(){
			List<WebElement> formTextInputsList=driver.findElements(formTextInputs);
			return formTextInputsList;
		}   
}