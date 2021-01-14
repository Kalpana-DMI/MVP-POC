package stepDefinations;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.Base;
import demo.JsonReader;
import utils.CommonLib;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login extends Base {

	private static Logger log =LogManager.getLogger(Login.class.getName());
	JsonReader jsonData=new JsonReader();
	CommonLib commonLib=new CommonLib();
	
	@Given("^User is on application homepage$")
	public void user_is_on_application_homepage() throws Throwable {
	   WebElement image=driver.findElement(By.xpath("//img[@alt=\"MVP Health Care(R)\"]"));
	   Assert.assertTrue(image.isDisplayed(), "image is not dispalyed");
	}

	@When("^User Clicks on Shop for a Plan Link$")
	public void user_Clicks_on_Shop_for_a_Plan_Link() throws Throwable {
	    WebElement shoplink=driver.findElement(By.xpath("//li[@class='shoplink']//a[text()='Shop for a Plan']"));
	    shoplink.click();
	}

	@When("^Select the Medicare link$")
	public void select_the_Medicare_link() throws Throwable {
		WebElement medicarelink=driver.findElement(By.xpath("(//a[text()='Medicare'])[3]"));
		commonLib.scrollToElement(medicarelink);
		medicarelink.click();
	}

	@Then("^Choose Shop for a Medicare Plan link$")
	public void choose_Shop_for_a_Medicare_Plan_link() throws Throwable {
		WebElement getstartedlink=driver.findElement(By.xpath("//a//p[text()='Get Started']"));
		commonLib.scrollToElement(getstartedlink);
		getstartedlink.click();
	}

	@Then("^Select Country from the dropdown menu$")
	public void select_Country_from_the_dropdown_menu() throws Throwable {
	  WebElement countryDrpdown=driver.findElement(By.id("countySelect"));
	  commonLib.selectDropdownByValue(countryDrpdown, "NY|East|Columbia|capital-district");
	}

	@Then("^Click on \"([^\"]*)\" button$")
	public void click_on_button(String SeePlansBtn) throws Throwable {
		WebElement viewPlansBtn=driver.findElement(By.xpath("//input[@value='"+SeePlansBtn+"']"));
		viewPlansBtn.click();
	}

	@Then("^User click on \"([^\"]*)\" link$")
	public void user_click_on_link(String PrescriptionPlanLink) throws Throwable {
		WebElement prescriptionlink=driver.findElement(By.xpath("//p[text()='"+PrescriptionPlanLink+"']"));
		commonLib.scrollToElement(prescriptionlink);
		prescriptionlink.click();
	}

	@Then("^Validate that user is redirected to a new site/window \"([^\"]*)\"$")
	public void validate_that_user_is_redirected_to_a_new_site_window(String expectedURL) throws Throwable {
		commonLib.AcceptAlert();
		commonLib.ValidateTitle(expectedURL);
	}

	@Then("^User enters the \"([^\"]*)\" as ZipCode$")
	public void user_enters_the_as_ZipCode(String zipcode) throws Throwable {
	    WebElement zipCodefield=driver.findElement(By.xpath("//button[text()=\" View plans \"]//../../..//input"));
	    zipCodefield.sendKeys(zipcode);
	}

	@Then("^Click on View Plans$")
	public void click_on_View_Plans() throws Throwable {
		WebElement viewPlanslink=driver.findElement(By.xpath("//button[text()=' View plans ']"));
		//viewPlanslink.click();
		Thread.sleep(3000);
		commonLib.ClickUsingJavaScript(viewPlanslink);
		
	}

	@Then("^Validate all below sections appeared with available no\\. of plans$")
	public void validate_all_below_sections_appeared_with_available_no_of_plans(DataTable availableplans) throws Throwable {
		List<List<String>> list = availableplans.raw();
		for(int i=0,j=0;j<3;j++) {
		WebElement Plan1=driver.findElement(By.xpath("//span[text()=' "+list.get(i).get(j)+"']"));
		System.out.println(list.get(i).get(j));
		Assert.assertEquals(Plan1.getText(),list.get(i).get(j));
		}
	}


	@Then("^Logout from the application$")
	public void logout_from_the_application() throws Throwable {
	   
	}

}