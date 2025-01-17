package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='input-email']")
	private WebElement EmailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement PasswordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginButton;
	
	public WebElement EmailField()
	{
		return EmailField;
	}
	
	public WebElement PasswordField()
	{
		return PasswordField;
	}
	
	public WebElement LoginButton()
	{
		return LoginButton;
	}
}
