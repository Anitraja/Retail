package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePwdPOM {
	private WebDriver driver; 
	
	public ChangePwdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/align/ul/li[2]/a")
	private WebElement ChangePwd; 
	
	@FindBy(id="input-password")
	private WebElement Password; 
	
	@FindBy(id="input-confirm")
	private WebElement PasswordConfirm; 
	
	@FindBy(xpath="//*[@id=\"System_s3bhXNDb\"]/form/div/div[2]/input")
	private WebElement continueBtn;
	
		public void ChangePwd() throws InterruptedException {
		this.ChangePwd.click();
		Thread.sleep(1000);
		
	}
	
		public void sendPassword(String Password) {
			this.Password.clear();
			this.Password.sendKeys(Password);
		}
		public void sendPasswordConfirm(String PasswordConfirm) {
			this.PasswordConfirm.clear();
			this.PasswordConfirm.sendKeys(PasswordConfirm);
		}
		public void clickcontinueBtn() {
			this.continueBtn.click(); 
		}

}
