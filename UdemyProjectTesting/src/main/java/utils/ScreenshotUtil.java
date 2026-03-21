package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String testName) {
		try {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String path = "screenshots/failed/" + testName + "_" + timestamp + ".png";
			FileUtils.copyFile(src, new File(path));
			
			return path;
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}