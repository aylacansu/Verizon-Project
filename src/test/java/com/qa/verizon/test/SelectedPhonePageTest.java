package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.MainPage;
import com.qa.verizon.pages.SelectedPhonePage;
import com.qa.verizon.pages.SmartPhonePage;
import com.qa.verizon.util.AppConstants;

public class SelectedPhonePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	SmartPhonePage smartPhonePage;
	SelectedPhonePage selectedPhonePage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage = new MainPage(driver);
		smartPhonePage = mainPage.doClickSmartPhone();
		selectedPhonePage = smartPhonePage.doClickAppleXR();
		Thread.sleep(5000);

	}

	@Test(priority = 1)
	public void verifyGetPageTitleTest() {
		String title = selectedPhonePage.getTitlePage();
		System.out.println("SelectedPhonePage Title is:" + title);
		Assert.assertEquals(title, AppConstants.SELECTEDPHONEPAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifyGetPageHeaderTest() {
		String title = selectedPhonePage.getPageHeader();
		System.out.println("SelectedPhonePage Header is:" + title);
		Assert.assertEquals(title, AppConstants.SELECTEDPHONEPAGE_HEADER);
	}

	@Test(priority = 3)
	public void verifdoClickFeaturesTest() {
		selectedPhonePage.doClickFeatures();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
