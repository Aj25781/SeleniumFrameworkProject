package ajayshettyacademy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import ajayshettyacademy.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver; 
	public LandingPage pageLanding;
	
	public WebDriver initializeDriver() throws IOException {
		
		
		Properties pr =new Properties();
		FileInputStream fl = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Global.properties");
		pr.load(fl);
		
		String browser=System.getProperty("browser")!=null ? System.getProperty("browser") :pr.getProperty("browser");
		
	
		if (browser.contains("chrome")){
			ChromeOptions option =new ChromeOptions();
			if(browser.contains("headless"))
			{
				option.addArguments("headless");
			}
			

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(option);
			
			driver.manage().window().setSize(new Dimension(1440,900));
		}
		else  {
			
			WebDriverManager.edgedriver().setup();

			driver=new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver; 
	}
	@BeforeMethod(alwaysRun=true)
	public  LandingPage launchApplication() throws IOException {
		
		driver = initializeDriver(); 
		
		pageLanding=new LandingPage(driver);
		pageLanding.goTo();
	    return pageLanding;
		
		
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		
		 if (driver == null) {
		        throw new WebDriverException("WebDriver instance is null");
		    }
		
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"//reports"+testCaseName+".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir")+"//reports"+testCaseName+".png";
	}

	@AfterTest(alwaysRun=true)
	public void exit() {
		driver.close();;
	}
}
