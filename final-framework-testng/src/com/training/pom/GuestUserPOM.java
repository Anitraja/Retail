package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GuestUserPOM {
	private WebDriver driver; 
	public GuestUserPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		//Actions act = new Actions(driver);
		//act.moveToElement(Cart).build();
	}
	// Element locator for product search
	@FindBy(id="search_button")
	private WebElement search;
	
	@FindBy(id="filter_keyword")
	private WebElement filter;
	
	@FindBy(xpath="//*[@id=\"ProductsSystem_YD9pMDOx\"]/div[1]/div/div/div[3]/div/div/div[1]/h4/a")
	private WebElement productselect; 
	
	// Adding elements to cart
	@FindBy(id="button-cart")
	private WebElement AddtoCart;
		
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li/h3/a/i")
	private WebElement Cart; 
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li/div/div/div[3]/a[1]")
	private WebElement ViewCart; 
	
	@FindBy(xpath="//*[@id=\"System_V2Exp1o9\"]/div[3]/div[2]/a")
	private WebElement Checkout; 
	
	@FindBy(xpath="//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[1]/div/div[2]/label/input")
	private WebElement Radiobtn; 
	
	@FindBy(id="button-account")
	private WebElement contbtn;
	
	@FindBy(id="input-payment-firstname")
	private WebElement fname;
	
	@FindBy(id="input-payment-lastname")
	private WebElement lname;
	
	@FindBy(id="input-payment-email")
	private WebElement email;
	
	@FindBy(id="input-payment-telephone")
	private WebElement phone;
	
	@FindBy(id="input-payment-address-1")
	private WebElement address;
	
	@FindBy(id="input-payment-city")
	private WebElement city;
	
	@FindBy(id="input-payment-zone")
	private WebElement state;
	
	@FindBy(id="button-guest")
	private WebElement conbtn;//Continue button
	
	@FindBy(xpath="//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea")
	private WebElement comments; 
	
	@FindBy(id="button-shipping-method")
	private WebElement cobtn;//Continue button
	
	@FindBy(xpath="//*[@id=\"collapse-payment-method\"]/div/div[2]/div[1]/label/input")
	private WebElement Rabtn; //Radio button
	
	@FindBy(id="button-payment-method")
	private WebElement contibtn;//Continue button
	
		public void search() throws InterruptedException {
		this.search.click();
		//Thread.sleep(1000);
		}
		public void filter(String filter) throws InterruptedException {
			this.filter.clear();
			this.filter.sendKeys(filter);
			this.filter.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
		}
		public void productselect() throws InterruptedException {
			this.productselect.click();
			Thread.sleep(1000);
		}
		public void AddtoCart() throws InterruptedException {
			this.AddtoCart.click();
			Thread.sleep(10000);
		}
		public void Cart() throws InterruptedException {
			Actions act = new Actions(driver);
			act.moveToElement(Cart).build().perform();
			Thread.sleep(2000);
			act.moveToElement(ViewCart).build().perform();
			Thread.sleep(2000);
			this.ViewCart.click();
		}
		public void Checkout() throws InterruptedException {
			this.Checkout.click(); 
			Thread.sleep(1000);
		}
		public void Radiobtn() throws InterruptedException {
			this.Radiobtn.click(); 
			Thread.sleep(1000);
			this.contbtn.click();
		}
		
		public void fname(String fname) {
			this.fname.clear();
			this.fname.sendKeys(fname);
		}
		public void lname(String lname) {
			this.lname.clear();
			this.lname.sendKeys(lname);
		}
		public void email(String email) {
			this.email.clear();
			this.email.sendKeys(email);
		}
		public void phone(String phone) {
			this.phone.clear();
			this.phone.sendKeys(phone);
		}
	
		public void address(String address) {
			this.address.clear();
			this.address.sendKeys(address);
		}
		
		public void city(String city) {
			this.city.clear();
			this.city.sendKeys(city);
		}
		public void state() throws InterruptedException {
		//this.country.clear();
		//this.country.sendKeys(city);
		Select se = new Select(this.state);
		this.state.click();
		se.selectByVisibleText("Karnataka");
		Thread.sleep(1000);
		this.conbtn.click();
		}
		
		public void comments(String comments) throws InterruptedException {
			this.comments.clear();
			this.comments.sendKeys(comments);
			Thread.sleep(1000);
			this.cobtn.click();
			Thread.sleep(1000);
			this.Rabtn.click();
			this.contibtn.click();
			
		}
		
}
