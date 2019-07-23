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
import com.training.pom.GuestUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_034 {
	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	//private MyOrderPOM MyOrderPOM;
	private GuestUserPOM GuestUserPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM(driver); 
		//MyOrderPOM = new MyOrderPOM(driver);
		GuestUserPOM = new GuestUserPOM(driver);
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
	// to place an order as guest user
	@Test(priority=3)
	public void ReturnProduct() throws InterruptedException {
		GuestUserPOM.search(); // To search product
		GuestUserPOM.filter("Donec suscipit"); // To filter product by name
		GuestUserPOM.productselect();
		GuestUserPOM.AddtoCart();
		screenShot.captureScreenShot("ShoppingCartupdated");
		GuestUserPOM.Cart();
		GuestUserPOM.Checkout();
		GuestUserPOM.Radiobtn();
		GuestUserPOM.fname("Bhavani");
		GuestUserPOM.lname("Kande");
		GuestUserPOM.email("BK@gmail.com");
		GuestUserPOM.phone("1234567891"); 
		GuestUserPOM.address("manyata");
		GuestUserPOM.city("Bangalore");
		GuestUserPOM.state();
		GuestUserPOM.comments("product should be same as displayed");
		System.out.println("guest checkout is completed.....");
		screenShot.captureScreenShot("Errormessage");
	}
}
