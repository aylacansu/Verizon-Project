package com.qa.verizon.test;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.MainPage;
import com.qa.verizon.pages.SmartPhonePage;
import com.qa.verizon.util.AppConstants;

public class SmartPhonePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	SmartPhonePage smartPhonePage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage=new MainPage(driver);
		smartPhonePage = mainPage.doClickSmartPhone();
		Thread.sleep(5000);

	}

	@Test(priority = 1, description = "SmartPhonePage Title", enabled = true)
	public void verifySmartPhonePageTitleTest() {
		String title = smartPhonePage.getPageTitle();
		System.out.println("SmartPhone Page Title is :" + title);
		Assert.assertEquals(title, AppConstants.SMARTPHONE_TITLE);

	}

	@Test(priority = 2, description = "SmartPhonePage Header", enabled = true)
	public void verifySmartPhoneHeaderTest() {
		String header = smartPhonePage.getPageHeader();
		System.out.println("SmartPhone Page Header is :"+ header);
		Assert.assertEquals(header,AppConstants.SMARTPHONE_HEADER);
	}

@Test(priority=3)
   public void doClick(){
	smartPhonePage.doClickAppleXR();
}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
