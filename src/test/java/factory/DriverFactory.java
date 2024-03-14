package factory;

import java.util.Optional;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	private static final InheritableThreadLocal<WebDriver> webDriver = new InheritableThreadLocal<WebDriver>();

	static void set(WebDriver driver) {
		webDriver.set(driver);
	}

	public static WebDriver get() {
		return Optional.ofNullable(webDriver.get()).orElseThrow(
				() -> new IllegalStateException("Driver is NOT initialised"));
	}

	static void remove() {
		webDriver.remove();
		webDriver.set(null);
	}
}
