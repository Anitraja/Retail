package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPOM {
	private WebDriver driver; 
	
	public EditAccountPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/align/ul/li[1]/a")
	private WebElement EditAccount; 
	
	@FindBy(id="input-firstname")
	private WebElement firstName; 
	
	@FindBy(id="input-lastname")
	private WebElement lastName; 
	
	@FindBy(id="input-email")
	private WebElement mail;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(xpath="//*[@id=\"edit_account_form\"]/div/div[2]/input")
	private WebElement continueBtn; 
	
		public void EditAccount() throws InterruptedException {
		this.EditAccount.click();
		Thread.sleep(1000);
		
	}
	
		public void sendfirstName(String firstName) {
			this.firstName.clear();
			this.firstName.sendKeys(firstName);
		}
		public void sendlastName(String lastName) {
			this.lastName.clear();
			this.lastName.sendKeys(lastName);
		}
		public void sendmail(String mail) {
			this.mail.clear();
			this.mail.sendKeys(mail);
		}
		public void sendtelephone(String telephone) {
			this.telephone.clear();
			this.telephone.sendKeys(telephone);
		}
		public void clickcontinueBtn() {
			this.continueBtn.click(); 
		}
}
