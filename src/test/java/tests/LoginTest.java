package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.DriverInfo;

public class LoginTest extends DriverInfo {
	WebDriver driver;
	ITestResult result = null;
	private static final Logger log = Logger.getLogger(LoginTest.class);
	LoginPage lp = new LoginPage(DriverInfo.driver);

	@Test(priority = 0, description = "Login details")
	public void login() throws Exception {

		test = extent.createTest("Login Test", "Login details");

		lp.clickOnHomeLink();
		String expectedTitle = "Welcome";
		Assert.assertTrue(DriverInfo.driver.getTitle().contains(expectedTitle));
		getScreenshot(DriverInfo.driver, "Title");
		lp.setUserName("java");
		getScreenshot(DriverInfo.driver, "Username");
		lp.setPwd("java");
		getScreenshot(DriverInfo.driver, "Pwd");
		lp.clickOnSignInLink();
		getScreenshot(DriverInfo.driver, "After clicking signin");
		log.info("Login successfull");
	}

	@Test(enabled = false, priority = 1, description = "Finding Flights")
	public void findFlights() {
		test = extent.createTest("Login Test", "Login details");
	}

}