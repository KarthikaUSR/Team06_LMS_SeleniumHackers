package comUtils;

import org.openqa.selenium.WebDriver;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import appHooks.applicationHooks;
import io.github.bonigarcia.wdm.WebDriverManager;


public class driverManager {
	
	
	private static final Logger log = LogManager.getLogger(driverManager.class);
    private static WebDriver driver;
    private static configReader cr;
    private static Properties prop;


    // Private constructor to prevent instantiation
    private driverManager() {}

    // Method to get the driver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            login(driver); // Call login once
        }
        else {
        	System.out.println("driver already initialzed");
        }
        return driver;
    }

    // Login method to be called once during driver initialization
    private static void login(WebDriver driver) {
    	cr = new configReader();
        prop = cr.init_prop();
        driver.get(prop.getProperty("url"));
        WebElement userName=driver.findElement(By.id("username"));
        WebElement passWord=driver.findElement(By.id("password"));
        WebElement loginButton=driver.findElement(By.id("login"));
        userName.sendKeys(prop.getProperty("username"));
        passWord.sendKeys(prop.getProperty("password"));
        loginButton.click();
        log.info("logged in");
        String title=driver.getCurrentUrl();
        log.info("URL :"+title);
        
        //Assert.assertEquals(title, prop.getProperty("hometitle"));
        System.out.println("LMS Application Logged in...");
    }

    // Method to quit the driver (call at the end of the test run)
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }



}
	
	
		

	/*
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initializeDriver(String browser) {
		if (driver.get() == null) {
			try {
				if (browser.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver.set(new ChromeDriver());
				} else if (browser.equalsIgnoreCase("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver.set(new FirefoxDriver());
				} else {
					throw new IllegalArgumentException("Browser not supported: " + browser);
				}
				driver.get().manage().window().maximize();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to initialize WebDriver", e);
			}
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		WebDriver driverInstance = driver.get();
		if (driverInstance != null) {
			driverInstance.quit();
			driver.remove();
		}
	}*/

