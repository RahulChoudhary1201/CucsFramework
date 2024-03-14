package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.PropReader;

public class BrowserFactory {

	@Before
	public void setWebDriver() {
		WebDriver localDriver;
		String browser = PropReader.getPropertyByKey("browser");
		switch (browser) {
			case "chrome" :
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("['start-maximized']");
				localDriver = new ChromeDriver();
				break;
			case "firefox" :
				WebDriverManager.firefoxdriver().setup();
				localDriver = new FirefoxDriver();
				break;
			default :
				throw new IllegalArgumentException(
						"Browser " + browser + " isn't supported");
		}
		DriverFactory.set(localDriver);
	}

	@After
	public void tearDown() {
		WebDriver driver = DriverFactory.get();
		try {
			driver.quit();
		} finally {
			DriverFactory.remove();
		}
	}

}
