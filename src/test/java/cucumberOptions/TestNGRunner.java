package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true,tags = "@OrderProdcut or @SearchProduct", plugin = {
		"pretty", "html:target/cucumber.html","json:target/cucumber.json"
		,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failedScenarios.txt"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
//The rerun plug-in is used to store all the failed scenarios details in a text formated document, which will
//be used further for re running the scenarios
