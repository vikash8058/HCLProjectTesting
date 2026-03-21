package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtil;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'course-list--container')]")
    private WebElement resultsContainer;

    @FindBy(xpath = "(//a[contains(@href,'/course/')])[1]")
    private WebElement firstCourseCard;

    @FindBy(xpath = "//button[contains(text(),'Ratings')]")
    private WebElement ratingsFilterButton;

    @FindBy(xpath = "//span[contains(@class,'no-results')]")
    private WebElement noResultsMessage;

    public boolean isResultsDisplayed() {
        try {
            WaitUtil.waitForElementVisible(driver, resultsContainer);
            return resultsContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void applyRatingsFilter() {
        try {
            WaitUtil.waitForElementClickable(driver, ratingsFilterButton);
            ratingsFilterButton.click();
        } catch (Exception e) {
            // if filter not available, continue
        }
    }

    public void clickFirstCourse() {
        WaitUtil.waitForElementClickable(driver, firstCourseCard);
        firstCourseCard.click();
    }

    public boolean isNoResultsMessageDisplayed() {
        try {
            return noResultsMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}