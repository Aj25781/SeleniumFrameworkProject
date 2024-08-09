package ajayshettyacademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Resources.extentReportNG;

public class Listeners extends BaseTest implements ITestListener{
	
	
	ExtentReports extent=extentReportNG.getReportObject();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
	
		test.fail(result.getThrowable());
		String filePath=null;
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			filePath=getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName() );
		
		 
		//screenshot,

		
		//attach it to report
		
		
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
	    extent.flush();
	}
	
	@Override  
	public void onTestSuccess(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Success of test cases and its details are : "+result.getName());  
	
	} 
	
	

}
