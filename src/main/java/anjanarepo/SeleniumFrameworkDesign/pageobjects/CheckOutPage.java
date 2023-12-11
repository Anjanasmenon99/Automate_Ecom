package anjanarepo.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import anjanarepo.Abstractcomponents.Absractcomponent;

public class CheckOutPage extends Absractcomponent{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".form-group .txt")
	WebElement avaliableCountryEle;
	
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement submit;
	
	@FindBy(xpath="(//button[contains(@class,'ng-star-inserted')])[2]")
	WebElement countrySelected;
	
	By countryvisiblity=By.cssSelector("section[class*='list-group']");
	
	public void SelectCountry(){
		Actions a = new Actions(driver);
		a.sendKeys(avaliableCountryEle, "India").build().perform();
		waitForElementToAppear(countryvisiblity);
		countrySelected.click();
		// Thread.sleep(5000);        
	}	
	
	public void SubmitOrder() {
		submit.click();
	}
	
	
	
	
	
}
