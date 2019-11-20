package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AdminPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.ProjectsPage;
import com.crm.qa.util.TestUtil;

public class ProjectsPageTest extends TestBase {
	
	String sheetName="ProjectDetails";
	
	LoginPage loginPage;
	HomePage homePage;
	AdminPage adminPage;
	ProjectsPage projectsPage;
	Logger log = Logger.getLogger(ProjectsPageTest.class);
	
	public ProjectsPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		log.info("*********************** SETUP - Starting test cases execution ***************************");
		initialization();
		loginPage=new LoginPage();
		TestUtil testUtil=new TestUtil();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		projectsPage=homePage.clickOnProjects();
		testUtil.switchToFrame();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	/**
	 * @param custName
	 * @param projName
	 * @param projDesc
	 */
	@Test(dataProvider="getCRMTestData")
	public void addNewProjectTest(String custName,String projName,String projDesc) 
	{
		log.info("*************************** START - add New Project Test ******************************");
		projectsPage.addNewProject(custName,projName,projDesc);
		log.info("**************************** END - add New Project Test ********************************");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("****************************** TearDown - Browser is closed *****************************************");
	}
}
