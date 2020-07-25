package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.AppConstants;
import com.qa.verizon.util.ElementUtil;
import com.qa.verizon.util.JavaScriptUtil;

public class MainPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;
	

	// Locators

	By Phones = By.xpath("//button[text()='Phones list']");
	By SmartPhones = By.xpath("//a[@id='thirdLevel00']");
	By SignUp = By.xpath("//a[@id='gnavAccountMenu']");
	By Search = By.xpath("//a[@class='search-icon']");

	// Constractor
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	// Actions
	public String getPageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.MAINPAGE_TITLE);
		return elementUtil.doGetPageTitle();

	}

	public boolean checkSignUpIsEnabled() {
		elementUtil.waitForElementVisible(SignUp);
		return elementUtil.doIsEnabled(SignUp);
	}

	public boolean checkSearchButtonIsEnabled() {
		elementUtil.waitForElementVisible(Search);
		return elementUtil.doIsEnabled(Search);
	}

	public SmartPhonePage doClickSmartPhone() {
		elementUtil.moveToElement(Phones);
		elementUtil.doClick(SmartPhones);
		return new SmartPhonePage(driver);

	}

}
