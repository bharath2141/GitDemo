package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent {
	
	WebDriver driver;
	
	public PaymentPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement placeOrderButton;
	
	By countryList=By.cssSelector("section.ta-results");
	By SelectCountry=By.cssSelector(".ta-item:last-child");
	
	public ConfirmationPage processOrder(String countryName) throws InterruptedException
	{
		selectCountry.sendKeys(countryName);
		waitforElementToAppear(countryList);
		driver.findElement(SelectCountry).click();
	//	waitforElementToDisappear(countryList);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("window.scrollBy(0,500)");
		Thread.sleep(10000);
		placeOrderButton.click();
		ConfirmationPage cnmp = new ConfirmationPage(driver);
		return cnmp;
		
	}

}
