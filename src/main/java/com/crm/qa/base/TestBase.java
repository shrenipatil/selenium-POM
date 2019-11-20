package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.testcases.HomePageTest;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("/Users/Inside/workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
			log.info("**** Load Properties File Successfully ****");
			
		}catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
			log.error("***** File is not find *****");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("***** Error While Loading Properties File *****");
		}
	}
	
	
	public void initialization()
	{
		String browserName=prop.getProperty("browse");
		if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "D:/Selenium/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("**** Application Run With Firefox Browser ****");
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/Selenium/geckodriver.exe");
			driver = new ChromeDriver();
			log.info("**** Application Run With Chrome Browser ****");
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		log.info("**** entering application URL ****");
	}
}
