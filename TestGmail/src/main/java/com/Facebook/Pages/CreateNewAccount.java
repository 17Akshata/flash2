package com.Facebook.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook1.Bbase.TestBase;


public class CreateNewAccount extends TestBase{

	@FindBy(name="firstname")
	WebElement firstname;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(id="u_4_f_ya")
	WebElement mobileNo;
	
	public CreateNewAccount()
	{
		PageFactory.initElements(driver,this);
	}
		
	public void register(String name,String surname,String phoneNum)
	{		
		firstname.sendKeys(name);
		lastname.sendKeys(surname);
		mobileNo.sendKeys(phoneNum);
		
		//mobileNo.sendKeys(String.valueOf(phoneNumber));
	//	driver.findElement(By.id("u_4_f_ya")).sendKeys(phoneNumber);
	}
	
}
