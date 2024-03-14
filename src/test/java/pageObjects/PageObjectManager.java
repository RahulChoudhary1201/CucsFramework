package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public GreenKart green;
	public TopDeals topDeals;
	public Checkout checkout;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public GreenKart getGreenkartPageObject() {
		green = new GreenKart(driver);
		return green;
	}
	
	public TopDeals getTopDealsPageObject() {
		topDeals = new TopDeals(driver);
		return topDeals;
	}
	public Checkout getCheckoutPageObject() {
		checkout = new Checkout(driver);
		return checkout;
	}
}
