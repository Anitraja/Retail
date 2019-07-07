package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrderPOM {
private WebDriver driver; 
	
	public MyOrderPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[3]/a/span")
	@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/ul/li[1]/a")
	private WebElement Order; 
	
	@FindBy(xpath="//*[@id=\"System_s3bhXNDb\"]/div[1]/table/tbody/tr[1]/td[7]/a/i")
	private WebElement OrderView; 
	
	
	public void Order() throws InterruptedException {
		this.Order.click();
		//Actions act = new Actions(driver);
		//act.moveToElement(Order).build();
		//act.contextClick(Order).perform();
		Thread.sleep(3000);
		
	}
	public void OrderView() throws InterruptedException
	{
		this.OrderView.click();
		Thread.sleep(3000);
	}
	

}
