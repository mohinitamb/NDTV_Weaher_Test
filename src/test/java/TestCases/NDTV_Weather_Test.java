package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.API_Test;
import PageObjects.HomePagePOM;
import PageObjects.Weather;

public class NDTV_Weather_Test {

	String BaseUrl = "https:/www.ndtv.com/";
	WebDriver driver = new ChromeDriver();
	HomePagePOM homepagepom = new HomePagePOM();
	API_Test apitest = new API_Test();
	Weather ndtv_weather;
	Weather api_weather;

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
		System.out.println(flag);
		
		if(flag) {
		ndtv_weather  = homepagepom.fetchCityDetails(driver);
		api_weather = apitest.GetWeatherDetails();
		}
		
		int temp1 = ndtv_weather.getTemperature();
		int temp2 = api_weather.getTemperature();
		
		System.out.println("Temperature returned by NDTV : "+temp1);
		System.out.println("Temperature returned by Weather API : "+temp2);
		
	    if (Math.abs(temp1-temp2)<=2)
	    {
	    	System.out.println("Success : Temperature is within variable range");
	    	
	    } 
	    else{
	    	Assert.fail("Difference in weather forecast");
	    	
	    }
	    
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
	
	
	
	

}
