import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import config.ConfigManager;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefinitions", "framework" }, plugin = {
		"pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/cukes.xml" })

public class TestRunner {

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeSuite(alwaysRun = true)
	public void init() {
		ConfigManager.load();
	}

	@BeforeClass(alwaysRun = true)
	public void setupClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	}

	@DataProvider()
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}

	@BeforeClass
	public void setupClass(ITestContext context) {
		context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(1);
		context.getCurrentXmlTest().getSuite().setPreserveOrder(false);
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		testNGCucumberRunner.finish();
	}
}
