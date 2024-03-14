package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = "src/test/java/features/SearchProduct2.feature", glue = "stepDefinitions", monochrome = true, plugin = {
		"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failedScenarios.txt"}, snippets = SnippetType.CAMELCASE)
public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
