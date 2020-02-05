package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import pages.RegisterPage;
import utils.DriverInfo;

public class RegisterTest extends DriverInfo{
	WebDriver driver;
	ITestResult result = null;
	private static final Logger log = Logger.getLogger(RegisterTest.class);

	@Test(priority = 0, description = "Registering details")
	public void register() throws Exception {
		RegisterPage rp = new RegisterPage(DriverInfo.driver);
		test = extent.createTest("Register Test","Registering details");
		rp.clickOnSignIn();
		rp.clickOnCreateAccount();
		getScreenshot(DriverInfo.driver, "Title");
		rp.sendTextToName(properties.getProperty("name"));
		getScreenshot(DriverInfo.driver, "Entered name");
		rp.sendTextToMOBILENO(properties.getProperty("mobno"));
		rp.sendTextToEmailId(properties.getProperty("email"));
		rp.sendTextToPassword(properties.getProperty("pwd"));
		log.info("Registration successfull");
	}

}