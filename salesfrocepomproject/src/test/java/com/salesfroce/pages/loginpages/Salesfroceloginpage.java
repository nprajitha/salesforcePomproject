package com.salesfroce.pages.loginpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesfrocepom.base.Pombasepage;

public class Salesfroceloginpage extends Pombasepage
{
	WebDriver driver;
	//using Findby for locating webelements
    @FindBy(xpath="//input[@id='username']")WebElement username;
    @FindBy(xpath="//input[@id='password']")WebElement password;
    @FindBy(xpath="//input[@id='Login']")WebElement login;
    
    //using consrtuctor
    public  Salesfroceloginpage(WebDriver driver)
    {
    	//PageFactory.initElements(driver, this);
    	super(driver);
    }
    
   // functionality methods should access to automation scripts
    public  void enteremail(String usr)
    {
    	textvalues(username,usr,"enter username");
    	
    	//email.sendKeys(emailid);
    	
    }
    public void password(String pswd)
    {
    	textvalues(password,pswd,"enter password");
    	//password.sendKeys(pswd);
    }
    public void clickbutton()
    {
    	clickele(login,"click on login button");
    	//login.click();
    }
    // for login details method
    public void logindetails(String usrname,String passwrd)
    {
    	enteremail(usrname);
    	password(passwrd);
    	clickbutton();
    }
   //web elemnt for finding error msg for invalid logindetails
    @FindBy(id="error")WebElement errmsg;
    public String invaliderrormsg()
    {
    	String msg=gettext(errmsg ,"get error message");
		return msg;
    	
    }
    public void clearpasswordbx()
    {
    	clearbox(password,"clear the password box");
    }
    //webelement for password clear msg 
   
	@FindBy(xpath="//div[@id='error']")WebElement pswderrmsg;
	public String pswderrmsg()
	{
		String pmsg=gettext(pswderrmsg,"get password e rror message");
		return pmsg;
	}
	
	
	//check box remember me
  @FindBy(xpath ="//input[@id='rememberUn']")WebElement checkrememberme;
  public void checkbox()
  {
	  clickele(checkrememberme,"click on check box");
  }
  //verfiy user display on loginpage after remember checkbox
  @FindBy(xpath="//span[@id='idcard-identity']") WebElement displayusername;
  public String displayname()
  {
	  String name=gettext(displayusername,"username should display");
	return name;
	  
  }
  // For forget password webelement
  @FindBy(xpath="//a[@id='forgot_password_link'] ")WebElement forgetpassword;
  public void clickforgetpswd()
  {
	  clickele(forgetpassword,"click on forget password button ");
  }
}
