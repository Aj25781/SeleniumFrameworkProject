package ajayshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ajayshettyacademy.CartPage;
import ajayshettyacademy.LandingPage;
import ajayshettyacademy.OrderHistoryPage;
import ajayshettyacademy.PaymentPage;
import ajayshettyacademy.ProductCatalouge;
import ajayshettyacademy.ThankYouPage;
import ajayshettyacademy.TestComponents.BaseTest;
import ajayshettyacademy.data.DataReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException {

		// TODO Auto-generated method stub

		ProductCatalouge getProduct = pageLanding.loginLandingPage(input.get("email"), input.get("password"));

		String productName = "ZARA COAT 3";

		List<WebElement> listProduct = getProduct.getProductList();
		WebElement newElement = getProduct.getProductByName(productName);
		getProduct.addProductToCart(newElement);
		CartPage cp = getProduct.goToCart();

		Boolean flag = cp.compareProductTitles(productName);
		Assert.assertTrue(flag);
		PaymentPage pp = cp.checkOut();

		String name = "India";
		pp.selectCountry(name);
		pp.collectCountrys(name);
		ThankYouPage pageThank = pp.placeOrder();

		String Message = pageThank.getThankYouText();


		Assert.assertEquals(Message, "THANKYOU FOR THE ORDER.");

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistory() {
		String ProductName = "ZARA COAT 3";

		ProductCatalouge getProduct = pageLanding.loginLandingPage("ajay25781@gmail.com", "Aju25781@25");

		OrderHistoryPage OHP = getProduct.clickOrdersHistory();

		OHP.verifyOrderDisplay(ProductName);
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {

		DataReader dataRead=new DataReader();
		List<HashMap<String,String>>data=dataRead.getJsonDataToMap("C:\\Users\\Public\\Java Projects\\SeleniumFrameworkDesign\\src\\test\\java\\ajayshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	/*HashMap<String, String> map1 = new HashMap<String, String>();

	map1.put("email", "ajay25781@gmail.com");
	map1.put("password", "Aju25781@25");

	HashMap<String, String> map2 = new HashMap<String, String>();

	map2.put("email", "gaurav2713089@gmail.com");
	map2.put("password", "Gs2713089");
	
	return new Object[][] {{map1},{map2}};*/

	// return new Object[][]
	// {{"ajay25781@gmail.com","Aju25781@25"},{"gaurav2713089@gmail.com","Gs2713089"}};
}
