package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import resources.Base;

public class LoginTest extends Base
{
	public WebDriver driver;
	
	Logger log;
	LoginPage loginpage;
	LandingPage landingpage;
	MyAccountPage myaccountpage;
	@Given("^User opens any browser$")

	public void User_opens_any_browser() throws IOException
	{
		
		System.out.println("Sai Has Updated This Code");
		
		System.out.println("Sai is commiting it");	

		System.out.println("Srinaya Has Update the code After Sai");
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver=InitializeBrowser();
		
		log.debug("Browser Got Launched");
	    
	}

	
	@And("^User Navigates to the application$")

	public void User_Navigates_to_the_application()
	{
		
		driver.get(prop.getProperty("url")); //prop already declared as public and initialized to prop file
		log.debug("Logged into the application");
		    
		landingpage=new LandingPage(driver);
		
	    landingpage.MyaccountDropDown().click();
	    log.debug("Clicked On MyAccountDropdown");
	       	
	    landingpage.LoginOption().click();
	    log.debug("Clicked On Login Option");
	    
		
	}
	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")

	public void User_enters_username_as_username_and_password_as_password(String username,String password)
	{
		
	     
	    loginpage =new LoginPage(driver);
	    
	    loginpage.EmailField().sendKeys(username);
	    log.debug("Entered Email_id");
	    
	    loginpage.PasswordField().sendKeys(password);
	    log.debug("Entered Password");
	    
	    
	}

	@And("^Click on login button$")

	public void Click_on_login_button() 
	{
		 loginpage =new LoginPage(driver);
		 
		 loginpage.LoginButton().click();
		 
		 log.debug("Clicked On LoginButton");
		
		
	}
	String actualresult=null;

	@Then("^User should be able to login based on \"([^\"]*)\" login status$")

	public void User_should_be_able_to_login_based_on_expected_login_status(String expected)
	{
		
		myaccountpage =new MyAccountPage(driver);
		
		try {
			String alert = myaccountpage.Message().getText();	

			if(alert.contains("Warning: No match for E-Mail Address and/or Password."))
			{
				
				actualresult="failure";
				log.error("User Unable to Login as Entered Invalid Credentials");
				
			}
			}
			catch(Exception e)
			{
				actualresult="success";
				log.info("User Logged In Successfully");
			}
			assertEquals(actualresult,expected);
			 

	}
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(10000);
            driver.quit();
  

      }
}
