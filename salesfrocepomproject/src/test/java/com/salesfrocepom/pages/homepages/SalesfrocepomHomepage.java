package com.salesfrocepom.pages.homepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesfrocepom.base.Pombasepage;

public class SalesfrocepomHomepage extends Pombasepage {
	  static WebDriver driver=null;
 public SalesfrocepomHomepage(WebDriver driver) {
		super(driver);
		
	}
public String page() {
	 String title=gettitle();
	return title;
	  
 }
 @FindBy(xpath="//div[@id='userNavButton']")WebElement usermenu;
 @FindBy(linkText="Logout")WebElement logoutbutton;
 
 public void dropdownusermenu()
 {
	 mouseon(usermenu,"mouse on userdropdown");
	 clickele(usermenu,"click on userdropdown");
 }
 public void logout()
 {
	 clickele(logoutbutton,"click on logout");
 }
}
