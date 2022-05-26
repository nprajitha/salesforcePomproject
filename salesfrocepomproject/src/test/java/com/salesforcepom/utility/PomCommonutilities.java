package com.salesforcepom.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;





public class PomCommonutilities {
	public static String getpropertyvalue(String key) throws IOException
	{
		Properties prop =new Properties();
		String path= PomConstants.PROPERTIES_PATH;
		FileInputStream fr= new FileInputStream(path);
		 try {
			prop.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 String value=prop.getProperty(key); //get values from  properties files
		 System.out.println("value from the file"+value);
		
			fr.close();
		
		
		 return value;
		
	}
	
	public static String captureshot(WebDriver driver)
	{
		Date currentdate=new Date();
		 String screenshotfilename=currentdate.toString().replace(" ","-").replace(":", "-");
		 System.out.println(screenshotfilename);
		//GeneratePomReport pomreport=  GeneratePomReport .getInstance();
		TakesScreenshot  capture =(TakesScreenshot)driver; //taking screen shot
		File srcimg=capture.getScreenshotAs(OutputType.FILE);// capture img to store in file
		//pomreport.logtestinfo("shot captured");
		String screenpath=PomConstants.SCREENSHOT_PATH+screenshotfilename+".png";
		File dstimg=new File(screenpath);
		//copy file to destination file
		try {
			FileUtils.copyFile(srcimg, dstimg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screenpath;
		
	}

}
