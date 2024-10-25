package comPages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class programPage {

	WebDriver driver;
	WebDriverWait wait;
	public Alert alert;

	By programMenu = By.xpath("//button[@id='program']");
	By addNewProgram = By.xpath("//button[@role='menuitem']");
	By manageProgramview = By.xpath("//div[normalize-space()='Manage Program']");
	By programHeading = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	

	public programPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public void programMenuclick() {
		WebElement element = driver.findElement(programMenu);
	//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}

	public String getProgramHeading() {
		WebElement element = driver.findElement(programHeading);
        return element.getText();
    }

/*
	public boolean checkForBrokenLinks() {
		
		// Get all <a> tags with href attribute
		List<WebElement> links = driver.findElements(By.tagName("a"));

		// Iterate through each link to check if the URL is valid
		for (WebElement link : links) {
			String url = link.getAttribute("href");

			// Skip if href is empty, null, or contains non-http schemes like mailto, tel,
			// etc.
			if (url == null || url.isEmpty() || !url.startsWith("http")) {
				System.out.println("Skipped link (invalid or not an HTTP URL): " + url);
				continue;
			}

			try {
				// Create a URL object and establish a connection
				HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();

				// Set request method to HEAD to check only the headers
				httpConn.setRequestMethod("HEAD");
				httpConn.connect();

				// Check response code
				int responseCode = httpConn.getResponseCode();
				if (responseCode >= 400) {
					System.out.println("Broken link detected: " + url + " - Response Code: " + responseCode);
					return false; // Return false if a broken link is found
				} else {
					System.out.println("Valid link: " + url + " - Response Code: " + responseCode);
				}
			} catch (Exception e) {
				// Log the error but continue checking other links
				System.out.println("Error checking link: " + url + " - Exception: " + e.getMessage());
				return false;
			}
		}

		// If all links are valid, return true
		return true;
*/
	

}
