package com.facebook1.Bbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.facebook1.Util.WebeventListener;
import com.facebook1.Util.testUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver evn;
	public static WebeventListener webList;

	public static void BaseClass() throws Exception {
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:\\Projects\\TestGmail\\src\\main\\java\\com\\facebook1\\config\\config.properties");
		prop.load(ip);

	}
	public  static void initialization() throws Exception 
	{
		BaseClass();
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		if(browsername.equals("chrome")) {
			//			System.setProperty("webdriver.chrome.driver", "C:\\Projects\\TestGmail\\drivers\\chromedriver.exe");
			//			driver=new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();		
		}
		else if (browsername.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "/TestGmail/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}

//		evn=new EventFiringWebDriver(driver);
//		webList=new WebeventListener();
//		evn.register(webList);
//		driver=evn;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(testUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);


	}


}
