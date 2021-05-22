package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		dryRun=false, 
		features= {"src/test/java/features/Leads.feature"}, 
		glue= {"stepsforleads"},
		monochrome=true
		)

public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
