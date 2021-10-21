package framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebActions {

	protected WebDriver driver;
	protected TestContext context;
	public Validations validations = new Validations();

	public WebActions(TestContext context) {
		this.context = context;
		driver = context.getWebDriver();
	}

	public void click(By element) {
		try {
			driver.findElement(element).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendKeys(WebElement element, String keys) {
		try {
			element.clear();
			element.sendKeys(keys);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public class Validations {
		public void isDisplayed(WebElement element) {
			context.softAssertions.assertThat(element.isDisplayed()).isTrue().as("Element displayed");
		}
	}

}
