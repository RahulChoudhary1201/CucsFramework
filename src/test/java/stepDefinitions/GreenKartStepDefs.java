package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.GreenKart;
import utils.TestContextSetup;

public class GreenKartStepDefs {

	public WebDriver driver;
	public TestContextSetup testContextSetup;

	public GreenKartStepDefs(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User is on Greenkart Landing page")
	public void user_is_on_greenkart_landing_page() {
		System.out.println("User is on the landing page.");
	}
	
	
	
	@When("^user searched with short name (.+) and extract actual name of product$")
	public void user_searched_with_short_name_and_extract_actual_name_of_product(String value) {
		GreenKart green = testContextSetup.pageObjectManager.getGreenkartPageObject();
		green.searchProduct(value);
		testContextSetup.homePageProductName = green.getDisplayedProductName().split("-")[0].trim();
		System.out.println(testContextSetup.homePageProductName);
	}

}
