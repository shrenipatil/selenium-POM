package com.crm.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	Logger log = Logger.getLogger(LoginPage.class);

	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * @return
	 */
	public String validateLoginPageTilte()
	{
		String URL = null;
		try
		{
		URL=driver.getCurrentUrl();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element is Not Visible ***", e);
		}
		return URL;
	}
	
	/**
	 * @param user
	 * @param pwd
	 * @return
	 */
	public HomePage login(String user,String pwd)
	{
		try
		{
		username.sendKeys(user);
		password.sendKeys(pwd);
		loginBtn.click();
		}
		catch(ElementNotVisibleException e)
		{
			log.error("*** Element username and password is not Visible ***",e);
		}
		return new HomePage();
	}
}
