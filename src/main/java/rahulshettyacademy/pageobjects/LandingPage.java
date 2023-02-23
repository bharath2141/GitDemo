package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement userEmail = driver.findElement(By.cssSelector("#userEmail"));
//	WebElement userPwd = driver.findElement(By.id("userPassword"));
//	WebElement loginButton = driver.findElement(By.id("login"));

	// PageFactory

	@FindBy(css = "#userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPwd;

	@FindBy(id = "login")
	WebElement loginButton;
	
	By errorMsg =By.cssSelector("[class*='flyInOut']");
	

	public ProductCatalogPage loginApplication(String email, String pwd) {
		userEmail.sendKeys(email);
		userPwd.sendKeys(pwd);
		loginButton.click();
		ProductCatalogPage pc = new ProductCatalogPage(driver);
		return pc;
	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");
	}
	public String getErrorMsg()
	{
		waitforElementToAppear(errorMsg);
		 return driver.findElement(errorMsg).getText();
		
	}

}
