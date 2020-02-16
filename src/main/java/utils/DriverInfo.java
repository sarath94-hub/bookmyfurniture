package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import services.AuthTokenData;
import services.SignInData;

public class DriverInfo {

	public static WebDriver driver = null;
	static ExtentHtmlReporter htmlReporter;
	public ExtentTest test;
	public ExtentReports extent;
	public Properties properties;
	private static final Logger log = Logger.getLogger(DriverInfo.class);

	@BeforeSuite(alwaysRun=true)
	public void initialize() throws IOException {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\extentReport\\testReport.html");
		extent = new ExtentReports();
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "\\extentReport\\extentConfig.xml");
		extent.attachReporter(htmlReporter);
	}

	@BeforeSuite(alwaysRun=true)
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.manage().window().maximize();
		properties = PropertyFileReader.getProperty("\\src\\main\\resources\\", "data.properties");
		driver.get(properties.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info(browser + "Browser launched");
	}

	@AfterMethod(alwaysRun=true)
	public void getResult(ITestResult result) throws Exception {
		String screenshotPath;
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed is " + result.getName());
			screenshotPath = getScreenshot(driver, result.getName());
			test.fail("Attached Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skipped is " + result.getName());
			screenshotPath = getScreenshot(driver, result.getName());
			test.skip("Attached Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed is " + result.getName());
			screenshotPath = getScreenshot(driver, result.getName());
			test.pass("Attached Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
	}
	
	public void appendReqAndResToExtentReport(String res) {
		test.log(Status.INFO, "<pre>" + res + "</pre>");
	}

	public String getScreenshot(WebDriver driver, String screenshotName) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/TestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
			test.log(Status.INFO, screenshotName, MediaEntityBuilder.createScreenCaptureFromPath(destination).build());
		} catch (IOException e) {
			log.info("Capture Failed " + e.getMessage());
		}
		return destination;
	}

	@AfterSuite(alwaysRun=true)
	public void TeardownTest() {
		extent.flush();
		driver.quit();
	}

}
