package com.prod.product.crmSetting.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CrmProductPage {


	private WebDriver driver;
	
	//Salesforece 
	private By emailTxtBox = By.xpath(".//*[@id='system-salesforce']/form/div[1]/div/input");
	private By passwordTxtBox = By.xpath(".//*[@id='system-salesforce']/form/div[2]/div/input");
	private By tokenTxtBox = By.xpath(".//*[@id='system-salesforce']/form/div[3]/div/input");
	private By salesforecesaveBtn = By.xpath(".//*[@id='system-salesforce']/form/div[4]/input[1]");
	private By salesforecedisconnectBtn = By.xpath(".//*[@id='system-salesforce']/form/div[4]/input[2]");
	
	//Zoho 
	private By accessTokenTxtBox = By.xpath(".//*[@id='system-zoho']/form/div[1]/div/input");
	
	//SugerCrm
	
	private By sugerInstanceTxtBox = By.xpath(".//*[@id='system-sugarCRM']/form/div[1]/div/input");
	private By sugerUsernameTxtBox  = By.xpath(".//*[@id='system-sugarCRM']/form/div[2]/div/input");
	private By sugerPasswordTxtBox = By.xpath(".//*[@id='system-sugarCRM']/form/div[3]/div/input");
	private By sugerConsumerKeyTxtBox = By.xpath(".//*[@id='system-sugarCRM']/form/div[4]/div[1]/input");
	private By sugerConsumerSecretTxtBox  = By.xpath(".//*[@id='system-sugarCRM']/form/div[5]/div[1]/input");
	
	
	
	private By changeCredentialsBtn = By.xpath(".//*[@id='crmSettings']/div[1]/div/input");
	
	
	public CrmProductPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public PhoneProductPage verifyAddingProduct(String prodcutName, String email, String password, String tokenId) throws InterruptedException {
		
		driver.get("http://stage.prodoscore.com/#settings/products/crm-system");
		synchronized (driver)
		{
		    driver.wait(5000);
		}
		
		if(verifyconnection() == false) {
			
			configureProduct(prodcutName, email, password, tokenId);
			
		}else {
			
			clickOnDisconnectBtn();
			configureProduct(prodcutName, email, password, tokenId);
		}
	
		
		return new PhoneProductPage(driver);
		
	}
	
	public boolean verifyconnection() {
		
		
		WebElement changeCredentialsBtnElement = driver.findElement(changeCredentialsBtn);
		
		if(changeCredentialsBtnElement.isDisplayed()) {
			return true;
		}else
			
			return false;
		
		
		
	}
	
	public void configureProduct(String prodcutName, String email, String password, String tokenId) throws InterruptedException {
		
		selectProduct(prodcutName);
		
		synchronized (driver)
		{
		    driver.wait(2000);
		}
		
		enterEmail(email);
		
		synchronized (driver)
		{
		    driver.wait(2000);
		}
		
		enterPassword(password);
		
		synchronized (driver)
		{
		    driver.wait(2000);
		}
		
		enterToken(tokenId);
		
		synchronized (driver)
		{
		    driver.wait(2000);
		}
		
		clickOnSaveBtn();
		
		synchronized (driver)
		{
		    driver.wait(8000);
		}
		
		
		//clickOnDisconnectBtn();
		
		synchronized (driver)
		{
		    driver.wait(8000);
		}
		
	}
	public void selectProduct(String prodcutName) {
		

		Select systemDropDownElement = new Select(driver.findElement(By.xpath(".//*[@id='system']")));
		
		systemDropDownElement.selectByIndex(2);
		
	}
	
	public void enterEmail(String email) {
		
		WebElement emailTxtBoxElement = driver.findElement(emailTxtBox);
		
		if(emailTxtBoxElement.isDisplayed()) {
			
			emailTxtBoxElement.sendKeys(email);
		}
		
	}

	public void enterPassword(String password) {
	
	WebElement passwordTxtBoxElement = driver.findElement(passwordTxtBox);
	
	if(passwordTxtBoxElement.isDisplayed()) {
		
		passwordTxtBoxElement.sendKeys(password);
	}
	
}

	public void enterToken(String tokenId) {
	
	WebElement tokenTxtBoxElement = driver.findElement(tokenTxtBox);
	
	if(tokenTxtBoxElement.isDisplayed()) {
		
		tokenTxtBoxElement.sendKeys(tokenId);
	}
	
}
	public void clickOnSaveBtn() {
		
		WebElement salesforecesaveBtnElement =  driver.findElement(salesforecesaveBtn);
		
		if(salesforecesaveBtnElement.isDisplayed()) {
			
			salesforecesaveBtnElement.click();
		}
		
		else System.out.println("Save Btn not found");
		
	}
	
	public void clickOnDisconnectBtn() throws InterruptedException {
		
		WebElement changeCredentialsBtnElement = driver.findElement(changeCredentialsBtn);
		
		changeCredentialsBtnElement.click();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		WebElement salesforecedisconnectBtnElement =  driver.findElement(salesforecedisconnectBtn);
		
		if(salesforecedisconnectBtnElement.isDisplayed()) {
			
			salesforecedisconnectBtnElement.click();
		}
		
		else System.out.println("Disconnect not found");
		
	}

}
