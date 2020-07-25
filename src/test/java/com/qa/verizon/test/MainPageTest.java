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
import com.qa.verizon.util.JavaScriptUtil;


public class MainPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	SmartPhonePage smartPhonePage;
	JavaScriptUtil jScriptUtil;
	
	@BeforeTest
	public void setUp(){
	basePage=new BasePage();
	prop=basePage.init_properties();
	String browserName=prop.getProperty("browser");
	driver=basePage.init_driver(browserName);
	driver.get(prop.getProperty("url"));
	mainPage = new MainPage(driver);
	
		
	}
	
	@Test(priority =1 ,description ="Main Title Page" ,enabled =true)
	public void verifyMainPageTitleTest() throws InterruptedException{
	String title=mainPage.getPageTitle();
	System.out.println("Main Page Title is :"+title);
	Assert.assertEquals(title, AppConstants.MAINPAGE_TITLE);
		
	}
	@Test(priority =2 ,description ="SignUp Button  IsEnabled" ,enabled =false)
	public void verifySignUpLinkTest(){
	Assert.assertTrue(mainPage.checkSignUpIsEnabled());	
		
	}
	
	@Test(priority =3 ,description ="Search Button  IsEnabled" ,enabled =false)
	public void verifySearchButtonTest(){
		Assert.assertTrue(mainPage.checkSearchButtonIsEnabled());
	}

	
	@Test(priority=4)
	public void doGetClickSmartPhone(){
		mainPage.doClickSmartPhone();
	}

	
	
	@AfterTest
	public void tearDown(){
	driver.quit();	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
