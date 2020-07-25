package com.qa.verizon.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.AppConstants;
import com.qa.verizon.util.ElementUtil;
import com.qa.verizon.util.JavaScriptUtil;

public class SelectedPhonePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	Properties prop;
	

	// Locators

	By SelectedPageHeader = By.xpath("//span[text()='Apple iPhone® XR']");
	By Yellow = By.xpath("//label[text()='Yellow']");
	By GB = By.xpath("//p[text()='128GB']");
	By Price = By.xpath("//span[text()='$649.99']");
	By Continue = By.xpath("//button[@id='ATC-Btn']");
	By zipcode = By.xpath("//input[@id='zipcode']");
	By confirmLocation = By.xpath("//button[text()='Confirm Location']");
	By newCustomer = By.xpath("//button[text()='New Customer']");

	public SelectedPhonePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getTitlePage() {
		elementUtil.waitForTitlePresent(AppConstants.SELECTEDPHONEPAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}

	public String getPageHeader() {
		elementUtil.waitForElementPresent(SelectedPageHeader);
		return elementUtil.doGetText(SelectedPageHeader);
	}

	public CardPage doClickFeatures() {
		elementUtil.waitForElementPresent(Yellow);
		elementUtil.doClick(Yellow);
		elementUtil.waitForElementPresent(GB);
		elementUtil.doClick(GB);
		elementUtil.waitForElementPresent(Price);
		elementUtil.doClick(Price);
		elementUtil.waitForElementPresent(Continue);
		elementUtil.doClick(Continue);
//		WebElement element=driver.findElement(zipcode);
//		element.clear();
	    elementUtil.doClick(zipcode);
		elementUtil.doSendKeys(zipcode,AppConstants.ZIPCODE);
		elementUtil.doClick(confirmLocation);
		elementUtil.doClick(newCustomer);
		return new CardPage(driver);
	}

}
