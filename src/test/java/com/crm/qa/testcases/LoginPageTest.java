package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		log.info("*********************** SETUP - Starting test cases execution ***************************");
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTilteTest()
	{
		log.info("*************************** START - login Page Tilte Test ******************************");
		String title=loginPage.validateLoginPageTilte();
		Assert.assertEquals(title, "https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login");
		log.info("**************************** END - login Page Tilte Test ********************************");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		log.info("*************************** START - login Page Test ******************************");
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("**************************** END - login Page Test ********************************");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("****************************** TearDown - Browser is closed *****************************************");
	}
	
}
