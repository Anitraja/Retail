package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.EditAccountPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_005 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private EditAccountPOM EditAccountPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		EditAccountPOM = new EditAccountPOM(driver);
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
		EditAccountPOM.EditAccount(); 
		System.out.println("Edit Account page opened successfully....");
		EditAccountPOM.sendfirstName("manzoor");
		EditAccountPOM.sendlastName("mehadi");
		EditAccountPOM.sendmail("manzoor@gmail.com");
		EditAccountPOM.sendtelephone("9876543210");
		EditAccountPOM.clickcontinueBtn(); 
		System.out.println("Edit Account has been successfully updated....");
		screenShot.captureScreenShot("EditAccountResult");
	}
}
