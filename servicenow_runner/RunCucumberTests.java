package servicenow_runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		dryRun=false, 
		features= {"src/test/java/servicenow_features"}, 
		glue= {"servicenow_stepdefs","servicenow_hooks"},
		monochrome=true
		)

public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
