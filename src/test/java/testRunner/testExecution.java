

	package testRunner; 
	import org.junit.runner.RunWith;
	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;
	import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
	@CucumberOptions(

			features = {"src/test/resources/featureFiles/5programNewAdd.feature"},

			glue = {"stepDefinition","appHooks"},

			monochrome = true,

			plugin = {"pretty",

					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
	public class testExecution {	


				}
	
		//the above runner wrks in Junit 


		
	