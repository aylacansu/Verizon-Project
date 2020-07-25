package com.qa.verizon.util;

import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.verizon.base.BasePage;

public class ElementUtil extends BasePage {

	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil jsUtil;
	Properties properties;

	// Constructor

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		 wait=new WebDriverWait(driver,AppConstants.DEFAULT_TIMEOUT );
		 jsUtil=new JavaScriptUtil(driver);
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			 if(waitForElementPresent(locator));
			element = driver.findElement(locator);
			 if(highlightElement){
			 jsUtil.flash(element);
			 }
		} catch (Exception e) {
			System.out.println("Some exception occured while creating the Web Element");
		}

		return element;
	}

	
	/**
	 * @author ic
	 * GetTitle Method
	 * @return
	 */

	public String doGetPageTitle(){
     try {
		return driver.getTitle();
	} catch (Exception e) {
		System.out.println("some exception got occured while getting the title");
	}
	return null;
	}
	
	
	/**
	 * Wait For Element
	 * 
	 * @param locator
	 * @return
	 */

	public boolean waitForElementPresent(By locator) {
		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return true;

	}

	/**
	 * wait for element visible
	 * 
	 * @param locator
	 * @return
	 */
	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}

	/**
	 * Wait For Title
	 * @param title
	 * @return
	 */
	public boolean waitForTitlePresent(String title){
	wait.until(ExpectedConditions.titleIs(title));
	return true;
	}	
	/**
	 * ClickOn Method
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some exception occured while click on  webelement " + locator);
		}
	}

	/**
	 * DoSendKeys Method
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {

		try {

			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some exception occured while sending to  webelement " + locator);
		}
	}
	
	/**
	 * getText	
	 * @param locator
	 * @return
	 */
	public String doGetText(By locator) {
		try {
			return getElement(locator).getText();

		} catch (Exception e) {
			System.out.println("Some exception occured while getting Text");
		}
		return null;

	}

	public String waitForGetPageTitle(String title) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	/**
	 * IsDisplayed
	 * @param locator
	 * @return
	 */
	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Some exception occured while checking webelement displayed " + locator);
			return false;
		}
	}

	/**
	 * IsEnabled
	 * @param locator
	 * @return
	 */
	public boolean  doIsEnabled(By locator){
	try {
		return getElement(locator).isEnabled();
	} catch (Exception e) {
		System.out.println("Some exception occured while isEnabled");	
	}	
		
	return false;	
	}


	/**
	 * IsSelected
	 * @param locator
	 * @return
	 */
	public boolean  doIsSelected(By locator){
	try {
		return getElement(locator).isSelected();
	} catch (Exception e) {
		System.out.println("Some exception occured while isSelected");	
	}	
		
	return false;	
	}
	
	/**
	 * move Element
	 * @param locator
	 */
	public void moveToElement(By locator) {
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	/**
	 * This method is used to handle alert.
	 * 
	 * @param driver
	 * @return
	 */
	public static void getAlertText(WebDriver driver,String text) {
		Alert alert = driver.switchTo().alert();
		//String text = alert.getText();
		//System.out.println(text);
		alert.sendKeys(text);
		//return text;

	}
}
