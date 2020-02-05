package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BasePage {
	
	public static final Logger log = Logger.getLogger(BasePage.class);
	private static long DEFAULT_TIMEOUT = 30;
	
	/**
	 * Method for wait
	 * @param element
	 */
	public void waitForElement(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverInfo.driver, DEFAULT_TIMEOUT);
			wait.until(ExpectedConditions.visibilityOf(element));
			moveToElement(element);
		} catch (Exception e) {
			log.info("Element not found");
		}
	}
	
	/**
	 * Method for clicking on element
	 * @param element
	 */
	public void clickOnElement(WebElement element) {
		try {
			waitForElement(element);
			element.click();
		} catch (Exception e) {
			log.info("Click is not working");
		}
	}
	
	/**
	 * Method for entering text using sendkeys
	 * @param element
	 * @param text
	 */
	public void sendText(WebElement element, String text) {
		waitForElement(element);
		element.sendKeys(text);
	}
	
	/**
	 * selecting drop down by VisibleText
	 * @param element
	 * @param text
	 */
	public void selectDropDownByVisibleText(WebElement element, String text) {
		waitForElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	/**
	 * selectMultipleSelectDropDownByVisibleText
	 * @param element
	 * @param text1
	 * @param text2
	 */
	public void selectMultipleSelectDropDownByVisibleText(WebElement element, String text1, String text2) {
		waitForElement(element);
		Select select = new Select(element);
		if (select.isMultiple()) {
			select.selectByVisibleText(text1);
			select.selectByVisibleText(text2);
		} else {
			log.info("Its not a multiple select drop down");
		}
	}
	
	/**
	 * verifyElementSelected
	 * @param element
	 * @return
	 */
	public String verifyElementSelected(WebElement element) {
		String value;
    	if(element.isSelected()) {
    		value= element.getAttribute("value");
    		log.info("Value is " + element.getAttribute("value"));
    	}else {
    		value= element.getAttribute("value");
    		log.info("Value is " + element.getAttribute("value"));
    	}
		return value;
    }	
	
	/**
	 * moveToElement
	 * @param element
	 */
	public void moveToElement(WebElement element) {
		waitForElement(element);
		Actions acs = new Actions(DriverInfo.driver);
		acs.moveToElement(element);
		log.info("moved to element");
	}
	
	/**
	 * Setting URL and headers for service 
	 * 
	 * @param basepath
	 * @return
	 */
	public static RequestSpecification setBaseURI(String basepath) {
		RequestSpecification request = RestAssured.given();
		request.baseUri("http://okmry52647dns.eastus.cloudapp.azure.com:8089/rest/api/");
		request.header("Content-Type","application/json");
		request.basePath(basepath);
		return request;
	}

}
