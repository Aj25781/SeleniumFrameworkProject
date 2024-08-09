package ajayshettyacademy;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class PaymentPage extends AbstractComponents {
	WebDriver driver;

	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	// driver.findElement(By.xpath("//div[@class='form-group']/input")).sendKeys(name);

	@FindBy(xpath = "//div[@class='form-group']/input")
	WebElement selectCountry;

	@FindBy(xpath = "//button[@type='button']")
	List<WebElement> list1;
	
	@FindBy(css="[class*='btnn']")
	WebElement placeOrderBtn;

	public void selectCountry(String name) {

		selectCountry.sendKeys(name);
		
	}

	public void collectCountrys(String countryName) throws InterruptedException {

		List<WebElement> dropdownValue = list1.stream().filter(s -> s.getText().equalsIgnoreCase(countryName))
				.collect(Collectors.toList());
		
		
		dropdownValue.get(0).click();
		
	}
	
	public ThankYouPage placeOrder() {
		
		placeOrderBtn.click();
		return new ThankYouPage(driver);
	}

	/*
	 * List<WebElement>list1=driver.findElements(By.xpath("//button[@type='button']"
	 * ));
	 * 
	 * 
	 * 
	 * driver.findElement(By.cssSelector("[class*='btnn']")).click();
	 */

}
