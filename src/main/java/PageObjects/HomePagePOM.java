package PageObjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

public class HomePagePOM {

	public void clickOnEllipseButton(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(By.cssSelector("#h_sub_menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("WEATHER")).click();
		Thread.sleep(20000);

	}

	public void launchHomePage(WebDriver driver, String baseUrl) throws InterruptedException {
		// Goto NDTV Home Page
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		// driver.switchTo().alert().dismiss();

	}

	public boolean validateCityonMap(WebDriver driver, String cityname) throws InterruptedException {
		// Validate selecting city on MAP reveals weather
		// String handel = driver.getWindowHandle();
		// driver.navigate().to(handel);
		
		boolean flag = false;
		new Actions(driver).moveToElement(driver.findElement(By.id("map_canvas")));
		
		WebElement selectCity = driver.findElement(By.cssSelector("#searchBox"));
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(selectCity)).click();
		selectCity.sendKeys(cityname);
		Thread.sleep(2000);
		ArrayList<WebElement> optionsToSelect = (ArrayList<WebElement>)driver.findElements(By.cssSelector("input[type=checkbox]"));
		for(WebElement option : optionsToSelect){
			if(option.getText().equals(cityname)) {
				System.out.println("Trying to select: "+cityname);
				option.click();
				System.out.println("Clicked: "+cityname);
				flag = true;
				break;
			}
		}
		ArrayList<WebElement> cityToSelect = (ArrayList<WebElement>) driver.findElements(By.cssSelector("div[class=cityText]")) ;
		//driver.findElement(By.className("cityText")).click();
		for(WebElement option : cityToSelect){
			if(option.getText().equals(cityname)) {
				System.out.println("Trying to select: "+cityname);
				option.click();
				System.out.println("Clicked: "+cityname);
				flag = true;
				break;
			}
		}
		return flag;
	}

}
