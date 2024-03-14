package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup setup;
	public Hooks(TestContextSetup setup) {
		this.setup = setup;
	}

	@After
	public void tearDown() {
		setup.testBase.webDriverManager().quit();
	}
	
	@AfterStep
	public void attachScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = setup.testBase.webDriverManager();
		if(scenario.isFailed()) {
			File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] screenshot= FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(screenshot, "image/png", "Failed Scenario Screenshot Capturted");
			
		}
		
		
		
			
	}
}
