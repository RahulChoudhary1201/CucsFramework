package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.TopDeals;
import utils.TestContextSetup;

public class TopDealsStepDefs {
	TestContextSetup testContextSetup;

	public TopDealsStepDefs(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^user searched for (.+) in offers page to check if product exist$")
	public void user_searched_for_same_shot_name_in_offers_page_to_check_if_product_exist(
			String partialProductName) {
		TopDeals topDeals = testContextSetup.pageObjectManager.getTopDealsPageObject();
		topDeals.openTopDealsPage();
		testContextSetup.generic.switchToTopDealsWindow();
		topDeals.searchProduct(partialProductName);
		testContextSetup.landingPageProductName = topDeals.getProductName();
		System.out.println(testContextSetup.landingPageProductName);
		testContextSetup.testBase.webDriverManager().switchTo().parentFrame();
	}

	@Then("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.homePageProductName,testContextSetup.landingPageProductName);
	}
}
