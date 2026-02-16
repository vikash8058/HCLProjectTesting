package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Subscription section
	@FindBy(id = "susbscribe_email")
	private WebElement subscriptionEmailField;

	@FindBy(id = "subscribe")
	private WebElement subscribeButton;

	@FindBy(xpath = "//div[@class='alert-success alert']")
	private WebElement subscriptionSuccessMessage;

	// Scroll up button
	@FindBy(id = "scrollUp")
	private WebElement scrollUpButton;

	@FindBy(xpath = "//div[@class='logo pull-left']")
	private WebElement topLogo;
	
	@FindBy(xpath = "//div[@class='logo pull-left']")
	private WebElement logo;

	@FindBy(xpath = "//div[@class='left-sidebar']")
	private WebElement categorySection;
	
	@FindBy(xpath = "//h2[contains(text(),'Features Items')]")
	private WebElement featuredItemsTitle;
	
	@FindBy(xpath = "//footer")
	private WebElement footer;

	
	//methods
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}

	public boolean isFeaturedItemsVisible() {
	    return featuredItemsTitle.isDisplayed();
	}
	
	public boolean isFooterVisible() {
	    return footer.isDisplayed();
	}
	
	public void scrollToFooter() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void clickScrollUp() {
		scrollUpButton.click();
	}

	public boolean isTopLogoVisible() {
		return topLogo.isDisplayed();
	}
	
	public boolean isCategorySectionDisplayed() {
	    return categorySection.isDisplayed();
	}
}
