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

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;


public class Base {

	public static  WebDriver driver;
	JsonReader jsonData=new JsonReader();
		
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


public static void TakeScreenshot(Scenario scenario ) {	
	if(scenario.isFailed()) {
		System.out.println("working hooks");
		
try {
 String screenshotName = scenario.getName().replaceAll(" ", "_");
 TakesScreenshot screenshot = (TakesScreenshot)driver;
 File srcpath=screenshot.getScreenshotAs(OutputType.FILE);
 File destinationPath = new File(System.getProperty("user.dir") + "/target" + screenshotName + ".png");
 Files.copy(srcpath, destinationPath); 
 
 Reporter.addScreenCaptureFromPath(destinationPath.toString());
 Reporter.addScenarioLog(screenshotName);

}
catch (IOException e) {
} 
}
}
}
