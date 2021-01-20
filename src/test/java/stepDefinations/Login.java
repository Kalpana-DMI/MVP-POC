package stepDefinations;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.Base;
import demo.BrowserStack_Server;
import demo.JsonReader;
import demo.ObjectRepository;
import utils.CommonLib;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login extends Base {

	private static Logger log =LogManager.getLogger(Login.class.getName());
	JsonReader jsonData=new JsonReader();
	CommonLib commonLib=new CommonLib();
	ObjectRepository repoObject = new ObjectRepository();
	BrowserStack_Server browserStack=new BrowserStack_Server();
	
/**This code is for executing the code using BrowserStack/ locally.Comment out first method
 * to execute locally.And,do vice versa to execute the code through BrowserStack.
 * @throws Throwable
 */
	@Before
	public void BeforeScenario() throws IOException, ParseException {
		
		browserStack.ExecuteUsingBrowserStack();
		//driver=initializeDriver();
	} 
	
	@Given("^User is on application homepage$")
	public void user_is_on_application_homepage() throws Throwable {
	   Assert.assertTrue(repoObject.homePage().isDisplayed(), "image is not dispalyed");
	}

	@When("^User Clicks on Shop for a Plan Link$")
	public void user_Clicks_on_Shop_for_a_Plan_Link() throws Throwable {
		repoObject.shopPlan().click();
	}

	@When("^Select the Medicare link$")
	public void select_the_Medicare_link() throws Throwable {
		Thread.sleep(3000);
		commonLib.scrollToElement(repoObject.selectMedicare());
		repoObject.selectMedicare().click();
	}

	@Then("^Choose Shop for a Medicare Plan link$")
	public void choose_Shop_for_a_Medicare_Plan_link() throws Throwable {
		commonLib.scrollToElement(repoObject.chooseShop());
		repoObject.chooseShop().click();
	}

	@Then("^Select Country from the dropdown menu$")
	public void select_Country_from_the_dropdown_menu() throws Throwable {
		commonLib.selectDropdownByValue(repoObject.selectCountry(), "NY|East|Columbia|capital-district");
	}

	@Then("^Click on \"([^\"]*)\" button$")
	public void click_on_button(String SeePlansBtn) throws Throwable {
		repoObject.seePlansBtn(SeePlansBtn).click();
		
	}

	@Then("^User click on \"([^\"]*)\" link$")
	public void user_click_on_link(String PrescriptionPlanLink) throws Throwable {
		commonLib.scrollToElement(repoObject.prescriptionLink(PrescriptionPlanLink));
		repoObject.prescriptionLink(PrescriptionPlanLink).click();
	}

	@Then("^Validate that user is redirected to a new site/window \"([^\"]*)\"$")
	public void validate_that_user_is_redirected_to_a_new_site_window(String expectedURL) throws Throwable {
		commonLib.AcceptAlert();
		commonLib.ValidateTitle(expectedURL);
	}

	@Then("^User enters the \"([^\"]*)\" as ZipCode$")
	public void user_enters_the_as_ZipCode(String zipcode) throws Throwable {
		repoObject.zipCode().sendKeys(zipcode);
	}

	@Then("^Click on View Plans$")
	public void click_on_View_Plans() throws Throwable {
		Thread.sleep(3000);
		commonLib.ClickUsingJavaScript(repoObject.viewPlans());
		
	}

	@Then("^Validate all below sections appeared with available no\\. of plans$")
	public void validate_all_below_sections_appeared_with_available_no_of_plans(DataTable availableplans) throws Throwable {
		List<List<String>> list = availableplans.raw();
		for(int i=0,j=0;j<3;j++) {
		/**Not creating repository element for the below element because of dynamic variables i & j**/
		WebElement Plan1=driver.findElement(By.xpath("//span[text()=' "+list.get(i).get(j)+"']"));
		Assert.assertEquals(Plan1.getText(),list.get(i).get(j));
		}
	}

	@Then("^User enters (.+) , (.+) , (.+) and (.+)$")
	public void user_enters_and(String visitstophysician, String visittospecialist, String otherservices, String occurences) throws Throwable {
		repoObject.physicianVisits().sendKeys(visitstophysician);
		repoObject.specialistVisits().sendKeys(visittospecialist);
		repoObject.occurenceVisits().sendKeys(occurences);
	    commonLib.selectDropdownByVisibleText(repoObject.medicalServices(), otherservices);
	}

	@And("^Click on Estimate my HealthCare Costs button$")
	public void click_on_estimate_my_healthcare_costs_button() throws Throwable {
		repoObject.healthCareCostsButton().click();
	}

	@Then("^Validate plan details appeared on the page$")
	public void validate_plan_details_appeared_on_the_page() throws Throwable {
	String expectedPlanName=null;
	List<WebElement> element = driver.findElements(By.xpath("//*[contains(@class,'plan-name')]/b"));
	for(WebElement s:element) {
	expectedPlanName=s.getText();
	}
	if(expectedPlanName.equals("MVP® Medicare WellSelect®")) {
	System.out.println("Validated plan1 details appeared on page");
	}else if(expectedPlanName.equals("MVP Medicare Secure")) {
	System.out.println("Validated plan2 details appeared on page");
	}else if(expectedPlanName.equals("MVP Medicare Secure Plus")) {
	System.out.println("Validated plan3 details appeared on page");
	}else if(expectedPlanName.equals("MVP® Medicare WellSelect® Plus")) {
	System.out.println("Validated plan4 details appeared on page");
	}else if(expectedPlanName.equals("MVP Medicare Preferred Gold")) {
	System.out.println("Validated plan5 details appeared on page");
	}
	else {
	System.out.println("Plan details not appeared on page");
	}
	}
	@After
    public void execute_after_every_scenario(Scenario scenario) throws InterruptedException, IOException
    {
      Base.TakeScreenshot(scenario);
      driver.quit();
    }
}
	
	

