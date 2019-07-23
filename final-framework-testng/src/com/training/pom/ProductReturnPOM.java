package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductReturnPOM {
private WebDriver driver; 
	
	public ProductReturnPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	// Element locator for product return
	@FindBy(xpath="//*[@id=\"System_s3bhXNDb\"]/div/div[1]/table/tbody/tr/td[6]/a[2]/i")
	private WebElement ReturnProduct; 
	
	@FindBy(xpath="//*[@id=\"return_request_form\"]/fieldset[2]/div[4]/div/div[1]/label/input")
	private WebElement ReturnRsnBtn; 
	
	@FindBy(xpath="//*[@id=\"return_request_form\"]/fieldset[2]/div[5]/div/label[1]/input")
	private WebElement ProductOpen; 
	
	@FindBy(id="input-comment")
	private WebElement Reason;
	
	@FindBy(id="input-product")
	private WebElement ProductName;
	
	@FindBy(id="input-model")
	private WebElement ProductCode;
	
	@FindBy(xpath="//*[@id=\"return_request_form\"]/div/div/input")
	private WebElement submitBtn; 
	
		public void ReturnProduct() throws InterruptedException {
		this.ReturnProduct.click();
		Thread.sleep(1000);
		}
		public void ReturnRsnBtn() throws InterruptedException {
			this.ReturnRsnBtn.click();
			//Boolean R1=this.ReturnProduct.isSelected();
			//System.out.println("Reason for product return selected " + R1);
			Thread.sleep(1000);
		}
		public void ProductOpen() throws InterruptedException {
			this.ProductOpen.click();
			Thread.sleep(1000);
		}
		public void ProductName(String ProductName) {
			this.ProductName.clear();
			this.ProductName.sendKeys(ProductName);
		}
		public void ProductCode(String ProductCode) {
			this.ProductCode.clear();
			this.ProductCode.sendKeys(ProductCode);
		}
	
		public void Reason(String Reason) {
			this.Reason.clear();
			this.Reason.sendKeys(Reason);
		}
		public void submitBtn() {
			this.submitBtn.click(); 
		}
		

}
