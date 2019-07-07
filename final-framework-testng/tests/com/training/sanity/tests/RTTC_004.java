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
import com.training.pom.MyOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_004 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private MyOrderPOM MyOrderPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		MyOrderPOM = new MyOrderPOM(driver);
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
		MyOrderPOM.Order(); 
		System.out.println("List of order had been displayed....");
		screenShot.captureScreenShot("Orderlist");
		MyOrderPOM.OrderView();
		System.out.println("Order view ....");
		screenShot.captureScreenShot("OrderView");
	}
	
}
