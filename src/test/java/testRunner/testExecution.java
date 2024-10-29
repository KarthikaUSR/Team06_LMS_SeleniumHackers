package testRunner;
//import org.junit.runner.RunWith;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class testExecution {
		
	//@RunWith(Cucumber.class)
	@CucumberOptions(
			features = {"src/test/resources/featureFiles/5programNewAdd.feature"},
			glue = {"stepDefinition","appHooks"},
			monochrome = true,

			//tags="@ManageProgramSortingProgram",
			//"@BatchPageNavigation",
			
//			"@classPageValidation1",
			//"@classPageValidation",
			plugin = {"pretty",
					"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
			}
			
			)

	public class TestRunner extends AbstractTestNGCucumberTests{

	}

//	public class TestRunner extends AbstractTestNGCucumberTests{
//		
//		
//		@Override
//	    @DataProvider(parallel = false)//true means execute parallely false mean not execute parallely
//		
//	    public Object[][] scenarios() {
//					
//			return super.scenarios();
//	    }	
//	}
//
}