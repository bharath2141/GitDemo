package rahulshettyacademy.pageobjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogPage extends AbstractComponent {
	WebDriver driver;

	public ProductCatalogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	
	
	
	
	

	By productBy = By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastMsg=By.cssSelector("#toast-container");
	By spinner =By.cssSelector(".ng-animating");

	public List<WebElement> getProductList() {
		waitforElementToAppear(productBy);
		return products;
	}

	public WebElement getProductByName(String ProductName) {
		WebElement prod = getProductList().stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(ProductName)).findFirst()
				.orElse(null);
		return prod;
	}
	public void addProductToCart(String ProductName)
	{
		WebElement prod=getProductByName(ProductName);	
		prod.findElement(addToCart).click();
		waitforElementToAppear(toastMsg);
		waitforElementToDisappear(spinner);
		
	}
	
	
	
	
	
	
}
