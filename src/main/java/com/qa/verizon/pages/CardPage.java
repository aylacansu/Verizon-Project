package com.qa.verizon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.util.AppConstants;
import com.qa.verizon.util.ElementUtil;

public class CardPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// Locators

	By CardPageHeader = By.xpath("//p[@id='mainDeviceHeader']");
	By phoneName = By.xpath("// span[contains(text(),'iPhone® XR')]");

	public CardPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getTitlePage() {
		elementUtil.waitForTitlePresent(AppConstants.CARDPAGE_TITLE);
		return elementUtil.doGetPageTitle();
	}

	public String getPageHeader() {
		elementUtil.waitForElementPresent(CardPageHeader);
		return elementUtil.doGetText(CardPageHeader);
	}

	public String getPhoneNameText() {
		elementUtil.waitForElementVisible(phoneName);
		return elementUtil.doGetText(phoneName);

	}

}
