package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = DriverFactory.initDriver();
		driver.get("https://automationexercise.com/");
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
