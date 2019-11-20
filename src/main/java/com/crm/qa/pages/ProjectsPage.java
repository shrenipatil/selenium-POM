package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ProjectsPage extends TestBase {

	
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
		System.out.println("inside");
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(addBtn));
		addBtn.click();
		System.out.println("butten clicked");
		custNameLable.sendKeys(custName);
		projNameLable.sendKeys(projName);
		description.sendKeys(ProjDesc);
		System.out.println("butten clicked");
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOf(saveBtn));
		saveBtn.click();
		return new ProjectsPage();
	}
}
