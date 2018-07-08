package com.vTiger.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
	
private WebDriver driver;
	
	public HeaderPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By Logout=By.linkText("Logout");
	By Newlead=By.linkText("New Lead");
	By Leads=By.linkText("Leads");
	
	
	public void clickLeads()
	{
		driver.findElement(Leads).click();
	}
	public void clickNewlead()
	{
		driver.findElement(Newlead).click();
	}
	public void clickLogout()
	{
		driver.findElement(Logout).click();
	}
	
	public boolean verifyLogout()
	{
		if(driver.findElements(Logout).size()==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
