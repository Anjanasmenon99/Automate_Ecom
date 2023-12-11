package anjanarepo.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import anjanarepo.SeleniumFrameworkDesign.pageobjects.Cartpage;
import anjanarepo.SeleniumFrameworkDesign.pageobjects.CheckOutPage;
import anjanarepo.SeleniumFrameworkDesign.pageobjects.productcatalog;
import anjanarepo.Testcomponents.Basetest;


public class Standalonetest2final extends Basetest{

	@Test
	public void submitorder() throws IOException{
		
		String reqitem="ZARA COAT 3";
		//Landingpage landingpg=launchApplication();
		productcatalog prodcatalog=landingpg.loginApp("anjanas@gmail.com", "Anjana@pass9");
		
		List<WebElement> items=prodcatalog.itemsappear();
		prodcatalog.addtocart(reqitem);
		Cartpage cartpg=prodcatalog.goToCartIcon();
		
		Boolean matchcase=cartpg.VerifyItemsDisplay(reqitem);
		Assert.assertTrue(matchcase);
		CheckOutPage checkoutpg=cartpg.CheckoutCartUI();
		
		checkoutpg.SelectCountry();
		checkoutpg.SubmitOrder();
		
		
		
	
	}

	

}
