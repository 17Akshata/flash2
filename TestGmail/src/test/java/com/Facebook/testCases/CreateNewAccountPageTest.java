package com.Facebook.testCases;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Facebook.Pages.CreateNewAccount;
import com.Facebook.Pages.LoginPage;
import com.facebook1.Bbase.TestBase;
import com.facebook1.Util.testUtil;

public class CreateNewAccountPageTest extends TestBase{
	TestBase acc;
	LoginPage logTest;
	public CreateNewAccountPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialization();
		logTest.CreateNewPage();
				
	}
	
@Test
	public void signUP()
	{
	
	CreateNewAccount createAcc=new CreateNewAccount();
	//createAcc.register(testUtil.str1, testUtil.str1, testUtil.);
	createAcc.register(testUtil.str1,testUtil.str1,testUtil.str1);
		
	}
}
