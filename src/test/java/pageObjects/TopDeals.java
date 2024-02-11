package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopDeals {
	private WebDriver driver;
	public TopDeals(WebDriver driver) {
		this.driver = driver;
	}

	By topDeals = By.xpath("//a[normalize-space()='Top Deals']");
	By searchField = By.id("search-field");
	By displayedProductName = By.xpath("//tbody/tr/td[1]");

	public void openTopDealsPage() {
		driver.findElement(topDeals).click();
	}

	public void searchProduct(String productName) {
		driver.findElement(searchField).sendKeys(productName);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(displayedProductName));
	}
	public String getProductName() {
		return driver.findElement(displayedProductName).getText();
	}
}
