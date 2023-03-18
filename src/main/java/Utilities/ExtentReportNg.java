package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {

	public static ExtentReports getExtentReport() {

		ExtentSparkReporter report = new ExtentSparkReporter("extentReport.html");
		report.config().setDocumentTitle("AmazonReport");
		report.config().setReportName("AmazonResults");
		// Creating Extent Reports and attaching reporter
		ExtentReports extent = new ExtentReports();
		extent.setSystemInfo("TesterName", "Rakesh A S");
		extent.attachReporter(report);
		return extent; // Here returning object and making static class as we can access it through
						// class name in listeners class

		/*
		 * First need to create ExtentSparkReporter instance by passing the location of
		 * reports Then Create the ExtentReports instance and attach the file path reporter
		 * create a object for create test ExtentTest
		 * test=extent.create("Test case execution");
		 * 
		 * extent.flush(); --> Appends the HTML file with all the ended tests
		 */

	}

}
