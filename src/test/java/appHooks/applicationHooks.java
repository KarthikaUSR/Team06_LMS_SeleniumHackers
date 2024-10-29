package appHooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import comUtils.driverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class applicationHooks {
	//private WebDriver driver;
	@BeforeMethod
	@Before(order=0)
    public  void driverSetUp() {
        // Use the singleton driver
        driverManager.getDriver();
        
       
    }
	// Capture screenshot if scenario fails
	
	@AfterMethod
	@After(order=1)
    public void screenShot_tearDown(Scenario scenario) {
        WebDriver driver = driverManager.getDriver();

        if (driver != null && scenario.isFailed()) {
            
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String screenshotName = scenario.getName().replaceAll(" ", "_");
                scenario.attach(screenshot, "image/png", screenshotName);
                System.out.println("Screenshot captured for failed scenario: " + screenshotName);
            } catch (Exception e) {
                System.out.println("Error while taking screenshot: " + e.getMessage());
            }
        }

        // Quit the WebDriver instance for this scenario
        /*if (driver != null) {
            driver.quit();
            
            System.out.println("Browser closed for scenario.");
        }*/
    }

	/*@After(order=0)
    public  void quitDriver() {
        // Use the singleton driver
		driverManager.quitDriver();
        
       
    }*/
	
	
	

}