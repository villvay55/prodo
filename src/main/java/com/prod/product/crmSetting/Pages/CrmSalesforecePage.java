package com.prod.product.crmSetting.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrmSalesforecePage {

	private WebDriver driver;
	
	private By emailTxtBox = By.xpath(".//*[@id='system-salesforce']/form/div[1]/div/input");
	private By passwordTxtBox = By.xpath(".//*[@id='system-salesforce']/form/div[2]/div/input");
	private By tokenTxtBox = By.xpath(".//*[@id='system-salesforce']/form/div[3]/div/input");
	private By salesforecesaveBtn = By.xpath(".//*[@id='system-salesforce']/form/div[4]/input[1]");
	
	public CrmSalesforecePage(WebDriver driver) {
		
		this.driver=driver;
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
}
