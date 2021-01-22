package demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStack_Server extends Base{
	 
	public void ExecuteUsingBrowserStack() throws IOException, ParseException {
		 final String AUTOMATE_USERNAME = "kalpanakaushik2";
		 final String AUTOMATE_ACCESS_KEY = "auMzbq5Tr2hwqXimyDix";
		 final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
		 String url="URL";	
	     DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "latest");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("name", "MVP-POC Test"); // test name
	    caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
	    caps.setCapability("browserstack.selenium_version", "4.0.0-alpha-2");
	    driver = new RemoteWebDriver(new URL(URL), caps);  	
	    driver.get(jsonData.ReadData(url));
	}	  	  	
} 
