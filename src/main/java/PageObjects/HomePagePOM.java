package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagePOM {

	public void clickOnEllipseButton(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(By.cssSelector("#h_sub_menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("WEATHER")).click();
		Thread.sleep(10000);

	}

	public void launchHomePage(WebDriver driver, String baseUrl) throws InterruptedException {
		// Goto NDTV Home Page
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(10000);
		// driver.switchTo().alert().dismiss();

	}

	public void getCityWeather(WebDriver driver) {
		// TODO Auto-generated method stub
		// String handel = driver.getWindowHandle();
		// driver.navigate().to(handel);
		new Actions(driver).moveToElement(driver.findElement(By.id("map_canvas")));
		driver.findElement(By.className("cityText")).click();
	}

}
