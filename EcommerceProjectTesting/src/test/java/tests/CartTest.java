package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;

public class CartTest extends BaseTest {

	@Test
	public void verifyCartPageNavigation() {
		CartPage cartPage = new CartPage(driver);

		cartPage.clickCart();
		Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page is not displayed");
	}

	@Test
	public void verifyProductDetailsInCart() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		CartPage cartPage = new CartPage(driver);

		// Add first product from homepage
		driver.findElement(org.openqa.selenium.By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(org.openqa.selenium.By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

		cartPage.clickCart();

		Assert.assertTrue(cartPage.getProductName().length() > 0);
		Assert.assertTrue(cartPage.getProductPrice().contains("Rs"));
		Assert.assertTrue(cartPage.getProductQuantity().equals("1"));
	}

	@Test
	public void verifyRemoveProductFromCart() throws InterruptedException {
		CartPage cartPage = new CartPage(driver);

		// Add first product
		driver.findElement(org.openqa.selenium.By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();
		Thread.sleep(2000);

		driver.findElement(org.openqa.selenium.By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

		cartPage.clickCart();
		cartPage.clickRemoveProduct();

		Thread.sleep(2000);

		Assert.assertTrue(cartPage.isCartEmptyMessageDisplayed(), "Cart is not empty after removing product");
	}
}