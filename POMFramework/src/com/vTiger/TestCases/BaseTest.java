package com.vTiger.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vTiger.Common.commonFunctions;


public class BaseTest {
	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger; 
	public static String extentReport;
	
	
	public void createReport()
	{
		report=commonFunctions.setupResult();
		System.out.println("Hello Ritu!");
		
	}
	
	public void luanchApp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\com\\vtiger\\utilities\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:100");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS );
		driver.manage().window().maximize();
	}

}
