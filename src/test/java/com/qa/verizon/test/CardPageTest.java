package com.qa.verizon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.verizon.base.BasePage;
import com.qa.verizon.pages.CardPage;
import com.qa.verizon.pages.MainPage;
import com.qa.verizon.pages.SelectedPhonePage;
import com.qa.verizon.pages.SmartPhonePage;
import com.qa.verizon.util.AppConstants;

public class CardPageTest  {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	SmartPhonePage smartPhonePage;
	SelectedPhonePage selectedPhonePage;
	CardPage cardPage;

	@BeforeTest
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.init_properties();
		String browserName=prop.getProperty("browser");
		driver=basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		mainPage=new MainPage(driver);
		smartPhonePage=mainPage.doClickSmartPhone();
		selectedPhonePage=smartPhonePage.doClickAppleXR();
		cardPage=selectedPhonePage.doClickFeatures();
	}
	
	@Test(priority=1)
	public void verifyGetTitle(){
	String title=cardPage.getTitlePage();
	System.out.println("Card Page Title " + title);
	Assert.assertEquals(title,AppConstants.CARDPAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyGetPageHeader(){
	String header=cardPage.getPageHeader();
	System.out.println("Card page header " +header);
	Assert.assertEquals(header, AppConstants.CARDPAGE_HEADER);
		
	}
	
	@Test(priority=3)
	public void verifyPhoneName(){
	String PhoneName=cardPage.getPhoneNameText();
	System.out.println("Selected Phone is "+ PhoneName);
	Assert.assertEquals(PhoneName, AppConstants.SELECTED_PHONE_MODEL);
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
