package pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.BasePage;

public class RegisterPage extends BasePage {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id=\"navbarSupportedContent\"]/form/button[4]")
	WebElement SIGNIN;

	@FindBy(how = How.CSS, using = "body > app-root > bmf-layout > div:nth-child(2) > app-login > div > div > div.row > div.col-md-4 > h3 > div > div:nth-child(2) > button")
	WebElement CREATEYOURACCOUNT;

	@FindBy(how = How.ID, using = "name")
	WebElement NAME;

	@FindBy(how = How.ID, using = "mobileNo")
	WebElement MOBILENO;

	@FindBy(how = How.CSS, using = "div.sign-up-main > div >form > div:nth-child(3) >input")
	WebElement EMAILID;

	@FindBy(how = How.CSS, using = "div.sign-up-main >div> form > div:nth-child(4) >div >input")
	WebElement PWD;

	@FindBy(how = How.CSS, using = "div.sign-up-main >div> form > div:nth-child(5) >div:nth-child(1) >button.btn-primary")
	WebElement REGISTER;

	@FindBy(how = How.CSS, using = "body > app-root > bmf-layout > div:nth-child(2) > app-login > div > p-sidebar > div > app-signup > div > div > form > div.row > div:nth-child(2) > button")
	WebElement CLEAR;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnSignIn() {
		clickOnElement(SIGNIN);
	}

	public void clickOnCreateAccount() {
		clickOnElement(CREATEYOURACCOUNT);
	}

	public void sendTextToName(String name) {
		sendText(NAME, name);
	}

	public void sendTextToMOBILENO(String mobno) {
		sendText(MOBILENO, mobno);
	}

	public void sendTextToEmailId(String emailid) {
		sendText(EMAILID, emailid);
	}

	public void sendTextToPassword(String pwd) {
		sendText(PWD, pwd);
		PWD.sendKeys(Keys.TAB);
	}

	public void clickOnRegister() {
		clickOnElement(REGISTER);
	}
}
