package tests;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.RegisterPage;
import pages.UpdateProfilePage;

import java.time.Duration;
import java.util.UUID;

public class UpdateProfileTest {

    WebDriver driver;
    RegisterPage registerPage;
    UpdateProfilePage updateProfilePage;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.initDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        registerPage = new RegisterPage(driver);
        updateProfilePage = new UpdateProfilePage(driver);

        // Create dynamic username
        String user = "user" + UUID.randomUUID().toString().substring(0,5);

        registerPage.openRegisterPage();

        registerPage.fillRegistrationForm(
                "Kundu",
                "Shukla",
                "Street 1",
                "Ashi girls hostel",
                "Bhopal",
                "10001",
                "9234567889",
                "1234",      // SSN (IMPORTANT)
                user,
                "pass123"
        );

        registerPage.clickRegister();

        Assert.assertTrue(registerPage.isRegistrationSuccessful(),
                "Registration Failed!");
    }

    @Test
    public void verifyProfileUpdate() {

        updateProfilePage.openUpdateProfilePage();

        updateProfilePage.updateProfile(
                "John",
                "Updated",
                "New Street",
                "Singrauli",
                "320000",
                "100234",
                "7630542634"
        );

        Assert.assertTrue(updateProfilePage.isProfileUpdated(),
                "Profile Update Failed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}