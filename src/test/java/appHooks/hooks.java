package appHooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import comUtils.configReader;
import comUtils.driverManager;
/*
public class hooks {
	
	@BeforeAll
	
	public static void setUp(Scenario scenario) {
		String browser = configReader.getBrowser();
		if (browser == null) {
			browser = "chrome"; 
		}
		DriverManager.initializeDriver(browser);
	}

	@AfterMethod
	public void tearDown(Scenario scenario) {
		takeScreenshot(scenario);
		DriverManager.quitDriver();
	}

	// Take a screenshot if the scenario fails
	public static void takeScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
				String screenshotFileName = scenario.getName().replaceAll(" ", "_") + "_" + timestamp + ".png";
				File screenshotFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
				Files.copy(screenshotFile.toPath(), Paths.get("target/screenshots", screenshotFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}}}
	}*/