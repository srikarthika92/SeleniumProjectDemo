package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExReport {
	
	static ExtentReports extentreports;   //static stuffs can access static so we need to make this instance static
	
	public static ExtentReports getExtentReports()  //we'll make this method static so that we can access it using class name
	
	{
		String reportPath=System.getProperty("user.dir")+"//reports//ExtentReports.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);  // for configuring path and setting up the report name ||like prerequisites
		
	    reporter.config().setReportName("Tutorials Ninja Report");
	    
	    reporter.config().setDocumentTitle("Test Results");
	    
	
	    extentreports = new ExtentReports(); //creating object and generating the report
	    
	    extentreports.attachReporter(reporter); //attaching configurations and path to it
	    
	    extentreports.setSystemInfo("Opertaing System", "Windows 10");
	    
	    extentreports.setSystemInfo("TestedBy", "Srikarthika Thangavel");
	    
	    return extentreports; 
	    
	}

}
