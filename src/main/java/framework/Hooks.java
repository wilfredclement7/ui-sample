package framework;

import config.ConfigManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private TestContext context;

	public Hooks(TestContext context) {
		this.context = context;
	}

	@Before(order = 0)
	public void loadConfig() {
		if (!ConfigManager.initialized) {
			ConfigManager.load();
		}
	}

	@Before
	public void setup(Scenario scenario) {
		DriverManager driverManager = new DriverManager(context);
		context.setRunTimeData("SCENARIO_NAME", scenario.getName());
		context.setWebDriver(driverManager.getWebDriver());
	}

	@After
	public void exit(Scenario scenario) {
		try {
			context.getWebDriver().quit();
			context.softAssertions.assertAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
