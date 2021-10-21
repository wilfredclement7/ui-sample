package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import config.ConfigManager;
import framework.TestContext;
import framework.WebActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage;

public class HomeSteps extends HomePage {

	WebDriver driver;
	TestContext context;
	WebActions actions;
	WebActions.Validations validations;

	public HomeSteps(TestContext context) {
		super(context);
		this.context = context;
		driver = context.getWebDriver();
		actions = new WebActions(context);
		validations = actions.validations;
	}

	@Given("^I add four different products to my wish list$")
	public void i_add_four_different_products_to_my_wish_list() {

		List<WebElement> options = context.getWebDriver().findElements(wishList);
		for (int i = 1; i < 3; i++) {
			actions.click(options.get(i));
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

		actions.click(options.get(5));
		actions.click(options.get(6));

	}

	@When("^I view my wishlist table$")
	public void i_view_my_wishlist_table() {
		actions.click(wishListTable);
	}

	@When("^I search for lowest price product$")
	public void i_search_for_lowest_price_product() throws Throwable {

		List<WebElement> object = context.getWebDriver().findElements(wishSizeData);

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i <= 3; i++) {

			String abc = object.get(i).getText().replace("£", "");
			String[] words = abc.split(" ", 3);
			if (words.length == 1) {
				list.add(Integer.parseInt(words[0].strip().substring(0, 2)));
			} else
				list.add(Integer.parseInt(words[1].strip().substring(0, 2)));
		}

		int minimum = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (minimum > list.get(i))
				minimum = list.get(i);
		}

		context.setRunTimeData("product", String.valueOf(list.indexOf(minimum)+1));

	}

	@Then("^I find total four selected items in my Wishlist$")
	public void i_find_total_four_selected_items_in_my_wishlist() throws Throwable {
		int count = context.getWebDriver().findElements(wishSize).size();
		Assert.assertEquals(4, count);
	}

	@Then("^I am able to verify the item in my cart$")
	public void i_am_able_to_verify_the_item_in_my_cart() throws Throwable {
		Thread.sleep(5000);
		actions.click(cartTable);

	}

	@And("^I am able to add the lowest price item to my cart$")
	public void i_am_able_to_add_the_lowest_price_item_to_my_cart() throws Throwable {

		context.getWebDriver()
				.findElement(By.xpath(
						"//*[@class='wishlist-items-wrapper']/tr[" + context.getRunTimeData("product") + "]/td[6]"))
				.click();

	}

}
