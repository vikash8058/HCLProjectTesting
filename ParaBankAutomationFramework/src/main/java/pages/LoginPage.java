package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement usernameField;

	@FindBy(name = "password")
	WebElement passwordField;

	@FindBy(xpath = "//input[@value='Log In']")
	WebElement loginBtn;

	@FindBy(xpath = "//p[@class='error']")
	WebElement loginErrorMsg;

	@FindBy(xpath = "//h1[contains(text(),'Accounts Overview')]")
	WebElement successLogin;

	public void login(String user, String pass) {
		usernameField.clear();
		passwordField.clear();
		usernameField.sendKeys(user);
		passwordField.sendKeys(pass);
		loginBtn.click();
	}

	public boolean isLoginSuccessful() {
		try {
			return successLogin.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isLoginErrorDisplayed() {
		try {
			return loginErrorMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isUserStillOnLoginPage() {
		return driver.getCurrentUrl().contains("index.htm");
	}

	public boolean isAccountsOverviewVisible() {
		try {
			return successLogin.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isLoginErrorVisible() {
		try {
			return loginErrorMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
