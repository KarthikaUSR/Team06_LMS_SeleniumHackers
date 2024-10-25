package testRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import comUtils.ConfigReader;
import comUtils.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = { "src/test/resources/featureFiles" }, glue = { "stepDefinition",
"appHooks.hooks" },tags="@sanity", plugin = { "pretty", "html:target/cucumber-reports.html",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" ,"rerun:target/failedrerun.txt"})

public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void setup(@Optional("chrome")String browser) {
	System.out.println("Setting up driver for browser: " + browser);
	ConfigReader.setBrowser(browser); // Set the browser in ConfigReader
	DriverManager.initializeDriver(ConfigReader.getBrowser()); // Initialize driver with browser from ConfigReader

	}

@Override
@DataProvider(parallel = false)
public Object[][] scenarios() {
return super.scenarios();
}

}