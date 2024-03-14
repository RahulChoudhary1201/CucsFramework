package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct2StepDefs {

	@Given("I am on the Greenkart page")
	public void i_am_on_the_greenkart_page() {
		System.out.println("I am on the GreenKart Page.");

	}

	@When("^I search (.*)$")
	public void i_search_product_name(String name) {
		System.out.println("I am searching for product "+name);
	}

	@Then("I should see the same product")
	public void i_should_see_the_same_product() {
		System.out.println("I can see the searched Product");
	}
}
