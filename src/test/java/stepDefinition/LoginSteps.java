package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import comPages.LoginPage;
import comUtils.configReader;
import comUtils.driverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
/*


public class LoginSteps {
	
	
	WebDriver driver;
	configReader configReader = new configReader();
	WebDriverWait wait;
	LoginPage loginPage;

	public LoginSteps() {
		driver = driverManager.getDriver();
		//signInPage = new SignInPage(driver);
		loginPage = new LoginPage(driver);
	}

	@Given("Admin is in login Page")
	public void Admin_is_in_login_Page() {
		driver.get(configReader.getProperty("baseUrl") + "/login");
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	Boolean isElementPresent = (Boolean) js.executeScript(
//			"return document.evaluate("//a[normalize-space()='Sign in']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue != null;");
//
//		if (isElementPresent) {
//			WebElement userNameField = wait
//					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
//			userNameField.click();
//		} else {
//			System.out.println("Element not found");
//		}

	}
	@When("Admin clicks login button after entering valid {string} and valid {string}")
	public void Admin_clicks_login_button_after_entering_valid_and_valid(String username, String password) {
	  
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
			loginPage.enterUsername(configReader.getProperty("username"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
			loginPage.enterPassword(configReader.getProperty("password"));

			WebElement signInButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login']")));
			signInButton.click();
		} catch (Exception e) {

		}	
	}	
	

	 
	
	@Then("Admin should land in LMS DashBoard Page")
	public void Admin_should_land_in_lms_dash_board_page() {
		System.out.println(driver.getTitle());
		String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='LMS - Learning Management System']"))).getText();
		Assert.assertEquals(actualMessage, "LMS - Learning Management System");

	}

}*/
