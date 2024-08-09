package ajayshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver ; 
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="userEmail")
	WebElement userEmail; 
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement Login; 
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement errorWebelement; 
	
	
	public ProductCatalouge loginLandingPage(String email,String password) {
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		Login.click();
		return new ProductCatalouge(driver);
		
	}
	
	public String getError() throws InterruptedException {
		waitForWebElementToAppear(errorWebelement);
		String error=errorWebelement.getText();
		return error;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
		

	
	
	

	

}
