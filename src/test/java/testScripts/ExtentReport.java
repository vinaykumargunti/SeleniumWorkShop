package testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\Coding\\Seleniumlib\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Report/report.html");
		
		extent = new ExtentReports();
		reporter.setAppendExisting(true);
		extent.attachReporter(reporter);
		

	}

	@Test(enabled = false)
	public void cucumberTest() {
		logger = extent.createTest("Verify cucumber");
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("cucumber tools");
		searchbox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "cucumber tools - Google Search");

	}

	@Test(priority = 2)
	public void javaTest() {
		logger = extent.createTest("Verify java tools");
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("java tools");
		searchbox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "java tools - Google Search");
		
		extent.flush();
	}

	@Test(priority = 1)
	public void seleniumTest() {
		logger = extent.createTest("Verify selenium tools");
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("selenium tools");
		searchbox.sendKeys(Keys.ENTER);
		Assert.assertEquals(driver.getTitle(), "selenium tool - Google Search");
		
		extent.flush();
	}

	@AfterMethod
	public void close(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			String tempPath = CommonUtil.getScreenShot(driver);
			logger.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(tempPath).build());
		}
		//extent.flush();
		driver.close();
	}
}
