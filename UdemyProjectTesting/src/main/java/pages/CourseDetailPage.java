package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtil;

public class CourseDetailPage extends BasePage {

	public CourseDetailPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[@class='course-lede-module-scss-module__D37FTG__title ud-heading-xxl']")
	  private WebElement courseTitle;

	@FindBy(xpath = "//span[@class='ud-heading-xl'][normalize-space()='4.7']")
	private WebElement courseRating;

	@FindBy(xpath = "//span[normalize-space()='Dr. Angela Yu, Developer and Lead Instructor']")
	private WebElement instructorName;

	public boolean isCoursePageDisplayed() {
		try {
			WaitUtil.waitForElementVisible(driver, courseTitle);
			return courseTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getCourseTitle() {
		WaitUtil.waitForElementVisible(driver, courseTitle);
		return courseTitle.getText();
	}

	public String getCourseRating() {
		try {
			WaitUtil.waitForElementVisible(driver, courseRating);
			return courseRating.getText();
		} catch (Exception e) {
			return "";
		}
	}

	public String getInstructorName() {
		try {
			WaitUtil.waitForElementVisible(driver, instructorName);
			return instructorName.getText();
		} catch(Exception e) {
			return "";
		}
	}
}
