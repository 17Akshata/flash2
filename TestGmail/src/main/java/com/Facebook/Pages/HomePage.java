package com.Facebook.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook1.Bbase.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath="//a[@aria-label='Watch']")
	WebElement watch;

	@FindBy(xpath="//a[@aria-label='Groups']")
	WebElement groups;

	@FindBy(name="global_typeahead")
	WebElement search;
	
	@FindBy(id="facebook")
	WebElement title;

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public void clickWatch()
	{
		watch.click();
	}

	public void groupsClick()
	{
		groups.click();
	}
	public String title()
	{
		return driver.getTitle();
	}
}
