package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminLoginPOM;
import com.training.pom.RewardsPointPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RTTC_035 {
	private WebDriver driver;
	private String adminUrl;
	private AdminLoginPOM AdminLoginPOM;
	private RewardsPointPOM RewardsPointPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		AdminLoginPOM = new AdminLoginPOM(driver); 
		RewardsPointPOM = new RewardsPointPOM(driver); 
		adminUrl = properties.getProperty("AdminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
	}

		
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void validLoginTest() {
		AdminLoginPOM.sendUserName("admin");
		AdminLoginPOM.sendPassword("admin@123");
		AdminLoginPOM.clickLoginBtn(); 
		System.out.println("Login to Admin site successfully....");
	}
	@Test(priority=2)
	public void Catelog() throws InterruptedException {
		RewardsPointPOM.Catelog(); 
		RewardsPointPOM.Product();
		RewardsPointPOM.AddIcon();
		RewardsPointPOM.ProductName("Finger Ring");
		RewardsPointPOM.metaTag("Finger Ring for ladies");
		RewardsPointPOM.Data();
		RewardsPointPOM.model("SKU-012");
		RewardsPointPOM.price("500");
		RewardsPointPOM.quantity("50");
		RewardsPointPOM.link();
		RewardsPointPOM.category();
		screenShot.captureScreenShot("categoryDisplay");
		RewardsPointPOM.category("EARRINGS");
		RewardsPointPOM.Discount();
		RewardsPointPOM.AddDiscount();
		RewardsPointPOM.Quantity("1");
		RewardsPointPOM.price1("50");
		RewardsPointPOM.StartDate();
		RewardsPointPOM.EndDate();
		RewardsPointPOM.reward();
		RewardsPointPOM.points("20");
		RewardsPointPOM.save();
		
		System.out.println("Rewards point had been added....");
	}
	
}
