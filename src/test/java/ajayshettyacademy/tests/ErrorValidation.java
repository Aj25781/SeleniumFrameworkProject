package ajayshettyacademy.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import ajayshettyacademy.ProductCatalouge;
import ajayshettyacademy.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {
	
	@Test(groups= {"FirstGroup"})
	public void invalidUsernamePass() throws IOException, InterruptedException {

		pageLanding.loginLandingPage("ajay25781@gmail.com", "Aju25781@255");
		String error=pageLanding.getError();
		System.out.println(error);
		Assert.assertEquals("Incorrect email or password.", error);

}
}
