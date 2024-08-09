package ajayshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class ThankYouPage extends AbstractComponents {
	WebDriver driver;

	public ThankYouPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(className="hero-primary")
	WebElement ThanksText; 
	
	public String getThankYouText() {
		
		String Message=ThanksText.getText();
		System.out.println(Message);
		return Message; 
	}

}
