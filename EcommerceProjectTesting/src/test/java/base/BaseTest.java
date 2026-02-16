package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = DriverFactory.initDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
