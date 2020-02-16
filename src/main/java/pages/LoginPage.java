package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;

	@FindBy(how = How.CSS, using = "div.login-main > p-sidebar > div> span > button")
	WebElement closeBtnRegisterPopup;

	@FindBy(how = How.CSS, using = "div.login-main > div >div > div>form>div> input")
	WebElement emailId;

	@FindBy(how = How.CSS, using = "div.login-main > div >div > div>form>div:nth-child(2)> div >input")
	WebElement pwd;

	@FindBy(how = How.CSS, using = "div.login-main > div >div > div>form>div:nth-child(3)> div >button.btn-primary")
	WebElement signIn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setEmailId(String strEmail) {
		sendText(emailId, strEmail);
	}

	public void setPwd(String passwd) {
		sendText(pwd, passwd);
	}

	public void clickOnSignInLink() {
		clickOnElement(signIn);
	}

	public void clickOnCloseBtnRegisterPopup() {
		clickOnElement(closeBtnRegisterPopup);
	}

}
