package appHooks;

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
		@After(order=0)
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
	       /* if (driver != null) {
	            driver.quit();
	            //driverManager.quitDriver();
	            System.out.println("Browser closed for scenario.");
	        }*/
	    }


		
		
		
		
		
		
		
		
		
		
		//**************??//
		/*

	    // Global WebDriver for initial login and final logout
	    private static WebDriver globalDriver;
	    // ThreadLocal WebDriver for parallel scenarios
	    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
	    private static final Logger log = LogManager.getLogger(applicationHooks .class);
		
	    private static configReader cr;
	    private static Properties prop;


		    // Set up the global WebDriver for initial login
		    @Before
		    public static void globalLoginSetup() {
		        // Initialize config reader and properties
		        cr = new configReader();
		        prop = cr.init_prop();
		        if (globalDriver == null) {
		        WebDriverManager.chromedriver().setup();
		        globalDriver = new ChromeDriver();
		        globalDriver.manage().window().maximize();
		        globalDriver.get(prop.getProperty("url")); // Replace with your login URL
		        log.info("home page launch");
		        WebElement userName=globalDriver.findElement(By.id("username"));
		        WebElement passWord=globalDriver.findElement(By.id("password"));
		    	WebElement loginButton=globalDriver.findElement(By.id("login"));
		        userName.sendKeys(prop.getProperty("username"));
		        passWord.sendKeys(prop.getProperty("password"));
		        loginButton.click();
		        log.info("logged in");
		        String title=globalDriver.getCurrentUrl();
		        //log.info("URL :"+title);
		        
		        //Assert.assertEquals(title, prop.getProperty("hometitle"));
		        System.out.println("LMS Application Logged in...");
		        }
		        else {
		        	System.out.println("driver not initialzed");
		        }
		        
		    }
		 // Getter for global WebDriver
		    public static WebDriver getGlobalDriver() {
		        if (globalDriver == null) {
		            throw new IllegalStateException("Global WebDriver is not initialized. Call globalLoginSetup() first.");
		        }
		        return globalDriver;
		    }
		 

		    /* Set up a separate WebDriver instance for each scenario
		    @Before(order = 0)
		    public void setUp() {
		        
		        WebDriverManager.chromedriver().setup();
		        WebDriver driver = new ChromeDriver();
		        driverThreadLocal.set(driver);
		        System.out.println("Browser launched for scenario.");
		    }
		    
		    @Before(order = 0)
		    public void setUp() {
		    	
		    	//String Name=globalDriver.getTitle();

		        System.out.println("Application in " );
		    }

		    // Capture screenshot if scenario fails
		    @After(order = 0)
		    public void screenShot_tearDown(Scenario scenario) {
		        WebDriver driver = driverThreadLocal.get();

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
		        if (driver != null) {
		            driver.quit();
		            driverThreadLocal.remove();
		            System.out.println("Browser closed for scenario.");
		        }
		    }

		    // Perform logout actions using globalDriver
		    @AfterAll
		    public static void globalLogout_TearDown() {
		        if (globalDriver != null) {
		            
		            try {
		            	
		            	WebElement logoutButton=globalDriver.findElement(By.xpath("//button[@id='logout']"));
		            	WebDriverWait wait = new WebDriverWait(globalDriver, Duration.ofSeconds(30));
		            	wait.until(ExpectedConditions.visibilityOf(logoutButton));
		            	logoutButton.click();
		                System.out.println("LMS Application logout completed.");
		            } catch (Exception e) {
		                System.out.println("Error during global logout: " + e.getMessage());
		            }

		            
		            globalDriver.quit();
		            globalDriver = null;
		            System.out.println("Global driver quit after all scenarios.");
		        }
		    }

		    // Getter for WebDriver to be used in step definitions
		    public static WebDriver getDriver() {
		        return driverThreadLocal.get();
		    }
		

		

	*/
	}
