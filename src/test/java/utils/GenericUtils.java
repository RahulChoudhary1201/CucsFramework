package utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

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
}
