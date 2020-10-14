package testScripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class RegisterOpenCart {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void openCart() {
		WebElement account = driver.findElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]"));
		account.click();
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		// driver.findElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]//following::a[contains(text(),'Register')]")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("VinayKumar");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Gunti");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("vinayjaan3@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("8328379319");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Lva345!$");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Lva345!$");
		driver.findElement(
				By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]"))
				.click();
		driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"))
				.click();
		driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"))
				.click();
	}

	@Test
	public void NegativeScenariosopenCart() {
		WebElement account = driver.findElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]"));
		account.click();
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		// driver.findElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]//following::a[contains(text(),'Register')]")).click();
		WebElement firstname = driver.findElement(By.xpath("//input[@id='input-firstname']"));
		if (firstname.isSelected()) {
			firstname.sendKeys("VinayKuma");
			Assert.assertEquals(firstname, "VinayKumar");
		}
		WebElement lastname=driver.findElement(By.xpath("//input[@id='input-lastname']"));
		if (lastname.isSelected()) {
		lastname.sendKeys("Gunt");
		Assert.assertEquals(lastname, "Gunti");
		}
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("vinayjaan3@gmail.com");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("8328379319");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Lva345!$");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Lva345!$");
		driver.findElement(
				By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]"))
				.click();
		driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"))
				.click();
		driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"))
				.click();
	}

	@AfterMethod
	public void afterMethod() {
		//driver.close();
	}

}
