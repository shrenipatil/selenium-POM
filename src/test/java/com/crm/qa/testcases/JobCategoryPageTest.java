package com.crm.qa.testcases;

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
	
	public JobCategoryPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
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
		System.out.println("Inside test case");
		jobCategoriesPage=jobCategoriesPage.addJobCategory("software");
	}
	
	@Test
	public void selectCkBoxCatTest()
	{
	jobCategoriesPage.selectCkBoxCat("software");
	}
	
	@Test
	public void selectMultipleCkBoxCatTest()
	{
	jobCategoriesPage.selectCkBoxCat("software");
	jobCategoriesPage.selectCkBoxCat("software engineer");
	}
	
	@Test
	public void deleteJobCategoryTest()
	{
		jobCategoriesPage.selectCkBoxCat("software");
		jobCategoriesPage.deleteJobCategory();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
