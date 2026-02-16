package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Contact us')]")
	private WebElement contactUsLink;

	@FindBy(name = "name")
	private WebElement nameField;

	@FindBy(name = "email")
	private WebElement emailField;

	@FindBy(name = "subject")
	private WebElement subjectField;

	@FindBy(name = "message")
	private WebElement messageField;

	@FindBy(name = "upload_file")
	private WebElement uploadFile;

	@FindBy(name = "submit")
	private WebElement submitButton;

	@FindBy(xpath = "//div[@class='status alert alert-success']")
	private WebElement successMessage;

	@FindBy(xpath = "//h2[contains(text(),'Get In Touch')]")
	private WebElement getInTouchTitle;
	
	public boolean isContactPageLoaded() {
	    return getInTouchTitle.isDisplayed();
	}
	
	public void clickContactUs() {
		contactUsLink.click();
	}

	public boolean isUploadFieldEnabled() {
	    return uploadFile.isEnabled();
	}

	
	public void fillContactForm(String name, String email, String subject, String message) {

		nameField.sendKeys(name);
		emailField.sendKeys(email);
		subjectField.sendKeys(subject);
		messageField.sendKeys(message);
	}

	public void uploadFile(String filePath) {
		uploadFile.sendKeys(filePath);
	}

	public void submitForm() {
		submitButton.click();
	}

	public boolean isSuccessMessageDisplayed() {
		return successMessage.isDisplayed();
	}
}
