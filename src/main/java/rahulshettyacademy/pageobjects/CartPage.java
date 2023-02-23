package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

	WebDriver driver;

	@FindBy(css = ".cartSection h3")
	List<WebElement> productsInCart;

	@FindBy(css = ".totalRow .btn-primary")
	WebElement checkOut;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyingProductInCart(String productName) {
		boolean match = productsInCart.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return match;
	}

	public PaymentPage clickOnCheckout() {
		checkOut.click();
		PaymentPage pp = new PaymentPage(driver);
		return pp;
	}

}
