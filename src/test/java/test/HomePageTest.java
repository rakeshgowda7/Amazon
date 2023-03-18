package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import TestComponents.BaseTest;
import TestComponents.Retry;
import pages.HomePage;

public class HomePageTest extends BaseTest {
	HomePage homepage;
	SoftAssert sa;

	@BeforeMethod
	public void tearUp() {
		openBrowser();
		homepage = new HomePage();
		sa = new SoftAssert();
	}

	@Test
	//(retryAnalyzer = Retry.class) // need to call retryanalyzer with class if failed test case need to be executed
										// again
	public void verifySuggestionList() throws InterruptedException {
		homepage.enterTextIntoSearchBox("fast");
		Thread.sleep(5000);
		homepage.getAllSuggestions();
		Thread.sleep(2000);
		String title = driver.getTitle();
		sa.assertEquals(title, "Amazon.in : fastrack1");
		sa.assertAll();

	}

	@Test
	public void sampletest() {
		Assert.assertTrue(false);
	}

	@AfterMethod
	public void tearDown() {
		closeBrowser();
	}

}
