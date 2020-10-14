package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	 WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.google.com/");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
  @Test(enabled=false)
  public void cucumberTest() {
	  
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("cucumber tools");
		searchbox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "cucumber tools - Google Search");
		
  }
  @Test(priority=2)
  public void javaTest() {
	  
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("java tools");
		searchbox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "java tools - Google Search");
  }
  @Test(priority=1)
  public void seleniumTest() {
	
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("selenium tools");
		searchbox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "selenium tools - Google Search");
  }
  @AfterMethod
  public void close() {
	  driver.close();
  }
}
