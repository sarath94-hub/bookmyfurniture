package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;

	   @FindBy(how = How.LINK_TEXT, using = "Home")
	    WebElement home;
	   
	@FindBy(how = How.NAME, using = "userName")
	WebElement userName;

	@FindBy(how = How.NAME, using = "password")
	WebElement password;

	@FindBy(how = How.NAME, using = "login")
	WebElement signIn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String strUserName) {
		sendText(userName, strUserName);
	}

	public void setPwd(String pwd) {
		sendText(password, pwd);
	}

	public void clickOnSignInLink() {
		clickOnElement(signIn);
	}
	
	public void clickOnHomeLink() {
		clickOnElement(home);
	}

}
