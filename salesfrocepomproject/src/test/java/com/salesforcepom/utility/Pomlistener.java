package com.salesforcepom.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.salesfrocepom.base.Pombasetest;

public class Pomlistener implements ITestListener

{
	 ExtentHtmlReporter htmlreporter;// ---> creating extentreport class object
		public static ExtentReports extent;
		public static ExtentTest logger;
	public	GeneratePomReport pomreport=GeneratePomReport.getInstance();
	
	public void onStart(ITestContext context) {
		System.out.println("onstart method started");
		pomreport.callextentreport();
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("ontest method started");
		//pomreport.startsingletestpomreport(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		pomreport.logtestpass(result.getMethod().getMethodName());
		WebDriver driver=Pombasetest.getDriverInstance();
		String shotpath = PomCommonutilities.captureshot(driver);
		try {
			pomreport.attachscreeshot(shotpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {
		pomreport.logtestfail(result.getMethod().getMethodName());
		
		WebDriver driver=Pombasetest.getDriverInstance();
		String shotpath = PomCommonutilities.captureshot(driver);
		try {
			pomreport.attachscreeshot(shotpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		pomreport.logtestskip(result.getMethod().getMethodName());
		
	}

	

	public void onFinish(ITestContext context) 
	{
		//pomreport.endreport();
		
	}
	

}
