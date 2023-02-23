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
	}

}
