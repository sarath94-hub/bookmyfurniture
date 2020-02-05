package pages;

import org.openqa.selenium.By.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.BasePage;

public class RegisterPage extends BasePage {
	WebDriver driver;

	@FindBy(how = How.CSS, using = "#navbarSupportedContent > form > button.mat-button.mat-button-base.ng-star-inserted")
	WebElement SIGNIN;

	@FindBy(how = How.CSS, using = "body > app-root > bmf-layout > div:nth-child(2) > app-login > div > div > div.row > div.col-md-4 > h3 > div > div:nth-child(2) > button")
	WebElement CREATEYOURACCOUNT;

	@FindBy(how = How.ID, using = "name")
	WebElement NAME;

	@FindBy(how = How.ID, using = "mobileNo")
	WebElement MOBILENO;

	@FindBy(how = How.ID, using = "emailId")
	WebElement EMAILID;

	@FindBy(how = How.ID, using = "password")
	WebElement PWD;

	@FindBy(how = How.CSS, using = "body > app-root > bmf-layout > div:nth-child(2) > app-login > div > p-sidebar > div > app-signup > div > div > form > div.row > div:nth-child(1) > button")
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
	}

	public void clickOnRegister() {
		clickOnElement(REGISTER);
	}
}
