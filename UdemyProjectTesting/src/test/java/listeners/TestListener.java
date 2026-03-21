package listeners;

import base.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentReportManager.getInstance();

	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());

		test.set(extentTest);
	}
   
	@Override
	public void onTestFailure(ITestResult result) {

		String path = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), result.getMethod().getMethodName());

		test.get().fail(result.getThrowable());
		test.get().addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSuccess(ITestResult result ) {
		test.get().pass("Test Passed");
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}