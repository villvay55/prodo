package com.prod.product.crmSetting.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CrmProductPage2 {
	
	private WebDriver driver;
	private By changeCredentialsBtn = By.xpath(".//*[@id='crmSettings']/div[1]/div/input");
	private By availableModuleTxt = By.xpath(".//*[@id='crmSettings']/div[3]/div/div/h2");
	private By salesforecedisconnectBtn = By.xpath(".//*[@id='system-salesforce']/form/div[4]/input[2]");
	private By zohodisconnectBtn = By.xpath(".//*[@id='system-zoho']/form/div[2]/input[2]");
	
	public CrmProductPage2(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public PhoneProductPage verifyAddingProduct(String prodcutName , String zohoToken) throws InterruptedException {
		
	
		driver.get("http://stage.prodoscore.com/#settings/products/crm-system");
		synchronized (driver)
		{
		    driver.wait(5000);
		}
		
		if(verifyconnection() == false) {
			CrmZohoPage CrmZohoPageobj1 = new  CrmZohoPage(driver);
			System.out.println("verifyconnection");
			CrmZohoPageobj1.configureZohoProduct(prodcutName, zohoToken);
			synchronized (driver)
			{
			    driver.wait(6000);
			}
			
		}else {
			System.out.println("else verifyconnection");
			availableModule();
			CrmZohoPage CrmZohoPageobj2 = new  CrmZohoPage(driver);
			clickOnChangeCredentials();
			synchronized (driver)
			{
			    driver.wait(3000);
			}
			
			clickOnDisconnectBtn();
			synchronized (driver)
			{
			    driver.wait(5000);
			}
			
			CrmZohoPageobj2.configureZohoProduct(prodcutName, zohoToken);
			synchronized (driver)
			{
			    driver.wait(6000);
			}
		}
			return new PhoneProductPage(driver);
	
	}	
	
		public PhoneProductPage verifyAddingProduct(String prodcutName, String email, String password, String tokenId) throws InterruptedException {
			
			
			driver.get("http://stage.prodoscore.com/#settings/products/crm-system");
			synchronized (driver)
			{
			    driver.wait(5000);
			}
			
			if(verifyconnection() == false) {
				CrmSalesforecePage CrmSalesforecePageobj1 = new  CrmSalesforecePage(driver);
				System.out.println("verifyconnection");
				CrmSalesforecePageobj1.configureProduct(prodcutName, email,password,tokenId);
				synchronized (driver)
				{
				    driver.wait(6000);
				}
				
			}else {
				System.out.println("else verifyconnection");
				availableModule();
				CrmSalesforecePage CrmSalesforecePageobj2 = new  CrmSalesforecePage(driver);
				clickOnChangeCredentials();
				synchronized (driver)
				{
				    driver.wait(3000);
				}
				
				clickOnDisconnectBtn();
				synchronized (driver)
				{
				    driver.wait(5000);
				}
				
				CrmSalesforecePageobj2.configureProduct(prodcutName, email,password,tokenId);
				synchronized (driver)
				{
				    driver.wait(6000);
				}
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
	
	public String  availableModule() {
		
		WebElement availableModuleTxtElement = driver.findElement(availableModuleTxt);
		String availableModule = availableModuleTxtElement.getText();
		
		return availableModule;
	}
	
	
	public void clickOnChangeCredentials() throws InterruptedException {
		
		WebElement changeCredentialsBtnElement = driver.findElement(changeCredentialsBtn);
		
		changeCredentialsBtnElement.click();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}

		
	}
	
	public void clickOnDisconnectBtn() throws InterruptedException {
		
		System.out.println("clickOnDisconnectBtn");
		
		if(availableModule().equals("Available modules for Salesforce")) {
			
			WebElement salesforecedisconnectBtnElement =  driver.findElement(salesforecedisconnectBtn);
			
			if(salesforecedisconnectBtnElement.isDisplayed()) {
				
				salesforecedisconnectBtnElement.click();
			}
			
			else System.out.println("Disconnect not found");
			
		}else if(availableModule().equals("Available modules for ZOHO")){
			
			
			WebElement zohodisconnectBtnElement =  driver.findElement(zohodisconnectBtn);
			
			if(zohodisconnectBtnElement.isDisplayed()) {
				
				zohodisconnectBtnElement.click();
			}
			
			else System.out.println("Disconnect not found");
		}
		
		
	}
	
	
}
