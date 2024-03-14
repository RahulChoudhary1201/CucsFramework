package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GenericUtils;

public class Checkout {

	private WebDriver driver;
	GenericUtils util;
	public Checkout(WebDriver driver) {
		this.driver = driver;
		this.util = new GenericUtils(driver);
	}

	By searchInput = By.xpath("//input[@class='search-keyword']");
	By productName = By.xpath("//h4[@class='product-name']");
	By incrementBtn = By.xpath("//a[@class='increment']");
	By cartButton = By.xpath("//button[contains(text(),'ADD TO CART')]");
	By cartIcon = By.xpath("//a[@class='cart-icon']");
	By checkoutBtn = By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");
	By resultProductName = By.xpath("//p[@class='product-name']");
	By promoCodeInput = By.xpath("//input[@placeholder='Enter promo code']");
	By applyBtn = By.xpath("//button[@class='promoBtn']");
	By promoInfo = By.xpath("//span[@class='promoInfo']");
	By placeOrderBtn = By.xpath("//button[normalize-space()='Place Order']");
	By select = By.xpath("//select");
	By orderPageCheckBox = By.xpath("//input[@type='checkbox']");
	By proceedBtn = By.xpath("//button[normalize-space()='Proceed']");
	
	
	
	public void searchProduct(String name) {
		driver.findElement(searchInput).sendKeys(name);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBe(productName, 1));
	}
	public String getDisplayedProductName() {
		return driver.findElement(productName).getText().split("-")[0].trim();
	}
	
	public void increaseProductCountAndAddToCart(int count) {
		while(count>0) {
			driver.findElement(incrementBtn).click();
			count--;
		}
		driver.findElement(cartButton).click();
		driver.findElement(cartIcon).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
	}
	
	public String getDisplayedProductNameInCart() {
		driver.findElement(checkoutBtn).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(resultProductName));
		return driver.findElement(resultProductName).getText().split("-")[0].trim();
	}
	
	public void checkPromoCode(String promoCode) {
		driver.findElement(promoCodeInput).sendKeys(promoCode);
		driver.findElement(applyBtn).click();
		util.waitingForElementToBeVisible(promoInfo);
		String promotInfo=driver.findElement(promoInfo).getText();
		System.out.println(promotInfo);
	}
	
	public void placeOrder() {
		driver.findElement(placeOrderBtn).click();
		util.waitingForElementToBeVisible(select);
		Select s = new Select(driver.findElement(select));
		s.selectByValue("Algeria");
		driver.findElement(orderPageCheckBox).click();
		driver.findElement(proceedBtn).click();
	}
	
	
}
