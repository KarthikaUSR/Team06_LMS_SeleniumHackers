package testRunner; 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

	
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = {"src/test/resources/featureFiles"},
			glue = {"appHooks","stepDefinition"},
			plugin = {"pretty"
			}
			
			)

	public class testExecution
	{

	}


