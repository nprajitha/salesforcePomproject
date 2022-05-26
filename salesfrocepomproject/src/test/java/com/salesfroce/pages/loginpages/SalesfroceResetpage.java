package com.salesfroce.pages.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesfrocepom.base.Pombasepage;

public class SalesfroceResetpage  extends Pombasepage{

	public SalesfroceResetpage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(id="header")WebElement checkemail;
	public String checkingmsg()
	{
		String emailmsg= gettext(checkemail,"to get text");
		return emailmsg;
		
	}
	
}
