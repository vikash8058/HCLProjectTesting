package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

	// Positive Test Cases

	@Test(priority = 1)
	public void TC01_verifyHomePageIsDisplayed() {
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePageDisplayed(), "Udemy home page is not displayed");
	}

	@Test(priority = 2)
	public void TC02_verifyPageTitleContainsUdemy() {
		Assert.assertTrue(driver.getTitle().contains("Udemy"), "Page title does not contain Udemy");
	}

	@Test(priority = 3)
	public void TC03_verifyURLContainsUdemy() {
		Assert.assertTrue(driver.getCurrentUrl().contains("udemy"), "URL does not contain udemy");
	}

	@Test(priority = 4)
	public void TC04_verifySearchWithValidKeyword() {
		HomePage homePage = new HomePage(driver);
		homePage.searchCourse("Python");
		String url = driver.getCurrentUrl().toLowerCase();
		Assert.assertTrue(url.contains("python"), "Search did not work for Python");
	}

	@Test(priority = 5)
	public void TC05_verifySearchResultsPageLoads() {
		HomePage homePage = new HomePage(driver);
		homePage.searchCourse("Python");
		Assert.assertTrue(driver.getCurrentUrl().contains("search"), "Search results page did not load");
	}

	// Negative Test Cases

	@Test(priority = 6)
	public void TC06_verifySearchWithEmptyInput() {
		HomePage homePage = new HomePage(driver);
		homePage.searchCourse("");
		Assert.assertTrue(driver.getCurrentUrl().contains("udemy"), "Page crashed on empty search");
	}

	@Test(priority = 7)
	public void TC07_verifySearchWithInvalidKeyword() {
		HomePage homePage = new HomePage(driver);
		homePage.searchCourse("xyzabc123");
		Assert.assertTrue(driver.getCurrentUrl().contains("udemy"), "Page crashed on invalid keyword");
	}

	@Test(priority = 8)
	public void TC08_verifySearchWithSpecialCharacters() {
		HomePage homePage = new HomePage(driver);
		homePage.searchCourse("!@#$%");
		Assert.assertTrue(driver.getCurrentUrl().contains("udemy"), "Page crashed on special characters");
	}

	@Test(priority = 9)
	public void TC09_verifySearchWithSpacesOnly() {
		HomePage homePage = new HomePage(driver);
		homePage.searchCourse("   ");
		Assert.assertTrue(driver.getCurrentUrl().contains("udemy"), "Page crashed on spaces input");
	}

	@Test(priority = 10)
	public void TC10_verifySearchWithLongText() {
		HomePage homePage = new HomePage(driver);
		homePage.searchCourse("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		Assert.assertTrue(driver.getCurrentUrl().contains("udemy"), "Page crashed on long text");
	}
}