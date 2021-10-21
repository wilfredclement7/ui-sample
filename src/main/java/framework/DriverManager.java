package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.ConfigManager;

public class DriverManager {

	private TestContext context;

	public DriverManager(TestContext context) {
		this.context = context;
	}

	public WebDriver getWebDriver() {
		final WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(ConfigManager.getConfig("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
}
