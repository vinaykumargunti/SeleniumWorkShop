package openCSVObjectRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginPage {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("D:\\Coding\\SeleniumWork\\Selenium\\Examples\\Loginform.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(dataProvider = "getData") // for method directly

	// @Test(dataProvider="loginPage") //for parameters

	// @Parameters({ "username", "password" })
	public void loginTest(String username, String password) throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@name='continue' or @type='submit']")).click();

	}

	@DataProvider // directly method
	// @DataProvider(name="loginPage")//for parameters
	public Object[][] getData() throws CsvValidationException, IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\testData\\test.csv";

		CSVReader reader = new CSVReader(new FileReader(path));

		String[] line;
		ArrayList<Object[]> arraylist = new ArrayList<Object[]>();
		if ((line = reader.readNext()) != null) {

			Object[] record = { line[0], line[1] };

			arraylist.add(record);
		}

		reader.close();
		return arraylist.toArray(new Object[arraylist.size()][]);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
