package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.OrdersPage;
import rahulshettyacademy.pageobjects.PaymentPage;
import rahulshettyacademy.pageobjects.ProductCatalogPage;

public class SubmitOrderTest extends BaseTest {

	String productName="zara coat 3";
	@Test(dataProvider="getData",groups="Purchase")
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String countryName = "India";
		String confirmationExpectedMsg = "THANKYOU FOR THE ORDER.";

	
		
		ProductCatalogPage pc = lp.loginApplication(input.get("email"), input.get("pwd"));

		// ProductCatalogPage pc = new ProductCatalogPage(driver);
		// List<WebElement> products = pc.getProductList();
		pc.addProductToCart(input.get("productName"));
		CartPage cp = pc.clickOnCart();

		// CartPage cp = new CartPage(driver);
		boolean match = cp.verifyingProductInCart(input.get("productName"));
		Assert.assertTrue(match);
		PaymentPage pp = cp.clickOnCheckout();

		// PaymentPage pp = new PaymentPage(driver);
		ConfirmationPage cnmp = pp.processOrder(countryName);

		// ConfirmationPage cnmp = new ConfirmationPage(driver);
		String actualMsg = cnmp.confirmMessage();
		Assert.assertEquals(actualMsg, confirmationExpectedMsg);

	}
	
	@Test(dependsOnMethods="submitOrder")
	public void OrderHistoryTest()
	{
		
		ProductCatalogPage pc = lp.loginApplication("bharathreddy1428@gmail.com", "Funday@16");
		OrdersPage op=lp.gotoOrdersPage();
		Assert.assertTrue(op.getProductNameInOrderHistory(productName));
			
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String,String>> data=getJsonDataToMap(System.getProperty("user.dir")+"/src/test/java/rahulshettyacademy/data/PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		/*
		 * Object[][] data=new Object[2][3]; 
		 * data[0][0]="bharathreddy1428@gmail.com";
		 * data[0][1]="Funday@16";
		 *  data[0][2]="zara coat 3";
		 * data[1][0]="shetty@gmail.com"; 
		 * data[1][1]="Iamking@000";
		 * data[1][2]="Adidas Original";
		return data;*/
		
		/*
		 * HashMap<String,String> map=new HashMap<String,String>(); map.put("email",
		 * "bharathreddy1428@gmail.com"); map.put("pwd", "Funday@16");
		 * map.put("productName", "zara coat 3");
		 * 
		 * HashMap<String,String> map1=new HashMap<String,String>(); map1.put("email",
		 * "shetty@gmail.com"); map1.put("pwd","Iamking@000");
		 * map1.put("productName","Adidas Original");
		 */

		
	}
}