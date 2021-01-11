package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	 protected static WebDriver driver;
	
	
	public  void LaunchURL(String url) {
		String path =System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get(url);
		 driver.manage().window().maximize();
		 System.out.println(driver.getTitle());
		
	}

}
