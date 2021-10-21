package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.TestContext;

public class HomePage {
	
	TestContext context;
	
	public HomePage(TestContext context) {
		this.context = context;
	}

	
	protected By wishList = By.xpath("//*[@data-title='Add to wishlist']");

	protected By wishListTable = By.xpath("(//*[@title='Wishlist'])[1]");
	
	protected By wishSize = By.xpath("//*[@class='wishlist-items-wrapper']/tr");
	
	protected By wishSizeData = By.xpath("//*[@class='wishlist-items-wrapper']/tr/td[4]");
	
	protected By cartTable = By.xpath("(//*[@title='Cart'])[1]");


	public WebElement wishList() {
		return context.getWebDriver().findElement(wishList);
	}

	public WebElement wishListTable() {
		return context.getWebDriver().findElement(wishListTable);
	}
	
	public WebElement wishSize() {
		return context.getWebDriver().findElement(wishSize);
	}
	
	public WebElement wishSizeData() {
		return context.getWebDriver().findElement(wishSizeData);
	}
	
	public WebElement cartTable() {
		return context.getWebDriver().findElement(cartTable);
	}

}
