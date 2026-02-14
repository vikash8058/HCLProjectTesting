package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ==========================
    // ======= NAVIGATION =======
    // ==========================

    public void openLoginPage() {
        driver.get("https://automationexercise.com/login");
    }

    // ==========================
    // ======= LOCATORS =========
    // ==========================

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(text(),'incorrect')]")
    private WebElement loginErrorMessage;

    // More stable logout locator
    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    private WebElement loggedInAsText;

    // ==========================
    // ======= ACTIONS ==========
    // ==========================

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginEmail)).clear();
        loginEmail.sendKeys(email);

        loginPassword.clear();
        loginPassword.sendKeys(password);

        loginButton.click();
    }

    public boolean isUserLoggedIn() {
        wait.until(ExpectedConditions.visibilityOf(loggedInAsText));
        return loggedInAsText.isDisplayed();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    public String getLoginErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        return loginErrorMessage.getText();
    }
}
