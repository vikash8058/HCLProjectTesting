package listeners;

import base.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		ExtentReportManager.createReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportManager.createTest(result.getName());
		ExtentReportManager.getTest().info("Test Started : " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReportManager.getTest().pass("Test Passed : " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReportManager.getTest().fail("Test Failed : " + result.getName());
		ExtentReportManager.getTest().fail(result.getThrowable());
		String screenshotPath = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), result.getName());
		if (screenshotPath != null) {
			ExtentReportManager.getTest().addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentReportManager.getTest().skip("Test Skipped : " + result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportManager.flushReport();
	}
}