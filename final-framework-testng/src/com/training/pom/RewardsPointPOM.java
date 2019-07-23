package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RewardsPointPOM {
	private WebDriver driver; 
	public RewardsPointPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	// Element locator for product return
	@FindBy(id="menu-catalog")
	private WebElement Catelog; 
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[2]/a")
	private WebElement Product; 
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a/i")
	private WebElement AddIcon; 
	
	@FindBy(id="input-name1")
	private WebElement ProductName;
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTag;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[2]/a")
	private WebElement Data; 
	
	@FindBy(id="input-model")
	private WebElement model;
	
	@FindBy(id="input-price")
	private WebElement price; 
	
	@FindBy(id="input-quantity")
	private WebElement quantity;

	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[3]/a")
	private WebElement link; 
	
	@FindBy(id="input-category")
	private WebElement category;
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[7]/a")
	private WebElement Discount; 
	
	@FindBy(xpath="//*[@id=\"discount\"]/tfoot/tr/td[2]/button/i")
	private WebElement AddDiscount;
	
	@FindBy(xpath="//*[@id=\"discount-row0\"]/td[2]/input")
	private WebElement Quantity; 
	
	@FindBy(xpath="//*[@id=\"discount-row0\"]/td[4]/input")
	private WebElement price1; 
	
	@FindBy(xpath="//*[@id=\"discount-row0\"]/td[5]/div/span/button/i")
	private WebElement StartDate; 
	
	@FindBy(xpath="/html/body/div[5]/div/div[1]/table/tbody/tr[3]/td[1]")
	private WebElement todayDate;
	
	@FindBy(xpath="//*[@id=\"discount-row0\"]/td[6]/div/span/button")
	private WebElement EndDate; 
	
	@FindBy(xpath="/html/body/div[6]/div/div[1]/table/tbody/tr[3]/td[2]")
	private WebElement TomDate; 
	
	@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[10]/a")
	private WebElement reward; 
	
	@FindBy(id="input-points")
	private WebElement points;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement save; 
	
	
		public void Catelog() throws InterruptedException {
		this.Catelog.click();
		Thread.sleep(1000);
		}
		public void Product() throws InterruptedException {
			this.Product.click();
			Thread.sleep(1000);
		}
		public void AddIcon() throws InterruptedException {
			this.AddIcon.click();
			Thread.sleep(1000);
		}
		public void ProductName(String ProductName) {
			this.ProductName.clear();
			this.ProductName.sendKeys(ProductName);
		}
		public void metaTag(String metaTag) {
			this.metaTag.clear();
			this.metaTag.sendKeys(metaTag);
		}
		public void Data() throws InterruptedException {
			this.Data.click(); 
			Thread.sleep(1000);
		}	
		public void model(String model) {
			this.model.clear();
			this.model.sendKeys(model);
		}
		public void price(String price) {
			this.price.clear();
			this.price.sendKeys(price);
		}
		public void quantity(String quantity) {
			this.quantity.clear();
			this.quantity.sendKeys(quantity);
		}
		public void link() throws InterruptedException {
			this.link.click(); 
			Thread.sleep(1000);
		}	
		public void category() throws InterruptedException {
			this.category.click(); 
			Thread.sleep(1000);
		}
		public void category(String category) {
		this.category.clear();
		this.category.sendKeys(category);
		}
		public void Discount() throws InterruptedException {
			this.Discount.click(); 
			Thread.sleep(1000);
		}
		public void AddDiscount() throws InterruptedException {
			this.AddDiscount.click(); 
			Thread.sleep(1000);
		}
		public void Quantity(String Quantity) {
			this.Quantity.clear();
			this.Quantity.sendKeys(Quantity);
		}
		public void price1(String price1) {
			this.price1.clear();
			this.price1.sendKeys(price1);
		}
		public void StartDate() throws InterruptedException {
			this.StartDate.click();
			Thread.sleep(1000);
			this.todayDate.click();			
		}
		public void EndDate() throws InterruptedException {
			this.EndDate.click();
			Thread.sleep(1000);
			this.TomDate.click();
			Thread.sleep(3000);
		}
		public void reward() throws InterruptedException {
			this.reward.click();
			Thread.sleep(1000);
		}
		public void points(String points) {
			this.points.clear();
			this.points.sendKeys(points);
		}
		public void save() throws InterruptedException {
			this.save.click();
		}
}
