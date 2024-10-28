package appHooks;

<<<<<<< HEAD
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import comUtils.driverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class applicationHooks {
	//private WebDriver driver;
	@Before(order=0)
    public  void driverSetUp() {
        // Use the singleton driver
        driverManager.getDriver();
        
       
    }
	// Capture screenshot if scenario fails
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
	
	
	
	
	
	
	
	
	
	
	
=======
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import comUtils.DriverFactory;
import comUtils.configReader;
import io.cucumber.java.Before;

public class applicationHooks {
	/*private DriverFactory driverFactory;
	public WebDriver driver;
	private configReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new configReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
	}*/
>>>>>>> origin/Archana
}
