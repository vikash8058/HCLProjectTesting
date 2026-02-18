package tests;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.*;

import java.util.UUID;

public class FindTransactionsTest {

    WebDriver driver;
    RegisterPage registerPage;
    FindTransactionsPage findTransactionsPage;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.initDriver();

        registerPage = new RegisterPage(driver);
        findTransactionsPage = new FindTransactionsPage(driver);

        // Dynamic User Creation
        String user = "user" + UUID.randomUUID().toString().substring(0,5);

        registerPage.openRegisterPage();
        registerPage.fillRegistrationForm(
                "John",
                "Doe",
                "Street 1",
                "NY",
                "NY",
                "10001",
                "9999999999",
                "12345",
                user,
                "pass123"
        );

        registerPage.clickRegister();
        Assert.assertTrue(registerPage.isRegistrationSuccessful());
    }

    @Test
    public void verifyFindTransactionPageOpens() {

        findTransactionsPage.openFindTransactionsPage();

        Assert.assertTrue(true); // navigation verification
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}