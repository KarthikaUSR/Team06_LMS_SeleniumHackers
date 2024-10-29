package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

		
	// @RunWith(Cucumber.class)

	@CucumberOptions(

			features = {"src/test/resources/featureFiles/2Program/4programAdd.feature"},

			glue = {"stepDefinition","appHooks"},

			monochrome = true,

			//tags="@ManageProgramSortingProgram",

			//"@BatchPageNavigation",
		
            //"@classPageValidation1",

			//"@classPageValidation",

			plugin = {"pretty",

					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})



	public class TestRunner extends AbstractTestNGCucumberTests{

	}

	//the above runner wrks in TestNg 
