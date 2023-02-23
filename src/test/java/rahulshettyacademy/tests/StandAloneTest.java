package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String item="zara coat 3";
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client");

		
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("bharathreddy1428@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Funday@16");
		driver.findElement(By.id("login")).click();
		
		
		
		  List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		/*  for(WebElement product:products) {
		 * if(product.findElement(By.tagName("b")).getText().
		 * equalsIgnoreCase(item) ) {
		 * 
		 * product.findElement(By.cssSelector("div button:last-child")).click(); break;}
		 * }
		 */
		 
		products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(item)).map(s->clickAddtoCart(s)).collect(Collectors.toList()).forEach(s->s.click());
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink$='cart']")).click();
		
		List<WebElement> cart=driver.findElements(By.cssSelector(".cartSection h3"));
		
		boolean match=cart.stream().anyMatch(s->s.getText().equalsIgnoreCase(item));
		Assert.assertTrue(match);
		
		driver.findElement(By.cssSelector(".totalRow .btn-primary")).click();
		
		//driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("ind");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button .ng-star-inserted")));
		
		//driver.findElements(By.cssSelector("button .ng-star-inserted")).stream().filter(s->s.getText().split("i")[1].contains("ndia")).findFirst().orElse(null).click();
		
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
	driver.findElement(By.cssSelector(".ta-item:last-child")).click();
	

	JavascriptExecutor jse2 = (JavascriptExecutor)driver;
	jse2.executeScript("window.scrollBy(0,500)");
	Thread.sleep(15000);
	 driver.findElement(By.cssSelector(".action__submit")).click();
	
		
	Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText(), "THANKYOU FOR THE ORDER.");
	driver.close();
		
		
		
		
		
	}

	private static WebElement clickAddtoCart(WebElement s) {
		// TODO Auto-generated method stub
	return	s.findElement(By.cssSelector(".card-body button:last-child"));
		
	}
		
		
	/*
	 * WebElement
	 * prod=products.stream().filter(s->s.findElement(By.cssSelector("h5 b")).
	 * equals(item)).findFirst().orElse(null);
	 * 
	 * 
	 * prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	 */
	
	
		

		
		
		
		
		
		
		
}