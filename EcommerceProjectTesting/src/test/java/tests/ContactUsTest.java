package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

	@Test
	public void verifyContactUsFormSubmission() {

		ContactUsPage contactPage = new ContactUsPage(driver);

		contactPage.clickContactUs();

		contactPage.fillContactForm("Test User", "testuser@gmail.com", "Test Subject", "This is a test message.");

		contactPage.uploadFile("D:\\HCL_Projects\\EcommerceProjectTesting\\test-data\\sample.txt");

		contactPage.submitForm();

		driver.switchTo().alert().accept();

		Assert.assertTrue(contactPage.isSuccessMessageDisplayed(), "Contact form submission failed");
	}

	@Test
	public void verifyContactUsPageLoads() {

		ContactUsPage contactPage = new ContactUsPage(driver);

		contactPage.clickContactUs();

		Assert.assertTrue(contactPage.isContactPageLoaded(), "Contact Us page did not load properly");
	}

	@Test
	public void verifyFormSubmissionWithoutData() {

		ContactUsPage contactPage = new ContactUsPage(driver);

		contactPage.clickContactUs();

		contactPage.submitForm();

		// Since required fields missing, success message should NOT appear
		Assert.assertFalse(contactPage.isSuccessMessageDisplayed(), "Form should not submit with empty fields");
	}

	@Test
	public void verifyInvalidEmailFormat() {

		ContactUsPage contactPage = new ContactUsPage(driver);

		contactPage.clickContactUs();

		contactPage.fillContactForm("Test User", "invalidemail", // wrong format
				"Test Subject", "Message");

		contactPage.submitForm();

		Assert.assertFalse(contactPage.isSuccessMessageDisplayed(), "Form should not accept invalid email");
	}

	@Test
	public void verifyFileUploadFieldEnabled() {

		ContactUsPage contactPage = new ContactUsPage(driver);

		contactPage.clickContactUs();

		Assert.assertTrue(contactPage.isUploadFieldEnabled(), "Upload field is not enabled");
	}

}
