package demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base {

	public static  WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	JsonReader jsonData=new JsonReader();
	
	//@BeforeMethod
public WebDriver initializeDriver() throws IOException, ParseException
{
	String url="URL";	
	String path =System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(jsonData.ReadData(url));
	driver.manage().window().maximize();
	System.out.println(driver.getTitle());
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
}

	@Test
	public void titleTest() {
		test =extent.startTest("titleTest");
		Assert.assertEquals(driver.getTitle(), "abc");
	}
@AfterMethod
public void teardown(ITestResult result) throws IOException {
	if(result.getStatus()==ITestResult.FAILURE) {
		test.log(LogStatus.FAIL, "Test case failed is"+result.getName());
		test.log(LogStatus.FAIL, "Test case failed is"+result.getThrowable());
		
		String screenShotPath = Base.getScreenshot(driver, result.getName());
		test.log(LogStatus.FAIL, test.addScreenCapture(screenShotPath));
	}
	else if(result.getStatus()==ITestResult.SKIP) {
		test.log(LogStatus.SKIP, "Test case skipped is"+result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS) {
		test.log(LogStatus.PASS, "Test case passed is"+result.getName());
	}
	driver.quit();
}
	
@BeforeTest
public void setExtent() {
	extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
	extent.addSystemInfo("Host Name","Localhost");
	extent.addSystemInfo("User Name","akdang");
	extent.addSystemInfo("Environment","IT");
}

@AfterTest
public void endReport() {
	extent.flush();
	extent.close();
}

public  static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
	String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	String destination=System.getProperty("user.dir")+"/FailedTestsScreenshots/"+screenshotName+dateName+".png";
	FileUtils.copyFile(source, new File(destination));
	return destination;
}
}
