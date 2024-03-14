package testing;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingSample {
	WebDriver driver;

	@Test
	public void testingSample() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://askomdch.com");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// navigating to checkout page
		WebElement storeIcon = driver.findElement(
				By.xpath("(//a[contains(text(),'Store')])[1]/parent::li"));
		storeIcon.click();
		wait.until(ExpectedConditions.visibilityOf(driver
				.findElement(By.xpath("//h1[contains(text(),'Store')]"))));
		String productXpath = "//h2[normalize-space()='Anchor Bracelet']";
		String addToCartBtn = "//a[@aria-label='Add “Anchor Bracelet” to your cart']";

		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath(productXpath)));
		driver.findElement(By.xpath(addToCartBtn)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@title='View cart']")));
		driver.findElement(By.xpath("//a[@title='View cart']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver
				.findElement(By.xpath("(//h1[normalize-space()='Cart'])[1]"))));
		driver.findElement(By.xpath("//a[contains(@class,'checkout-button')]"))
				.click();

		WebElement scrollEle = driver
				.findElement(By.xpath("//h2[normalize-space()='Quick Links']"));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", scrollEle);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(
				By.xpath("//h1[@class='has-text-align-center']"))));
		driver.quit();
	}

}
