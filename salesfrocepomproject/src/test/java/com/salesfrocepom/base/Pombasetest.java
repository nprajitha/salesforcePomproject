package com.salesfrocepom.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.salesforcepom.utility.GeneratePomReport;
import com.salesforcepom.utility.PomCommonutilities;
import com.salesforcepom.utility.PomConstants;

//import com.salesforce.utility.Commonutilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pombasetest {
	 protected static WebDriver driver;
	 protected static WebDriverWait wait;
	 public static ExtentHtmlReporter htmlreporter;// ---> creating extentreport class object
		public static ExtentReports extent;
		public static ExtentTest logger;
		public static GeneratePomReport pomreport;
		
		@BeforeTest
		
		public static void pomfirstsetup()
		{
			System.out.println("@beforetest started");
			pomreport=GeneratePomReport.getInstance();
			
		}
	
		@BeforeMethod
		@Parameters("browser")	
			public  void setup( Method method,String browser ) throws IOException
			{
			pomreport.startsingletestpomreport(method.getName());
		      launchdriver(browser);
				
				String url =PomCommonutilities.getpropertyvalue("url");
				
				navigate(url);
				
			}
		@AfterMethod
		public  void close() {
			
			closeDriver();
		}
		@AfterTest
		public void finaldown()
		{
			System.out.println("@aftertest started");
			pomreport.endreport();
		}
		public static WebDriver getDriverInstance(){
		return driver;
		}
		public static void closeDriver() {
			driver.close();
		}
		
		public static void closeAllDriver() {
			driver.quit();
		}
	
	public static void launchdriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver =new ChromeDriver();
			// driver.navigate().refresh();
			 //System.out.println("driver is launched");
			 pomreport.logtestinfo("driver is  chrome launched");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver =new FirefoxDriver();
			 //System.out.println("driver is launched");
			// pomreport.logtestinfo("driver  firefox launched");
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver =new EdgeDriver();
			
			 //System.out.println("driver is launched");
			 pomreport.logtestinfo("driver edge launched");
		}
		else {
			System.out.println("Browser not found ");
		}
		
	}
	public static void navigate(String url)
	{
		driver.get(url);
		//System.out.println("url is opened");
		pomreport.logtestinfo("url is :"+url);
	}
	
	

}
