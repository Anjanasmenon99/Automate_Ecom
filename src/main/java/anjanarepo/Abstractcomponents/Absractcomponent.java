package anjanarepo.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import anjanarepo.SeleniumFrameworkDesign.pageobjects.Cartpage;

public class Absractcomponent {
	
	WebDriver driver;

	public Absractcomponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink*='/cart']")
	WebElement carticon;
	

	public void waitForElementToAppear(By AppearElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppearElement));
	}
	
	public void waitForElementToDisappear(WebElement disappearElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(disappearElement)); 
	}
	
	public Cartpage goToCartIcon() {
		carticon.click();
		Cartpage cartpg = new Cartpage(driver);
		return cartpg;
	}
	
	
	 

}
