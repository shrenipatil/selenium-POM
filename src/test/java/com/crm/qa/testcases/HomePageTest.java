package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AdminPage;
import com.crm.qa.pages.HelpPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.JobCategoriesPage;
import com.crm.qa.pages.LeavePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.PerformancePage;
import com.crm.qa.pages.PimPage;
import com.crm.qa.pages.ProjectsPage;
import com.crm.qa.pages.RecruitmentPage;
import com.crm.qa.pages.TimePage;

public class HomePageTest extends TestBase{
	
	
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	PimPage pimPage;
	LeavePage leavePage;
	TimePage timePage;
	RecruitmentPage recruitmentPage;
	PerformancePage performancePage;
	HelpPage helpPage;
	JobCategoriesPage jobCategoriesPage;
	ProjectsPage projectsPage;
	
	Logger log = Logger.getLogger(HomePageTest.class);
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		log.info("*********************** SETUP - Starting test cases execution ***************************");
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test
	public void homePageTitleTest()
	{
		log.info("*************************** START - Home Page Title Test ******************************");
		String title=homePage.homePageValitateTitle();
		Assert.assertEquals(title, "OrangeHRM");
		log.info("**************************** END - Home Page Title Test ********************************");
	}
	
	@Test
	public void clickOnAdminTest()
	{
		log.info("***************************** START - click On Admin Test *******************************");
		adminPage=homePage.clickOnAdmin();
		log.info("***************************** END - click On Admin Test *********************************");
	}
	
	@Test
	public void clickOnPimTest()
	{
		log.info("***************************** START - click On Pim Test **********************************");
		pimPage=homePage.clickOnPim();
		log.info("***************************** END - click On Pim Test ************************************");
	}
	
	@Test
	public void clickOnLeaveTest()
	{
		log.info("***************************** START - click On Leave Test *********************************");
		leavePage=homePage.clickOnLeave();
		log.info("***************************** END - click On Leave Test ***********************************");
	}
	
	@Test
	public void clickOnTimeTest()
	{
		log.info("****************************** START - click On Time Test **********************************");
		timePage=homePage.clickOnTime();
		log.info("****************************** END - click On Time Test ************************************");
	}
	
	@Test
	public void clickOnRecruitmentTest()
	{
		log.info("****************************** START - click On Recruitment Test ******************************");
		recruitmentPage=homePage.clickOnRecritment();
		log.info("****************************** END - click On Recruitment Test ********************************");
	}
	
	@Test
	public void clickOnPerformanceTest()
	{
		log.info("****************************** START - click On Performance Test ********************************");
		performancePage=homePage.clickOnPerformance();
		log.info("****************************** END - click On Performance Test **********************************");
	}
	
	@Test
	public void clickOnHelpTest()
	{
		log.info("****************************** START - click On Help Test ***************************************");
		helpPage=homePage.clickOnHelp();
		log.info("****************************** END - click On Help Test *****************************************");
	}
	
	@Test
	public void clickOnJobCatTest()
	{
		log.info("****************************** START - click On Job Categories Test **********************************");
		jobCategoriesPage=homePage.clickOnJobCategories();
		log.info("****************************** END - click On Job Categories Test ************************************");
		
	}
	@Test
	public void clickOnProjectsTest()
	{
		log.info("****************************** START - click On Projects Test ***************************************");
		projectsPage= homePage.clickOnProjects();
		log.info("****************************** END - click On Projects Test *****************************************");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("****************************** TearDown - Browser is closed *****************************************");
	}
	
}
