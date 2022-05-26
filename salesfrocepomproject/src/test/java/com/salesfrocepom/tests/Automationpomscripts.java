package com.salesfrocepom.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.salesforcepom.utility.PomCommonutilities;
import com.salesfroce.pages.loginpages.Salefroceforgetpswdpage;
import com.salesfroce.pages.loginpages.SalesfroceResetpage;
import com.salesfroce.pages.loginpages.Salesfroceloginpage;
import com.salesfrocepom.base.Pombasetest;
import com.salesfrocepom.pages.homepages.SalesfrocepomHomepage;
//@Listeners (com.salesforcepom.utility.Pomlistener.class)
public class Automationpomscripts extends Pombasetest
{
     @Test
	 public static void NaviagtetoSFDC() throws IOException
	 {
		 Salesfroceloginpage slp=new Salesfroceloginpage(driver);
		 String user=PomCommonutilities.getpropertyvalue("username");
		 slp.enteremail(user);
		 slp.clearpasswordbx();
		 slp.clickbutton();
		// driver.navigate().refresh();
		 String s1="Please enter your password.";
		 String s2=slp.pswderrmsg();
		 System.out.println(s2);
		 Assert.assertEquals(s1, s2);
		
		
	 }
	 @Test
	 public static void LoginSFDC() throws IOException
	 {
		 Salesfroceloginpage slp=new Salesfroceloginpage(driver);
		 String exceptedvalue="Home Page ~ Salesforce - Developer Edition";
			String user1=PomCommonutilities.getpropertyvalue("username");
			String password1=PomCommonutilities.getpropertyvalue("password");
		    slp.logindetails(user1,password1);
		   // driver.navigate().refresh();
		    SalesfrocepomHomepage shp=new SalesfrocepomHomepage(driver);
		    String actualvalues =shp.page();
		   // Assert.assertEquals(actualvalues,exceptedvalue );
		    
		    
	 }
	 @Test
     public static void checkrememberme() throws IOException
     {
    	 Salesfroceloginpage slp=new Salesfroceloginpage(driver);
			String user2=PomCommonutilities.getpropertyvalue("username");
			String password2=PomCommonutilities.getpropertyvalue("password");
			slp.enteremail(user2);
			slp.password(password2);
			slp.checkbox();
			slp.clickbutton();
			SalesfrocepomHomepage shp=new SalesfrocepomHomepage(driver);
			String homepagemsg=shp.page();
			System.out.println(homepagemsg);
			shp.dropdownusermenu();
			shp.logout();
			// driver.navigate().refresh();
			String exceptedmsg="nanduri@student.com";
			String actualdmsg=slp.displayname();
			Assert.assertEquals(actualdmsg, exceptedmsg);		
    	 
     }
	 @Test
     public static void forgotpassword() throws IOException
     {
    	 Salesfroceloginpage slp=new Salesfroceloginpage(driver);
    	 slp.clickforgetpswd();
    	 Salefroceforgetpswdpage sfp=new Salefroceforgetpswdpage(driver);
    	 String user3=PomCommonutilities.getpropertyvalue("username");
    	 sfp.resetpswdusername(user3);
    	 sfp.clickcontinuebutton();
    	 String exceptedmsgfp="Check Your Email";
    	 SalesfroceResetpage srp=new SalesfroceResetpage(driver);
    	 String actualmessage= srp.checkingmsg();
    	 Assert.assertEquals(actualmessage, exceptedmsgfp);
    	 
     }
     @Test(dataProvider="logindata")
     public static void invalidlogindetials(String uname,String pwd)
     {
    	 String exceptedmsg ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
    	 Salesfroceloginpage slp=new Salesfroceloginpage(driver);
    	// slp.enteremail(uname);
    	 //slp.password(pwd);
    	 //slp.clickbutton();
    	 slp.logindetails(uname, pwd);
    	// driver.navigate().refresh();
    	 String actualmsg=slp.invaliderrormsg();
    	 System.out.println(actualmsg);
    	 Assert.assertEquals(actualmsg,exceptedmsg);
    	 
    	 
     }
     @DataProvider(name="logindata")
     public Object [][]getDataFromDataprovider()
     {
		return new Object[][] 
				{
				{"123","2231"}	
				
		};
     
    	 
     }
}
