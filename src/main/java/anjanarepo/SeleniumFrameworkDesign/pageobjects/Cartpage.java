package anjanarepo.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import anjanarepo.Abstractcomponents.Absractcomponent;

public class Cartpage extends Absractcomponent{
	
	WebDriver driver;
	
	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	//WebElement useremail=driver.findElement(By.id("userEmail"));
	//pagefactory
	//driver.findElement(By.cssSelector(".totalRow .btn.btn-primary")).click();
	
	@FindBy(css=".totalRow .btn.btn-primary")
	WebElement checkoutcartlocator;
	
	@FindBy(css =".cartSection h3")
	private List<WebElement> cartitemsTitles;

	
	public Boolean VerifyItemsDisplay(String reqitem) {
		Boolean match=cartitemsTitles.stream().anyMatch(cartitem->cartitem.getText().equalsIgnoreCase(reqitem));
        return match;
	}
	
	public CheckOutPage CheckoutCartUI(){
		checkoutcartlocator.click();
		CheckOutPage checkoutpg = new CheckOutPage(driver);
		return checkoutpg;
	}	
	
	
	
}
