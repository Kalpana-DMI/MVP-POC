package cucumberOptions;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import demo.Base;
import demo.ConfigFileReader;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinations",tags="@test",
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome=true
		)
public class TestRunner extends  AbstractTestNGCucumberTests {
  
	@AfterClass()
	public static void writeExtentReport() throws IOException {
		
		Reporter.loadXMLConfig(new File(ConfigFileReader.getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	     Reporter.setSystemInfo("Selenium", "3.7.0");
	     Reporter.setSystemInfo("Maven", "3.6.3");
	     Reporter.setSystemInfo("Java Version", "1.8.0_271");
	     
	}
	
}
