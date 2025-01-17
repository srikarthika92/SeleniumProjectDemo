package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver; // we can access outside the class and we can initialize it to other driver
	
	public Properties prop; //if it's public we can use it outside the class
	
	public  WebDriver InitializeBrowser() throws IOException 
	{
		prop=new Properties();
		
		String PropPath= System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		
		FileInputStream fis = new FileInputStream(PropPath);
		
		prop.load(fis);
		
		String browsername= prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if(browsername.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}

	public String TakeScreenshot(String testName, WebDriver driver) throws IOException
	{
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
				 
		FileUtils.copyFile(sourceFile,new File(destinationFilePath));
		
		return destinationFilePath;
	}	

	
}
