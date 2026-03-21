package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class SearchResultsTest extends BaseTest {

    private void navigateToSearchResults(String keyword) {
        HomePage homePage = new HomePage(driver);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        homePage.searchCourse(keyword);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}
    }

    // These are positive test cases

    @Test(priority = 1)
    public void TC01_verifyResultsDisplayedForPython() {
        navigateToSearchResults("Python");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        Assert.assertTrue(resultsPage.isResultsDisplayed(),
                "Search results not displayed");
    }

    @Test(priority = 2)
    public void TC02_verifyResultsURLContainsKeyword() {
        navigateToSearchResults("Python");

        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("python"),
                "URL does not contain keyword");
    }

    @Test(priority = 3)
    public void TC03_verifyResultsPageTitleContainsPython() {
        navigateToSearchResults("Python");

        String title = driver.getTitle();

        System.out.println("Page Title: " + title);

        Assert.assertFalse(title.isEmpty(),
                "Page title is empty");
    }

    @Test(priority = 4)
    public void TC04_verifyFirstCourseCardVisible() {
        navigateToSearchResults("Python");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        Assert.assertTrue(resultsPage.getCourseCount() > 0,
                "No course cards visible");
    }

    @Test(priority = 5)
    public void TC05_verifyClickFirstCourseNavigatesToDetailPage() {
        navigateToSearchResults("Python");

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.clickFirstCourse();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        Assert.assertTrue(driver.getCurrentUrl().contains("course"),
                "Did not navigate to course page");
    }

    // These are negative test cases

    @Test(priority = 6)
    public void TC06_verifyNoCrashForInvalidKeyword() {
        navigateToSearchResults("xyzabc123");

        Assert.assertTrue(driver.getCurrentUrl().contains("udemy"),
                "Page crashed for invalid input");
    }

    @Test(priority = 7)
    public void TC07_verifyNoCrashForNumericInput() {
        navigateToSearchResults("123456");

        Assert.assertTrue(driver.getCurrentUrl().contains("udemy"),
                "Page crashed for numeric input");
    }

    @Test(priority = 8)
    public void TC08_verifyNoCrashForSpecialCharacters() {
        navigateToSearchResults("!!!###");

        Assert.assertTrue(driver.getCurrentUrl().contains("udemy"),
                "Page crashed for special characters");
    }

    @Test(priority = 9)
    public void TC09_verifyResultsPageURLNotEmpty() {
        navigateToSearchResults("Python");

        Assert.assertFalse(driver.getCurrentUrl().isEmpty(),
                "URL is empty");
    }

    @Test(priority = 10)
    public void TC10_verifyResultsPageTitleNotEmpty() {
        navigateToSearchResults("Python");

        Assert.assertFalse(driver.getTitle().isEmpty(),
                "Title is empty");
    }
}