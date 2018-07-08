package com.vTiger.TestCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vTiger.Common.commonFunctions;
import com.vTiger.Pages.HeaderPage;
import com.vTiger.Pages.LoginPage;

public class verifyLoginTestCases extends BaseTest {


	
	@BeforeClass
	public void lauchApp()
	{
		createReport();
		luanchApp();
	}
	
	
	@Test
	public void verifyInvalidLogin()
	{
		logger=report.startTest("verifyInvalidLogin");
		logger.log(LogStatus.INFO, "Application lauched successfully");
		LoginPage lp=new LoginPage(driver);
		boolean val=lp.InvalidLogin();
	    if(val)
	    {
	    	logger.log(LogStatus.PASS, "Invalid scenario working as expected");
	    }
	    else
	    {
	    	logger.log(LogStatus.FAIL, "Invalid scenario is not working as expected");
	    }
	    report.endTest(logger);
	}
	
	@Test
	public void verifyloginUIElements()
	{
		logger=report.startTest("verifyloginUIElements");
		LoginPage lp=new LoginPage(driver);
		boolean val=lp.verifylogo();
		 if(val)
		    {
		    	logger.log(LogStatus.PASS, "logo is displaying successfully");
		    }
		    else
		    {
		    	logger.log(LogStatus.FAIL, "logo not found");
		    }
		boolean val1=lp.verifyTitle();
		 if(val1)
		    {
		    	logger.log(LogStatus.PASS, "Title matched successfully with expected value");
		    }
		    else
		    {
		    	logger.log(LogStatus.FAIL, "Title did not match");
		    }	
		 report.endTest(logger);
	}
	
	@Test(dependsOnMethods="verifyInvalidLogin")
	public void verifyValidLogin()
	{
		logger=report.startTest("verifyValidLogin");
		LoginPage lp=new LoginPage(driver);
		lp.validLogin("admin", "admin");
		HeaderPage hp=new HeaderPage(driver);	
		boolean val =hp.verifyLogout();
		 if(val)
		    {
		    	logger.log(LogStatus.PASS, "Login scenario validated successfully");
		    }
		    else
		    {
		    	logger.log(LogStatus.FAIL, "Valid login is not working");
		    }	
		 report.endTest(logger);
	}
	
	@AfterClass
	public void closeApp()
	{
		report.flush();
		driver.quit();
	}

}
