package anjanarepo.SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import anjanarepo.Abstractcomponents.Absractcomponent;

public class Landingpage extends Absractcomponent{
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	//WebElement useremail=driver.findElement(By.id("userEmail"));
	//pagefactory
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submitlogin;
	
	public void go_to() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public productcatalog loginApp(String email,String password) {
		useremail.sendKeys(email);
		passwordEle.sendKeys(password);
		submitlogin.click();
		productcatalog prodcatalog = new productcatalog(driver);
		return prodcatalog;
	}
	
	
}
