package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public GreenKart green;
	public TopDeals topDeals;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public GreenKart getGreenKartObject() {
		green = new GreenKart(driver);
		return green;
	}
	
	public TopDeals getTopDealsObject() {
		topDeals = new TopDeals(driver);
		return topDeals;
	}
}
