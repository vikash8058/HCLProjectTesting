package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateProfilePage extends BasePage {

    WebDriverWait wait;

    public UpdateProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators

    @FindBy(linkText = "Update Contact Info")
    WebElement updateContactLink;

    @FindBy(id = "customer.firstName")
    WebElement firstName;

    @FindBy(id = "customer.lastName")
    WebElement lastName;

    @FindBy(id = "customer.address.street")
    WebElement address;

    @FindBy(id = "customer.address.city")
    WebElement city;

    @FindBy(id = "customer.address.state")
    WebElement state;

    @FindBy(id = "customer.address.zipCode")
    WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    WebElement phone;

    @FindBy(xpath = "//input[@value='Update Profile']")
    WebElement updateBtn;

    @FindBy(xpath = "//h1[contains(text(),'Profile Updated')]")
    WebElement successMessage;

    // Actions

    public void openUpdateProfilePage() {
        wait.until(ExpectedConditions.elementToBeClickable(updateContactLink));
        updateContactLink.click();
    }

    public void updateProfile(String fname, String lname, String addr,
                              String cityName, String stateName,
                              String zip, String phoneNo) {

        wait.until(ExpectedConditions.visibilityOf(firstName));

        firstName.clear();
        firstName.sendKeys(fname);

        lastName.clear();
        lastName.sendKeys(lname);

        address.clear();
        address.sendKeys(addr);

        city.clear();
        city.sendKeys(cityName);

        state.clear();
        state.sendKeys(stateName);

        zipCode.clear();
        zipCode.sendKeys(zip);

        phone.clear();
        phone.sendKeys(phoneNo);

        updateBtn.click();
    }

    public boolean isProfileUpdated() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return successMessage.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}