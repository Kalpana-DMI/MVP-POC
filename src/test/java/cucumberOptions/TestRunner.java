package cucumberOptions;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import demo.Base;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinations",tags="@test"
		)
public class TestRunner extends AbstractTestNGCucumberTests {

	Base base=new Base();
	@BeforeSuite
	public void initilization() throws FileNotFoundException, IOException {
		try {
			base.initializeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
