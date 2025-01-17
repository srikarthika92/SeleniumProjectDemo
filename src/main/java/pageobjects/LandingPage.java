package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='caret']")
	private WebElement MyaccountDropDown;  //making page object as private is called encapsulation
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement LoginOption;  //we can access the page object using only the method
	
	public WebElement MyaccountDropDown()
	{
		return MyaccountDropDown;
	}
	
	public WebElement LoginOption()
	{
		return LoginOption;
	}
}
