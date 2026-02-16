package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class HomePageTest extends BaseTest {

	@Test
	public void verifyHomePageLoaded() {

		HomePage homePage = new HomePage(driver);

		Assert.assertTrue(homePage.isLogoDisplayed(), "Home page did not load properly");
	}

	@Test
	public void verifyScrollUpFeature() {

		HomePage homePage = new HomePage(driver);

		homePage.scrollToFooter();
		homePage.clickScrollUp();

		Assert.assertTrue(homePage.isTopLogoVisible(), "Scroll up did not work");
	}

	@Test
	public void verifyCategorySectionVisible() {

		HomePage homePage = new HomePage(driver);

		Assert.assertTrue(homePage.isCategorySectionDisplayed(), "Category section not visible");
	}

	@Test
	public void verifyFeaturedItemsSection() {

		HomePage homePage = new HomePage(driver);

		Assert.assertTrue(homePage.isFeaturedItemsVisible(), "Featured items section missing");
	}

	@Test
	public void verifyFooterVisible() {

		HomePage homePage = new HomePage(driver);

		homePage.scrollToFooter();

		Assert.assertTrue(homePage.isFooterVisible(), "Footer not visible");
	}

}
