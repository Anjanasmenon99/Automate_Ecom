package anjanarepo.Testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import anjanarepo.SeleniumFrameworkDesign.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	public WebDriver driver;
	public Landingpage landingpg;

	public WebDriver initializeDriver() throws IOException {

		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/anjanareporesourcesGlobalData.properties");
		pro.load(fis);
		String Browsername = pro.getProperty("Browser");

		if (Browsername.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (Browsername.equalsIgnoreCase("Firefox")) {
			// firefox
		} else if (Browsername.equalsIgnoreCase("Edge")) {
			// Edge
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod
	public Landingpage launchApplication() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Landingpage landingpg = new Landingpage(driver);
		landingpg.go_to();
		return landingpg;
	}

	@AfterMethod
	public void closeWindow() {
		driver.close();
	}

}
