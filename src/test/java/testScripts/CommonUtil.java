package testScripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonUtil {

	public static String getScreenShot(WebDriver driver) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "./ScreenShots/" + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(srcFile, new File(path));
		return path;
	}

}
