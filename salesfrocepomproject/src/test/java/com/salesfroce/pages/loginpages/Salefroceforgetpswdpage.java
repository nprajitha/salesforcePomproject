package com.salesfroce.pages.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesfrocepom.base.Pombasepage;

public class Salefroceforgetpswdpage extends Pombasepage {

	public Salefroceforgetpswdpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='un']")WebElement fusername;
	@FindBy(id="continue")WebElement continuebutton;
   
	public void resetpswdusername(String name)
	{
		textvalues(fusername,name,"enter the user name");
	}
	public void clickcontinuebutton()
	{
		clickele(continuebutton,"click on continue");
	}
}
