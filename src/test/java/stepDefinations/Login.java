package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Login {

	private static Logger log =LogManager.getLogger(Login.class.getName());
	
	@Given("^User is on landing page$")
    public void user_is_on_landing_page() throws Throwable {
       //Selenium project code
		
		System.out.println("landed page");
		log.info("Landed");
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
