package com.crm.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class JobCategoriesPage extends TestBase{
	
	Logger log = Logger.getLogger(JobCategoriesPage.class);

	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement addBtn;
	
	@FindBy(xpath="//input[@id='jobCategory_name']")
	WebElement jobCategoryName;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement saveBtn;
	
	@FindBy(xpath="//input[@id='btnDelete']")
	WebElement deleteBtn;
	
	@FindBy(xpath="//input[@id='dialogDeleteBtn']")
	WebElement dialogDeleteBtn;
	public JobCategoriesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public JobCategoriesPage addJobCategory(String addNewCategory)
	{
		try
		{
		addBtn.click();
		jobCategoryName.sendKeys(addNewCategory);
		saveBtn.click();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element add button is not Visible ***",e);
		}
		return new JobCategoriesPage();
		
	}
	
	public void selectCkBoxCat(String selectedCategory)
	{
		
		driver.findElement(By.xpath("//a[text()='"+selectedCategory+"']//parent::td[@class='left']//preceding-sibling::td//input")).click();
	}
	
	public JobCategoriesPage deleteJobCategory()
	{
		try
		{
		deleteBtn.click();
		dialogDeleteBtn.click();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element delete button is not Visible ***",e);
		}
		return new JobCategoriesPage();
	}
}
