package com.vTiger.TestCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vTiger.Pages.HeaderPage;
import com.vTiger.Pages.Leads;
import com.vTiger.Pages.LoginPage;
import com.vTiger.Pages.NewLeads;

public class E2ELeadFunctionality extends BaseTest {

	@BeforeClass
	public void lauchApp()
	{
		luanchApp();
	}
	
		
	@Test
	public void verifyE2ELeads()
	{
		logger=report.startTest("verifyE2ELeads");
		logger.log(LogStatus.INFO, "Application lauched successfully");
		LoginPage lp=new LoginPage(driver);
		lp.validLogin("admin", "admin");
		HeaderPage hp=new HeaderPage(driver);	
		boolean val =hp.verifyLogout();
		assertTrue(val);
		hp.clickNewlead();
		NewLeads nl=new NewLeads(driver);
		Leads lds=nl.createLeadWithManadatoryFields("Ritu", "Infy");
		hp.clickLeads();
		lds.searchlead("Ritu", "Infy");		
		lds.searchleadDelete();
		logger.log(LogStatus.PASS, "Test2");
		 report.endTest(logger);
	}
	
	@AfterClass
	public void closeApp()
	{
		report.flush();
		driver.quit();
	}


}
