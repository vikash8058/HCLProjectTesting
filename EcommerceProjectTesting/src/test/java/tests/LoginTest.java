package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeMethod
    public void setupLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
    }

    @Test(priority = 1)
    public void verifyLoginWithValidCredentials() {

        loginPage.login("vishaltest123@gmail.com", "Test@123");

        Assert.assertTrue(
                loginPage.isUserLoggedIn(),
                "Login failed - User not logged in"
        );
    }

 
    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {

        loginPage.login("wronguser@gmail.com", "wrongpass");

        Assert.assertTrue(
                loginPage.getLoginErrorMessage().toLowerCase().contains("incorrect"),
                "Error message not displayed for invalid login"
        );
    }

 
    @Test(priority = 3)
    public void verifyLogoutFunctionality() {

        loginPage.login("vishaltest123@gmail.com", "Test@123");
        loginPage.logout();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("login"),
                "User not redirected to login page after logout"
        );
    }
}
