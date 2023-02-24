package rahulshettyacademy.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.RerunFailedTCs;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;

public class ErrorValidationTest extends BaseTest {
	
	@Test(groups={"ErrorHandling"},retryAnalyzer=RerunFailedTCs.class) // to re-run failed tc's
	
	
	public void loginErrorValidation() 
	{
		ProductCatalogPage pc=lp.loginApplication("bharathreddy1428@gmail.com","bharath1428");
		Assert.assertEquals(lp.getErrorMsg(), "Incorrect email  password.");

		System.out.println("update from gitstuff");

		System.out.println("adding piece of code to check git working or not");
		System.out.println("update from gitstuff3");
		System.out.println("update from gitstuff2");
		System.out.println("develop branch in demo");

	}
	
	@Test(groups="ErrorHandling")
	public void productErrorValidation() throws InterruptedException 
	{
		String productName="zara coat 3";
		ProductCatalogPage pc = lp.loginApplication("bharathreddy1428@gmail.com", "Funday@16");
		pc.addProductToCart(productName);
		CartPage cp = pc.clickOnCart();
		boolean match = cp.verifyingProductInCart("fdkdl");
		Assert.assertFalse(match);
		System.out.println("develop branch in demo");}

}
