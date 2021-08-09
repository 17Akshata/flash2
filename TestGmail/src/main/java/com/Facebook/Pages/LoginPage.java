package com.Facebook.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook1.Bbase.TestBase;

public class LoginPage extends TestBase{
	//Page Factory -OR

	@FindBy(name="email")
	WebElement uname;

	@FindBy(name="pass")
	WebElement password;

	@FindBy(name="login")
	WebElement loginbttn;

	@FindBy(xpath="//a[text()='Forgotten password?']")
	WebElement frgotPass;

	@FindBy(id="u_0_2_Y6")
	WebElement signUp;

	@FindBy(xpath="//a[text()='Create a Page']")
	WebElement CreatePage;

	@FindBy(xpath="//img[@class='fb_logo _8ilh img']")
	WebElement logo;

	@FindBy(xpath="//div[@class='_8e4l mbl _6o _6s _mf']")
	WebElement checkTextx;

	//initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validLoginPageTitle()
	{
		return driver.getTitle();
	}

	public boolean checkLogo()
	{
		return logo.isDisplayed();
	}

	public String textCheck()
	{
		return checkTextx.getText();

	}
	
	public void CreatePage()
	{
		CreatePage.click();
	}
	
	public HomePage login(String un,String pwd) {
		uname.sendKeys(un);
		password.sendKeys(pwd);
		loginbttn.click();
		return new HomePage();
	}
	public frgotPassPage FrgotPassword() throws InterruptedException
	{
		Thread.sleep(3000);
		frgotPass.click();
		return new frgotPassPage();
	}
	public CreateNewAccount CreateNewPage() throws InterruptedException
	{
		Thread.sleep(3000);
		CreatePage.click();
		return new CreateNewAccount();
	}
	
	
}

