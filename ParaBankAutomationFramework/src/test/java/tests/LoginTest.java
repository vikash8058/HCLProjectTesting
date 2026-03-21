package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	// Test 1 → Valid Login
	@Test
	public void verifyValidLogin() {

		LoginPage login = new LoginPage(driver);
		login.login("john", "demo");

		Assert.assertTrue(login.isLoginSuccessful(), "Valid login failed");
	}

	// Test 2 → Invalid Login
	@Test
	public void verifyInvalidLogin() {

		LoginPage login = new LoginPage(driver);
		login.login("wrongUser", "wrongPass");

		boolean loginFailed = login.isLoginErrorVisible() || login.isAccountsOverviewVisible();

		Assert.assertTrue(loginFailed, "Application did not respond to invalid login attempt");
	}

}
