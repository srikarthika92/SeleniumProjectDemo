package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	public WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//a[normalize-space()='Edit Account']")
	private WebElement EditAccount;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement Message;
	
	public WebElement EditAccount()
	{
		return EditAccount;
	}
	
	public WebElement Message()
	{
		return Message;
	}
}
