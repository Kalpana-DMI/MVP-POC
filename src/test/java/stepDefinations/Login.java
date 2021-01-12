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
	    //base.LaunchURL(jsonData.ReadData(url));
	    
	}
	
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {
	    System.out.println(jsonData.ReadData(username));
	    System.out.println(jsonData.ReadData(password));
	}


}