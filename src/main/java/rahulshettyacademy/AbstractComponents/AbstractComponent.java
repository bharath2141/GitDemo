package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrdersPage;

public class AbstractComponent {

	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink$='cart']")
	WebElement cart;
	
	@FindBy(css = "[routerlink$='myorders']")
	WebElement viewOrdersButton;
	
public void waitforElementToAppear(By locator)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
}

public void waitforElementToDisappear(By locator)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
}

public void waitforElementToBeClickable(WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

public CartPage clickOnCart() throws InterruptedException
{
	waitforElementToBeClickable(cart);
	Thread.sleep(3000);
cart.click();
 CartPage cp = new CartPage(driver);
 return cp;
 
}

public OrdersPage gotoOrdersPage()
{
	viewOrdersButton.click();
	OrdersPage op=new OrdersPage(driver);
	return op;}
}
