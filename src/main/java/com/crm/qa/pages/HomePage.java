package com.crm.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.HomePageTest;

public class HomePage extends TestBase{
	
	Logger log = Logger.getLogger(HomePage.class);

	@FindBy(xpath="//a[.//span[text()='Admin']]")
	WebElement admin;
	
	@FindBy(xpath="//a[.//span[text()='PIM']]")
	WebElement pim;
	
	@FindBy(xpath="//a[.//span[text()='Leave']]")
	WebElement leave;
	
	@FindBy(xpath="//a[.//span[text()='Time']]")
	WebElement time;
	
	@FindBy(xpath="//a[.//span[text()='Recruitment']]")
	WebElement recruitment;
	
	@FindBy(xpath="//a[.//span[text()='Performance']]")
	WebElement performance;
	
	@FindBy(xpath="//a[.//span[text()='Help']]")
	WebElement help;
	
	@FindBy(xpath="//a[.//span[text()='Job']]")
	WebElement job;
	
	@FindBy(xpath="//a[.//span[text()='Job Categories']]")
	WebElement jobCategories;
	
	@FindBy(xpath="//a[.//span[text()='Project Info']]")
	WebElement projectInfo;
	
	@FindBy(xpath="//a[.//span[text()='Projects']]")
	WebElement projects;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String homePageValitateTitle()
	{
		String Title = null;
		try
		{
		Title=driver.getTitle();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element is Not Visible ***", e);
		}
		return Title;
	}
	
	public LeavePage clickOnLeave()
	{
		try
		{
		leave.click();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element Leave is not Visible ***",e);
		}
		return new LeavePage();
	}
	
	public AdminPage clickOnAdmin()
	{
		try
		{
		admin.click();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element Admin is not Visible ***",e);
		}
		return new AdminPage();
	}
	public PimPage clickOnPim()
	{
		try
		{
		pim.click();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element PIM is not Visible ***",e);
		}
		return new PimPage();
	}
	
	public TimePage clickOnTime()
	{	try
		{
		time.click();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element Time is not Visible ***",e);
		}
		return new TimePage();
	}
	
	public RecruitmentPage clickOnRecritment()
	{
		try
		{
		recruitment.click();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element Recruitment is not Visible ***",e);
		}
		return new RecruitmentPage();
	}
	public PerformancePage clickOnPerformance()
	{
		try
		{
		performance.click();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element Performance is not Visible ***",e);
		}
		return new PerformancePage();
	}
	public HelpPage clickOnHelp()
	{
		try
		{
		help.click();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element Help is not Visible ***",e);
		}
		return new HelpPage();
	}
	
	public JobCategoriesPage clickOnJobCategories()
	{
		try
		{
		Actions action=new Actions(driver);
		action.moveToElement(admin).build().perform();
		log.info("*** Move to the element *Admin* ***");
		Actions action1=new Actions(driver);
		action1.moveToElement(job).build().perform();
		log.info("*** Move to the element *Job* ***");
		new WebDriverWait(driver,20);
		jobCategories.click();
		log.info("*** Element is Clicked *Job Categories* ***");
		}
		catch(WebDriverException e)
		{
			log.error("*** Web Driver Couldn't locate the element ***",e);
		}
		return new JobCategoriesPage();
	}
	
	public ProjectsPage clickOnProjects()
	{
		try
		{
		Actions action=new Actions(driver);
		action.moveToElement(admin).build().perform();
		log.info("*** Move to the element *Admin* ***");
		Actions action1=new Actions(driver);
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(projectInfo));
		action1.moveToElement(projectInfo).build().perform();
		log.info("*** Move to the element *Project Info* ***");
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(projects));
		projects.click();
		log.info("*** Element is Clicked  *Projects* ***");
		}
		catch(WebDriverException e)
		{
			log.error("*** Web Driver Couldn't locate the element ***",e);
		}
		return new ProjectsPage();
	}
}
