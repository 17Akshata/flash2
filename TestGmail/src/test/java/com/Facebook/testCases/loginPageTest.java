package com.Facebook.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Facebook.Pages.HomePage;
import com.Facebook.Pages.LoginPage;
import com.facebook1.Bbase.TestBase;
import com.facebook1.Util.testUtil;


public class loginPageTest extends TestBase{
	
    public LoginPage loginPage;
	public HomePage hmePage;

	public loginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		loginPage=new LoginPage();
	}

	@Test(priority=1)
	public void validatePageTitle() throws InterruptedException
	{
		Thread.sleep(3000);
		String logPageTitle=loginPage.validLoginPageTitle();
		
		System.out.println("title  "+logPageTitle+"hell");
		Assert.assertEquals(logPageTitle, "Facebook - ???? ??? ???? ???? ???");
	}
	@Test(priority=2)
	public void Checklogo()
	{
		boolean logo=	loginPage.checkLogo();
		System.out.println(logo);
		Assert.assertTrue(logo);
	}
	@Test(priority=3)
	public void loginToPage()
	{
		hmePage=	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test(priority=4)
	public void frgotPasswrd() throws InterruptedException
	{
		Thread.sleep(10000);
		loginPage.FrgotPassword();
	}
	@Test(priority=5)
	public void CreatePage() throws Exception
	{
		try {
			Thread.sleep(10000);
			loginPage.CreatePage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
			testUtil.takeSnapShot();
			e.printStackTrace();
		}
	}
	
	
	@Test(priority=6)
	public void checkText() throws InterruptedException
	{
		Thread.sleep(10000);
		String txt=loginPage.textCheck();
		
		Assert.assertEquals(txt, "Click your picture or add an account.");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
