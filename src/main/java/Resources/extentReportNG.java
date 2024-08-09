package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportNG {
	
	public static ExtentReports getReportObject() {
		ExtentReports extent;
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		
		reporter.config().setReportName("My First Report");
		reporter.config().setDocumentTitle("Html Report Ajay");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ajay Sharma");
		return extent;
	}
	
	
	
	

}
