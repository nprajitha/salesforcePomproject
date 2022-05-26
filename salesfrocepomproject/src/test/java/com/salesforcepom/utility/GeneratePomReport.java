package com.salesforcepom.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GeneratePomReport {
	
	public static ExtentHtmlReporter htmlreporter;// ---> creating extentreport class object
	public static ExtentReports extent;
	public static ExtentTest logger;
	private static GeneratePomReport grp;
	private GeneratePomReport()
	{
		
	}
	public static GeneratePomReport getInstance()
	{
		if(grp==null)
		{
			grp=new GeneratePomReport();
		}
		return grp;
		
	}
	static String testcasename = null;
	public  void  callextentreport()
	{
		htmlreporter =new ExtentHtmlReporter(PomConstants.REPORT_PATH); // creating html path
		extent =new ExtentReports();
		 extent .attachReporter(htmlreporter);
		 extent.setSystemInfo("enviroment", "automation testing");
		 extent.setSystemInfo("username","student");
		
		//genearting single report html file
		htmlreporter.config().setDocumentTitle("Test Execution Report");
		htmlreporter.config().setReportName("saleforce pom tests");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTheme(Theme.STANDARD);
	}
	//caling  singletestreport for testcases
	public void startsingletestpomreport(String testname)
	{
		testcasename =testname;
		logger=extent.createTest(testname);
		
		
	}
	public void logtestinfo(String message)
	{
		logger.log(Status.INFO, message);
	}
	public void logtestpass(String testcasename)
	{
		logger.log(Status.PASS,MarkupHelper.createLabel("my testcase is pass", ExtentColor.GREEN));
	}
	public void logtestfail(String testcasename)
	{
		logger.log(Status.FAIL,MarkupHelper.createLabel("my testcase is failed", ExtentColor.RED));
	}
	public void logtestskip(String testcasename)
	{
		logger.log(Status.SKIP,MarkupHelper.createLabel("my testcase is skipped", ExtentColor.ORANGE));
	}
	public void endreport()
	{
		extent.flush();
	}
	public void attachscreeshot(String path) throws IOException
	{
		
		logger.addScreenCaptureFromPath(path);
	}

}
