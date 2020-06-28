package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePagePOM;

public class NDTV_Weather_Test {

	String BaseUrl = "https:/www.ndtv.com/";
	WebDriver driver = new ChromeDriver();
	HomePagePOM homepagepom = new HomePagePOM();

	@BeforeTest
	public void setDriver() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }

	@Test
	public void gotoNDTVHomePage() throws InterruptedException {

		homepagepom.launchHomePage(driver, BaseUrl);
		homepagepom.clickOnEllipseButton(driver);
		boolean flag = homepagepom.validateCityonMap(driver,"Mumbai");
		String details = homepagepom.fetchCityDetails(driver);
		System.out.println(details);
		
		
	}
	
	
	

}
