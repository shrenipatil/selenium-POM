package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AdminPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.JobCategoriesPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class JobCategoryPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	AdminPage adminPage;
	JobCategoriesPage jobCategoriesPage;
	
	Logger log = Logger.getLogger(JobCategoryPageTest.class);
	
	public JobCategoryPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		log.info("*********************** SETUP - Starting test cases execution ***************************");
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		jobCategoriesPage=homePage.clickOnJobCategories();
		testUtil.switchToFrame();
	}
	@Test
	public void addJobCategoryTest()
	{
		log.info("*************************** START - add Job Category Test ******************************");
		jobCategoriesPage=jobCategoriesPage.addJobCategory("software");
		log.info("**************************** END - add Job Category Test ********************************");
	}
	
	@Test
	public void selectCkBoxCatTest()
	{
		log.info("*************************** START - select Single Check Box category Test ******************************");
		jobCategoriesPage.selectCkBoxCat("software");
		log.info("**************************** END - select Single Check Box category Test ********************************");
	}
	
	@Test
	public void selectMultipleCkBoxCatTest()
	{
		log.info("*************************** START - select Multiple Check Box category Test ******************************");
		jobCategoriesPage.selectCkBoxCat("software");
		jobCategoriesPage.selectCkBoxCat("software engineer");
		log.info("**************************** END - select Multiple Check Box category Test ********************************");
	}
	
	@Test
	public void deleteJobCategoryTest()
	{
		log.info("*************************** START - delete Job Category Test ******************************");
		jobCategoriesPage.selectCkBoxCat("software");
		jobCategoriesPage.deleteJobCategory();
		log.info("**************************** END - delete Job Category Test ********************************");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("****************************** TearDown - Browser is closed *****************************************");
	}
}
