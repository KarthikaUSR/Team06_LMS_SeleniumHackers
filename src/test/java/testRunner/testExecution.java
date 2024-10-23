package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
public class testExecution {
	
	
	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = {"src/test/resources/featureFiles"},
			glue = {"stepDefinitions","appHooks"},
			plugin = {"pretty"
			}
			
			)

	public class mytestrunner 
	{

	}

}
