package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtil;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href,'/course/')]")
    private List<WebElement> courseList;

    @FindBy(xpath = "(//a[contains(@href,'/course/')])[1]")
    private WebElement firstCourseCard;

    @FindBy(xpath = "//button[contains(text(),'Ratings') or contains(text(),'Rating')]")
    private WebElement ratingsFilterButton;

    public boolean isResultsDisplayed() {
        try {
            WaitUtil.waitForElementVisible(driver, courseList.get(0));
            return courseList.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickFirstCourse() {
        WaitUtil.waitForElementClickable(driver, firstCourseCard);
        firstCourseCard.click();
    }
    
    public void applyRatingsFilter() {
        try {
            WaitUtil.waitForElementClickable(driver, ratingsFilterButton);
            ratingsFilterButton.click();
        } catch (Exception e) {
            System.out.println("Rating filter not available");
        }
    }

    public int getCourseCount() {
        return courseList.size();
    }
}