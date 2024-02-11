package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart {
	private WebDriver driver;
	public GreenKart(WebDriver driver) {
		this.driver = driver;
	}

	By searchInput = By.xpath("//input[@class='search-keyword']");
	By productName = By.xpath("//h4[@class='product-name']");

	public void searchProduct(String name) {
		driver.findElement(searchInput).sendKeys(name);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBe(productName, 1));
	}
	
	public String getDisplayedProductName() {
		return driver.findElement(productName).getText();
	}
}
