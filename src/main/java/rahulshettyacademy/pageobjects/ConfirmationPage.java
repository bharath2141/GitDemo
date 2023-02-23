package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmationPage {
	
	WebDriver driver;
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMsg;
	
	public ConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String confirmMessage()
	{
		return confirmationMsg.getText();
	}
	

}
