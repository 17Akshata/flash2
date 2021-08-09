package com.Facebook.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Facebook.Pages.HomePage;
import com.Facebook.Pages.LoginPage;
import com.facebook1.Bbase.TestBase;

public class homePageTest extends TestBase{
HomePage homePge;
LoginPage log;
	 public homePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		
		initialization();
		log=new LoginPage();
		log.login(prop.getProperty("username"), prop.getProperty("password"));
		homePge= new HomePage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=3)
	public void watch()
	{
		homePge.clickWatch();
	}
	
	@Test(priority=2)
	public void groups()
	{
		homePge.groupsClick();
	}
	
	@Test(priority=1)
	public void checkTitle()
	{
	String titlechekc=	homePge.title();
	System.out.println(titlechekc);
	Assert.assertEquals(titlechekc, "Facebook","page title is not matched");
	}
	
}
