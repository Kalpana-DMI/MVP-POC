package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectRepository extends Base {

By image = By.xpath("//img[@alt=\"MVP Health Care(R)\"]");
By shopLink = By.xpath("//li[@class='shoplink']//a[text()='Shop for a Plan']");
By medicareLink = By.xpath("(//a[text()='Medicare'])[3]");
By getstartedlink= By.xpath("//a//p[text()='Get Started']");
By countryDrpdown= By.id("countySelect");
By zipCodefield= By.xpath("//button[text()=\" View plans \"]//../../..//input");
By viewPlanslink= By.xpath("//button[text()=' View plans ']");
By healthCare = By.xpath("//div[@class='buttonwrap']/button");
By physician = By.xpath("//input[@name='pcp-visits']");
By specialist = By.xpath("//input[@name='spec-visits']");
By occurence = By.xpath("//input[@name='occurence_new0']");
By services = By.id("med-services_new0");


public WebElement seePlansBtn(String SeePlansBtn) {
	
	return driver.findElement(By.xpath("//input[@value='"+SeePlansBtn+"']"));
}

public WebElement prescriptionLink(String PrescriptionPlanLink) {
	
	return driver.findElement(By.xpath("//p[text()='"+PrescriptionPlanLink+"']"));	
}

public WebElement homePage() {
	return driver.findElement(image);
}

public WebElement shopPlan() {
	return driver.findElement(shopLink);
}

public WebElement selectMedicare() {
	return driver.findElement(medicareLink);
}

public WebElement chooseShop() {
	return driver.findElement(getstartedlink);
}

public WebElement selectCountry() {
	return driver.findElement(countryDrpdown);
}

public WebElement zipCode() {
	return driver.findElement(zipCodefield);
}

public WebElement viewPlans() {
	return driver.findElement(viewPlanslink);
}

public WebElement healthCareCostsButton() {
	return driver.findElement(healthCare);
}

public WebElement physicianVisits() {
	return driver.findElement(physician);
}

public WebElement specialistVisits() {
	return driver.findElement(specialist);
}

public WebElement occurenceVisits() {
	return driver.findElement(occurence);
}

public WebElement medicalServices() {
	return driver.findElement(services);
}

}
