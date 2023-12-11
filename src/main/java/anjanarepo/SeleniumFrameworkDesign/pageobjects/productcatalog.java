package anjanarepo.SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import anjanarepo.Abstractcomponents.Absractcomponent;

public class productcatalog extends Absractcomponent{
	
	WebDriver driver;
	
	public productcatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//List<WebElement> items=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> items;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productBy = By.cssSelector(".mb-3");
	By addtocartlocator=By.cssSelector(".card-body button:last-of-type");
	By toastname=By.cssSelector("#toast-container");
	By disappearlocator=By.cssSelector(".ng-animating");
	
	
	public List<WebElement> itemsappear() {
		waitForElementToAppear(productBy);
		return items;
	}
	
	public WebElement getproductbyname(String reqitem) {
		WebElement itemselected =itemsappear().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(reqitem)).findFirst().orElse(null);
		return itemselected;
	}
	
	public void addtocart(String reqitem) {
		WebElement itemselected=getproductbyname(reqitem);
		itemselected.findElement(addtocartlocator).click();
		waitForElementToAppear(toastname);
		waitForElementToDisappear(spinner);
		
	}
	
	
}
