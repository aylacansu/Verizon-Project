package com.qa.verizon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	public static boolean highlightElement;
	
	public WebDriver init_driver(String browserName){
		
	highlightElement=prop.getProperty("highlight").equals("yes");
	System.out.println("Browser name is :" +browserName);
		
	if(browserName.equalsIgnoreCase("chrome")){	
		WebDriverManager.chromedriver().setup();
		if(prop.getProperty("headless").equals("yes")){
			ChromeOptions cOptions=new ChromeOptions();
			cOptions.addArguments("--headless");
			driver=new ChromeDriver(cOptions);
			
		}else{
			driver=new ChromeDriver();
		}
		
		
	}else if(browserName.equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
		if(prop.getProperty("headless").equals("yes")){
		FirefoxOptions fOptions=new FirefoxOptions();
		fOptions.addArguments("--headless");
		driver= new FirefoxDriver(fOptions);
		}else{
		driver=new FirefoxDriver();	
		}
		
	}else if(browserName.equalsIgnoreCase("opera")){
		WebDriverManager.operadriver().setup();
		driver=new OperaDriver();
		
	}else if(browserName.equalsIgnoreCase("IE")){
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		
	}else if(browserName.equalsIgnoreCase("safari")){ 
		WebDriverManager.getInstance(SafariDriver.class).setup();
		driver=new SafariDriver();
		
	}else{
	System.out.println("Browser name " +browserName + " is  not found");	
	}
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	return driver;
		
}
	
public Properties init_properties(){	

	prop= new Properties();
	String path=null;
	String env=null;
	
	try {
	env=System.getProperty("env");
	if(env.equals("qa")){
	path="./src/main/java/com/qa/verizon/config/config.qa.properties";	
		}else if(env.equals("stg")){
	path= "./src/main/java/com/qa/verizon/config/config.stg.properties";
		} 
	}catch (Exception e) {
		
	path="./src/main/java/com/qa/verizon/config/config.properties";	
		}
	
	try {
		FileInputStream inputStream= new FileInputStream(path);
		prop.load(inputStream);
	} catch (FileNotFoundException e) {
		System.out.println("some issue with config proporties..pls correct your config..");
		
	}catch (IOException e) {
		e.printStackTrace();
		
	}
	return prop;
	
	
	
	
	
	
	}}
	
	
	


