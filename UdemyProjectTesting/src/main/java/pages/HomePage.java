package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtil;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@data-testid='search-input']")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement popupCloseButton;

	@FindBy(xpath = "//div[@class='main-logo--img--B7NRR']")
	private WebElement udemyLogo;

	public void closePopupIfPresent() {
		try {
			if (popupCloseButton.isDisplayed()) {
				popupCloseButton.click();
			}
		} catch (Exception e) {
			// No popup present, continue
		}
	}

	public void searchCourse(String keyword) {
		closePopupIfPresent();
		WaitUtil.waitForElementVisible(driver, searchBox);
		searchBox.clear();
		searchBox.sendKeys(keyword);
		try {
			WaitUtil.waitForElementClickable(driver, searchButton);
			searchButton.click();
		} catch (Exception e) {
			// If search button not clickable (empty input case)
			// just continue without clicking
		}
	}

	public boolean isHomePageDisplayed() {
		try {
			WaitUtil.waitForElementVisible(driver, udemyLogo);
			return udemyLogo.isDisplayed();
		} catch (Exception e) {
			return driver.getTitle().contains("Udemy");
		}
	}
}
