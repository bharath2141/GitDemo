package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
	
	WebDriver driver;
	public OrdersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderedProducts;
	
	public boolean getProductNameInOrderHistory(String productName)
	{
		 return orderedProducts.stream().filter(s->s.getText().equalsIgnoreCase(productName)).findFirst().orElse(null).getText().equalsIgnoreCase(productName);
		
	}

}
