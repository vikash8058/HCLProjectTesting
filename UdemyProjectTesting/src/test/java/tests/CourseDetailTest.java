package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CourseDetailPage;
import pages.HomePage;
import pages.SearchResultsPage;

public class CourseDetailTest extends BaseTest {

	private void navigateToCourseDetail() {
		HomePage homePage = new HomePage(driver);
		homePage.searchCourse("Python");
		SearchResultsPage resultsPage = new SearchResultsPage(driver);
		resultsPage.clickFirstCourse();
	}

	// Positive Test Cases

	@Test(priority = 1)
	public void TC01_verifyCourseDetailPageIsDisplayed() {
		navigateToCourseDetail();
		CourseDetailPage coursePage = new CourseDetailPage(driver);
		Assert.assertTrue(coursePage.isCoursePageDisplayed(), "Course detail page is not displayed");
	}

	@Test(priority = 2)
	public void TC02_verifyCourseTitleIsDisplayed() {
		navigateToCourseDetail();
		CourseDetailPage coursePage = new CourseDetailPage(driver);
		String title = coursePage.getCourseTitle();
		Assert.assertFalse(title.isEmpty(), "Course title is empty");
	}

	@Test(priority = 3)
	public void TC03_verifyCourseTitleIsNotNull() {
		navigateToCourseDetail();
		CourseDetailPage coursePage = new CourseDetailPage(driver);
		String title = coursePage.getCourseTitle();
		Assert.assertNotNull(title, "Course title is null");
	}

	@Test(priority = 4)
	public void TC04_verifyCourseRatingIsDisplayed() {
		navigateToCourseDetail();
		CourseDetailPage coursePage = new CourseDetailPage(driver);
		String rating = coursePage.getCourseRating();
		Assert.assertFalse(rating.isEmpty(), "Course rating is empty");
	}

	@Test(priority = 5)
	public void TC05_verifyInstructorNameIsDisplayed() {
		navigateToCourseDetail();
		CourseDetailPage coursePage = new CourseDetailPage(driver);
		String instructor = coursePage.getInstructorName();
		Assert.assertFalse(instructor.isEmpty(), "Instructor name is empty");
	}

	// Negative Test Cases

	@Test(priority = 6)
	public void TC06_verifyCoursePageURLIsNotEmpty() {
		navigateToCourseDetail();
		Assert.assertFalse(driver.getCurrentUrl().isEmpty(), "Course page URL is empty");
	}

	@Test(priority = 7)
	public void TC07_verifyCoursePageTitleIsNotEmpty() {
		navigateToCourseDetail();
		Assert.assertFalse(driver.getTitle().isEmpty(), "Course page title is empty");
	}

	@Test(priority = 8)
	public void TC08_verifyCoursePageURLContainsUdemy() {
		navigateToCourseDetail();
		Assert.assertTrue(driver.getCurrentUrl().contains("udemy"), "Course page URL does not contain udemy");
	}

	@Test(priority = 9)
	public void TC09_verifyCourseRatingIsNotNull() {
		navigateToCourseDetail();
		CourseDetailPage coursePage = new CourseDetailPage(driver);
		String rating = coursePage.getCourseRating();
		Assert.assertNotNull(rating, "Course rating is null");
	}

	@Test(priority = 10)
	public void TC10_verifyInstructorNameIsNotNull() {
		navigateToCourseDetail();
		CourseDetailPage coursePage = new CourseDetailPage(driver);
		String instructor = coursePage.getInstructorName();
		Assert.assertNotNull(instructor, "Instructor name is null");
	}

}
