package ajayshettyacademy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class ProductCatalouge extends AbstractComponents {
	
	WebDriver driver ; 
	public ProductCatalouge(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver; 
		PageFactory.initElements(driver, this);
	}

	//List<WebElement>listProduct=driver.findElements(By.cssSelector(".col-lg-4"));
	
     By toastMessage = By.id("toast-container");
     
     
	
	@FindBy(css=".col-lg-4")
	List<WebElement> listProduct; 

	
	
	public List<WebElement> getProductList() {
		
		return listProduct;
	}
	
	public WebElement getProductByName(String productName) {
		
		WebElement newElement=listProduct.stream().filter(product->driver.findElement(By.xpath("//div[@class='card-body']/h5/b")).getText().equals(productName)).findFirst().orElse(null);
		return newElement;
	}
	
	
	public void addProductToCart(WebElement newElement) {
		
		
		newElement.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		waitForElementToAppear(toastMessage);
		
		
	}

}
