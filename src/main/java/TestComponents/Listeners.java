package TestComponents;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReportNg;

public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReportNg.getExtentReport(); // initializing by calling getExtentReport method from
																// ExtentReportNg class
	ExtentTest test;
	// ThreadLocal will need when we running the class parallely.
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	// need it when we running class parallely 
		//we have two method set() and get()
		extentTest.set(test); // Will generate unique Thread Id for all methods -> Test
		test.info("Test case execution starts");

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Testcase is passed");
	}

	public void onTestFailure(ITestResult result) {
		//extentTest.get() -> Returns current thread value
		extentTest.get().fail(result.getThrowable());
		String filepath = null;
		try {
			filepath = getScreenshot(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
