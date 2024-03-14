package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	private WebDriver driver;
	String url = PropReader.getPropertyByKey("QAUrl");
	public WebDriver webDriverManager() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		return driver;
	}
}
