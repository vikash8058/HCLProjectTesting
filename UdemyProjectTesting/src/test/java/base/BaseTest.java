package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.initDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.udemy.com/");

		// 🔥 STEP 2: Handle Cloudflare manually
		try {
			System.out.println("If CAPTCHA appears, solve it manually...");
			Thread.sleep(10000); // wait 10 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}