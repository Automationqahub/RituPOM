package com.vTiger.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,  this);
	}
	
	/*
	By Username=By.name("user_name");
	By UserPwd=By.name("user_password");
	*/
	By Login=By.name("Login");
	By Theme=By.name("login_theme");
	By errormsg=By.xpath("//td[contains(text(),'You must specify a valid username')]");
	By logo=By.xpath("//img[@src='include/images/vtiger-crm.gif']");
	
	/******Page Factory  ***********************/
	@FindBy(how = How.NAME, using = "user_name")
	public WebElement Username;
	
	@FindBy(name = "user_password") 
	WebElement UserPwd;
	
	
	
	public boolean verifylogo()
	{
		if(driver.findElements(logo).size()==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean verifyTitle()
	{
		if(driver.getTitle().trim().equals("123vtiger CRM - Commercial Open Source CRM"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean InvalidLogin()
	{
		Username.sendKeys("safasfafa");
		UserPwd.sendKeys("4354243");
		driver.findElement(Login).click();
		if(driver.findElements(errormsg).size()==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void validLogin(String userid,String pwd)
	{
		Username.clear();
		Username.sendKeys(userid);
		UserPwd.clear();
		UserPwd.sendKeys(pwd);
		driver.findElement(Login).click();
		
	}
	
	
	
	
	
	

}
