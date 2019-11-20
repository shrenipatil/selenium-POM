package com.crm.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ProjectsPage extends TestBase {

	
	Logger log = Logger.getLogger(JobCategoriesPage.class);
	
	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement addBtn;
	
	@FindBy(xpath="//input[@id='addProject_customerName']")
	WebElement custNameLable;
	
	@FindBy(xpath="//input[@id='addProject_projectName']")
	WebElement projNameLable;
	
	@FindBy(xpath="//textarea[@id='addProject_description']")
	WebElement description;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement saveBtn;
	
	public ProjectsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ProjectsPage addNewProject(String custName,String projName,String ProjDesc)
	{
		try
		{
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(addBtn));
		addBtn.click();
		log.info("*** Add button is clicked ***");
		custNameLable.sendKeys(custName);
		projNameLable.sendKeys(projName);
		description.sendKeys(ProjDesc);
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();
		log.info("*** Save button is clicked ***");
		}
		catch(WebDriverException e)
		{
			log.error("*** Web Driver Couldn't locate the element ***",e);
		}
		return new ProjectsPage();
	}
}
