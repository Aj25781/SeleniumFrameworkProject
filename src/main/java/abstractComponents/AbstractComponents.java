package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ajayshettyacademy.CartPage;
import ajayshettyacademy.OrderHistoryPage;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartSubmit;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeaderElement; 

	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findBy)));
	}

	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public CartPage goToCart() {

		cartSubmit.click();
		return new CartPage(driver);
	}
	
	public OrderHistoryPage clickOrdersHistory() {
		
		orderHeaderElement.click();
		
		return new OrderHistoryPage(driver) ; 
		
	}

}
