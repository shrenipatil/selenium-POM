package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class JobCategoriesPage extends TestBase{

	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement addBtn;
	
	@FindBy(xpath="//input[@id='jobCategory_name']")
	WebElement jobCategoryName;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement saveBtn;
	
	//@FindBy(xpath="//input[@id='ohrmList_chkSelectRecord_1']")
	//WebElement checkBox;
	
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
		System.out.println("inside method ");
		addBtn.click();
		jobCategoryName.sendKeys(addNewCategory);
		saveBtn.click();
		System.out.println("outside the method ");
		return new JobCategoriesPage();
		
	}
	
	public void selectCkBoxCat(String selectedCategory)
	{
		
		driver.findElement(By.xpath("//a[text()='"+selectedCategory+"']//parent::td[@class='left']//preceding-sibling::td//input")).click();
	}
	
	public JobCategoriesPage deleteJobCategory()
	{
		deleteBtn.click();
		dialogDeleteBtn.click();
		return new JobCategoriesPage();
	}
}
