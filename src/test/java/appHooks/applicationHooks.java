package appHooks;

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
}
