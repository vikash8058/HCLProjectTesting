package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {
   
			ExtentSparkReporter spark  = new ExtentSparkReporter("reports/ExtentReport.html ");   

			extent = new ExtentReports();
			extent.attachReporter(spark);   
		}

		return extent;
	}
}