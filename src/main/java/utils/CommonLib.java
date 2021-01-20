package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import demo.Base;


public class CommonLib extends Base{
	
	public  String generateRandomID() {
		String transName = "DMI";
		String randomTransName = null;
		Random objGenerator = new Random();
		for (int num = 0; num < 10; num++) {
			int randomNumber = objGenerator.nextInt(1000);
			randomTransName = transName + randomNumber;
			System.out.println(randomTransName);
		}
		return randomTransName;
	}
	
	public  void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public static boolean highlightElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("return arguments[0].setAttribute('style', 'border: 2px solid red;')", element);
			return true;
		} catch (Exception e) {
			System.out.println("Element cannot be highlighted");
			return false;
		}
	}
	
	public static boolean removehighlightElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("return arguments[0].setAttribute('style', '')", element);
			return true;
		} catch (Exception e) {
			System.out.println("Element highlight cannot be removed");
			return false;
		}

	}
	
	public  void selectDropdownByValue(WebElement element, String value) {
	        Select drpdownvalue=new Select(element);
			drpdownvalue.selectByValue(value);
	}
	
	public  void selectDropdownByIndex(WebElement element, int index) {
        Select drpdownvalue=new Select(element);
		drpdownvalue.selectByIndex(index);
}
	public  void selectDropdownByVisibleText(WebElement element, String text) {
        Select drpdownvalue=new Select(element);
		drpdownvalue.selectByVisibleText(text);
}
	public  void clearAndSetText(WebElement element, String text) {
			highlightElement(element);
			element.clear();
			element.sendKeys(text);
			removehighlightElement(element);	
	}

	public void ValidateTitle(String expected) throws InterruptedException {
		Thread.sleep(5000);
		Set<String> windowHandles=driver.getWindowHandles();
		List<String> windowStrings = new ArrayList<String>(windowHandles);
		String reqWindow = windowStrings.get(1);
		driver.switchTo().window(reqWindow);
		String Actual = driver.getCurrentUrl();
		System.out.println(Actual);
		Assert.assertTrue(Actual.contains(expected));
	}
	
	public void AcceptAlert() {
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
	}
	
	public  void ClickUsingJavaScript(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			} else {
				throw new Exception("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM " + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Exception:"+e.getStackTrace());
		}
	}
	
	//Select value from list
		public void SelectValueFromList(String Listxpath,String value) {
			
			
			
		}
	
}
