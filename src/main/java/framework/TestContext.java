package framework;

import java.util.HashMap;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class TestContext {

	private WebDriver driver;
	public SoftAssertions softAssertions = new SoftAssertions();
	
	public HashMap<String,String> temp = new HashMap<>();
	
	public String getRunTimeData(String key) {
		return temp.get(key);
	}
	
	public void setRunTimeData(String key,String value) {
		temp.put(key, value);
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
	
	public void setWebDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
}
