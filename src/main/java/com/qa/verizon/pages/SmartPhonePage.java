package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.AppConstants;
import com.qa.verizon.util.ElementUtil;
import com.qa.verizon.util.JavaScriptUtil;

public class SmartPhonePage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// Locators
	By HeaderSmartPhones = By.xpath("//h1[contains(text(),'All Smartphones')]");
	By AppleXR = By.xpath("//span[text()='iPhone® XR']");

	public SmartPhonePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.SMARTPHONE_TITLE);
		return elementUtil.doGetPageTitle();
	}

	public String getPageHeader() {
		elementUtil.waitForElementPresent(HeaderSmartPhones);
		return elementUtil.doGetText(HeaderSmartPhones);
	}

	public SelectedPhonePage doClickAppleXR() {
		elementUtil.doClick(AppleXR);
		return new SelectedPhonePage(driver);

	}

}
