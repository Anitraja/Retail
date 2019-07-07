package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ChangePwdPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_006 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ChangePwdPOM ChangePwdPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		ChangePwdPOM = new ChangePwdPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

		
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void validLoginTest() {
		loginPOM.accounticon(); 
		loginPOM.sendUserName("manzoor@gmail.com");
		loginPOM.sendPassword("manzoor1");
		loginPOM.clickLoginBtn(); 
		System.out.println("Login to Retail successfully....");
		//screenShot.captureScreenShot("First");
	}
	@Test(priority=2)
	public void order() throws InterruptedException {
		ChangePwdPOM.ChangePwd(); 
		System.out.println("Change password page opened successfully....");
		ChangePwdPOM.sendPassword("mehadi");
		ChangePwdPOM.sendPasswordConfirm("mehadi");
		ChangePwdPOM.clickcontinueBtn(); 
		System.out.println("Password has been successfully changed....");
		screenShot.captureScreenShot("PwdChangeResult");
	}
}
