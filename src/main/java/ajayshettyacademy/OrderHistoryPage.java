package ajayshettyacademy;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class OrderHistoryPage extends AbstractComponents{
	WebDriver driver;

	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement>listofProducts;
	
	public Boolean verifyOrderDisplay(String product) {
		
		Boolean match=listofProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		System.out.println(match);
		return match ; 
	}
	
	

}
