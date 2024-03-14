package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//This class is for re running the failed testcases/scenarios
// we need to provide the argument of feature to a text file where the the details of failed scenarios are saved or stored.

//We will add this plugin to main runner class "rerun:target/failedSenarios.txt" -> it will store all the failed scenarios as text document
//then this text document location need to passed to the FailedTestRunner class in features argument
//As shown below:


@CucumberOptions(features = "@target/failedScenarios.txt", glue = "stepDefinitions", monochrome = true, plugin = {
		"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FailedTestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
