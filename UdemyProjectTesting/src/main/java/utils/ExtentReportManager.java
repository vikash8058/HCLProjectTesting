package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	private static ExtentReports extent;
	private static ExtentTest test;

	public static void createReport() {
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/ExtentReport.html");
		sparkReporter.config().setDocumentTitle("HCL Hackathon");
		sparkReporter.config().setReportName("Udemy Automation Report");
		sparkReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Project", "UdemyProjectTesting");
		extent.setSystemInfo("Use Case", "Udemy Course Search");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Environment", "QA");
	}

	public static ExtentTest createTest(String testName) {
		test = extent.createTest(testName);
		return test;
	}

	public static ExtentTest getTest() {
		return test;
	}

	public static void flushReport() {
		if (extent != null) {
			extent.flush();
		}
	}
}