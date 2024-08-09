package stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ajayshettyacademy.CartPage;
import ajayshettyacademy.LandingPage;
import ajayshettyacademy.PaymentPage;
import ajayshettyacademy.ProductCatalouge;
import ajayshettyacademy.ThankYouPage;
import ajayshettyacademy.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefination extends BaseTest {
	
	public LandingPage pageLanding; 
	public ProductCatalouge getProduct;
	ThankYouPage pageThank;
	
	@Given("I landed on ecommerce website")
	public void I_landed_on_ecommece_website() throws IOException {
		
		pageLanding=launchApplication();
	}
	
	//Step3  :Given Login with username <username> and password <password>
	@Given("^Login with username (.+) and password (.+)$")
	public void Login_with_username_password(String username, String password) {
		
		 getProduct= pageLanding.loginLandingPage(username,password);
	}
	
	//When I add product<productName> to cart 
	@When("^I add product (.+) to cart$")
	public void add_Product_To_Car(String productName) {
		
		List<WebElement> listProduct = getProduct.getProductList();
		WebElement newElement = getProduct.getProductByName(productName);
		getProduct.addProductToCart(newElement);
	}
	
	//And  Checkout the product<productName> and submit the order
	@When("^Checkout the product (.+) and submit the order$")
	public void Checkout_product_submit_order(String productName) throws InterruptedException {
		
		
		CartPage cp = getProduct.goToCart();

		Boolean flag = cp.compareProductTitles(productName);
		Assert.assertTrue(flag);
		PaymentPage pp = cp.checkOut();

		String name = "India";
		pp.selectCountry(name);
		pp.collectCountrys(name);
		pageThank = pp.placeOrder();
	}
	
	//Then I verify the confirmation message "THANKYOU FOR THE ORDER." is displayed
	@Then("I verify the confirmation message {string} is displayed")
	public void verify_message(String message) {
		String Message = pageThank.getThankYouText();


		Assert.assertEquals(Message, message);
		
	}
	
	

}
