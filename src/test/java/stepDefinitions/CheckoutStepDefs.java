package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Checkout;
import utils.TestContextSetup;

public class CheckoutStepDefs {
	public TestContextSetup testContextSetup;
	Checkout checkout;
	public CheckoutStepDefs(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkout = testContextSetup.pageObjectManager.getCheckoutPageObject();
	}
	String displayedProductName;
	@Given("I am on the greenkart home page.")
	public void i_am_on_the_greenkart_home_page() {
		System.out.println("I am on the HomePage ");
	}

	@And("^I am searching for (.+)$")
	public void i_am_searching_for_product(String productName) {
		checkout.searchProduct(productName);
	}

	@When("Product is displayed on the home page.")
	public void product_is_displayed_on_the_home_page() {
		displayedProductName = checkout.getDisplayedProductName();
	}

	@Then("^Increase the count of the product to (.+) and add to cart$")
	public void increase_the_count_of_the_product_and_add_to_cart(int count) {
		checkout.increaseProductCountAndAddToCart(count);
	}
	String cartProduct;
	@Then("I will click on the cart icon")
	public void i_will_click_on_the_cart_icon() {
		cartProduct = checkout.getDisplayedProductNameInCart();
	}

	@Then("I verify weather the searched product is displayed in the kart or not.")
	public void i_verify_weather_the_searched_product_is_displayed_in_the_kart_or_not() {
		Assert.assertEquals(displayedProductName, cartProduct);
	}

	@Then("I will apply the promo code {string} and validate its working or not")
	public void i_will_apply_the_promo_code_and_validate_its_working_or_not(String promoCode) {
		System.out.println(promoCode);
		checkout.checkPromoCode(promoCode);
		}

	@Then("I will place the order")
	public void i_will_place_the_order() {
		checkout.placeOrder();
	}

}
