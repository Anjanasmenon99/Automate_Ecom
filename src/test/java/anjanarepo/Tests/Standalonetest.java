package anjanarepo.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import anjanarepo.SeleniumFrameworkDesign.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Standalonetest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Landingpage l = new Landingpage(driver);
		
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("anjanas@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Anjana@pass9");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		String reqitem="ZARA COAT 3";
		List<WebElement> items=driver.findElements(By.cssSelector(".mb-3"));
		WebElement itemselected =items.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(reqitem)).findFirst().orElse(null);
		itemselected.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        //ng-animating is the class for closing that invisible page-developer will know it
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("button[routerlink*='/cart']")).click();
        
        List<WebElement> cartitems=driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean matchcase=cartitems.stream().anyMatch(cartitem->cartitem.getText().equalsIgnoreCase(reqitem));
        Assert.assertTrue(matchcase);
        driver.findElement(By.cssSelector(".totalRow .btn.btn-primary")).click();
        
        Actions a=new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector(".form-group .txt")), "India").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*='list-group']")));
        driver.findElement(By.xpath("(//button[contains(@class,'ng-star-inserted')])[2]")).click();
        Thread.sleep(5000);
       
        driver.findElement(By.cssSelector(".action__submit")).click();
        
	}

}
