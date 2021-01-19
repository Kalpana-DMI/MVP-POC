package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestContext extends Base {
	private WebDriver driver;
	

	 
	 public TestContext(){
	 driver = new ChromeDriver();
	
	 }
	 
	 public WebDriver getWebDriverManager() {
	 return driver;
	 }
	
}
