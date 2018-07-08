package com.vTiger.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewLeads  extends HeaderPage {
	private WebDriver driver;
	public NewLeads(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	By lastname=By.name("lastname");
	By company=By.name("company");
	By Save=By.name("button");
	
	
	public Leads createLeadWithManadatoryFields(String lname,String comp)
	{
		driver.findElement(lastname).sendKeys(lname);
		driver.findElement(company).sendKeys(comp);
		driver.findElement(Save).click();
		return new Leads(driver);
	}
	
	

}
