package com.vTiger.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Leads extends HeaderPage {
	
	private WebDriver driver;
	public Leads(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	By lastname=By.xpath("(//input[@name='lastname'])[2]");
	By company=By.xpath("(//input[@name='company'])[2]");
	By search=By.xpath("//input[@value='Search'][@type='submit']");
    By selectcheckbox=By.xpath("//input[@name='selected_id']");
    By deleteBtn=By.xpath("//input[@value='Delete']");
    
    
    public void searchlead(String lname,String comp)
    {
    	driver.findElement(lastname).sendKeys(lname);
		driver.findElement(company).sendKeys(comp);
		driver.findElement(search).click();
    }
    
    
    public void searchleadDelete()
    {
    	driver.findElement(selectcheckbox).click();		
		driver.findElement(deleteBtn).click();
    }
    
    
    
    
    
    
}
