package utils;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	private WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}

	public void switchToTopDealsWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String window : windowHandles) {
			driver.switchTo().window(window);
		}
		System.out.println(driver.getTitle());
	}
	public void waitingForElementToBeOne(By xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.numberOfElementsToBe(xpath, 1));
	}
	
	public void waitingForElementToBeVisible(By xpath) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(xpath));
	}
	
}
