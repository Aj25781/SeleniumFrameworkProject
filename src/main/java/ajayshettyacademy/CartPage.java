package ajayshettyacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement>cartProduct; 
	
	@FindBy(css=".totalRow button")
	WebElement checkoutButton ; 
	
	public Boolean compareProductTitles(String ProductName) {
		
		Boolean flag=cartProduct.stream().anyMatch(product->product.getText().equals(ProductName));
		
		return flag;
	}
	
	public PaymentPage checkOut()
	{
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		checkoutButton.click();
		return new PaymentPage(driver);
		
	}
	
	
	
	

}
