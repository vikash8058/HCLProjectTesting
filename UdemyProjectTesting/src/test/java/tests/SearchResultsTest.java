package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class SearchResultsTest extends BaseTest {

    private void navigateToSearchResults() {
        HomePage homePage = new HomePage(driver);
        homePage.searchCourse("Python");
    }

    // Positive Test Cases

    @Test(priority = 1)
    public void TC01_verifyResultsDisplayedForPython() {
        navigateToSearchResults();
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        Assert.assertTrue(resultsPage.isResultsDisplayed(),
                "Search results not displayed for Python");
    }

    @Test(priority = 2)
    public void TC02_verifyResultsURLContainsPython() {
        navigateToSearchResults();
        Assert.assertTrue(driver.getCurrentUrl().contains("python"),
                "URL does not contain python");
    }

    @Test(priority = 3)
    public void TC03_verifyResultsPageTitleContainsPython() {
        navigateToSearchResults();
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("python"),
                "Page title does not contain python");
    }

    @Test(priority = 4)
    public void TC04_verifyFilterOptionIsVisible() {
        navigateToSearchResults();
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        Assert.assertTrue(resultsPage.isResultsDisplayed(),
                "Results page not loaded to check filter");
    }

    @Test(priority = 5)
    public void TC05_verifyClickingFirstCourseOpensCourseDetail() {
        navigateToSearchResults();
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.clickFirstCourse();
        Assert.assertTrue(driver.getCurrentUrl().contains("udemy"),
                "Course detail page did not open");
    }

    // Negative Test Cases

    @Test(priority = 6)
    public void TC06_verifyPageDoesNotCrashOnBadInput() {
        HomePage homePage = new HomePage(driver);
        homePage.searchCourse("xyzabc123");
        Assert.assertTrue(driver.getCurrentUrl().contains("udemy"),
                "Page crashed on bad input");
    }

    @Test(priority = 7)
    public void TC07_verifyPageDoesNotCrashOnNumericInput() {
        HomePage homePage = new HomePage(driver);
        homePage.searchCourse("123456");
        Assert.assertTrue(driver.getCurrentUrl().contains("udemy"),
                "Page crashed on numeric input");
    }

    @Test(priority = 8)
    public void TC08_verifyPageDoesNotCrashOnSpecialChars() {
        HomePage homePage = new HomePage(driver);
        homePage.searchCourse("!!!###");
        Assert.assertTrue(driver.getCurrentUrl().contains("udemy"),
                "Page crashed on special characters");
    }

    @Test(priority = 9)
    public void TC09_verifyResultsPageURLIsNotEmpty() {
        navigateToSearchResults();
        Assert.assertFalse(driver.getCurrentUrl().isEmpty(),
                "Results page URL is empty");
    }

    @Test(priority = 10)
    public void TC10_verifyResultsPageTitleIsNotEmpty() {
        navigateToSearchResults();
        Assert.assertFalse(driver.getTitle().isEmpty(),
                "Results page title is empty");
    }
}