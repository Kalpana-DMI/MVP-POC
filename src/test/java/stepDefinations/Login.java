package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.Base;
import demo.JsonReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Login  {

	private static Logger log =LogManager.getLogger(Login.class.getName());
	JsonReader jsonData=new JsonReader();
	Base base=new Base();
	
	@Given("^User enters the \"([^\"]*)\" to launch the application$")
	public void user_enters_the_to_launch_the_application(String url) throws Throwable {
	    base.LaunchURL(jsonData.ReadData(url));
	}
	
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
	    System.out.println(jsonData.ReadData(username));
	    System.out.println(jsonData.ReadData(password));
	}

	 @When("^User login into application with username and password$")
	    public void user_login_into_application_with_username_and_password() {
		//Selenium project code
		 System.out.println("login");
		 log.info("credentials entered");
	    }
	 
	  @Then("^Home page is populated$")
	    public void home_page_is_populated() {
		//Selenium project code
		  System.out.println("home page");
		  log.info("populated");
	    }
	  
	  @And("^Medicare benefits are getting displayed$")
	    public void medicare_benefits_are_getting_displayed() {
		//Selenium project code
		  System.out.println("Medicare benefits");
	    }
	 
}
