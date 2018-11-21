package com.prod.product.crmSetting.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrmZohoPage {

	private WebDriver driver;
	
	private By accessTokenTxtBox = By.xpath(".//*[@id='system-zoho']/form/div[1]/div/input");
	private By zohosaveBtn = By.xpath(".//*[@id='system-zoho']/form/div[2]/input[1]");
	
	
	public CrmZohoPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void configureZohoProduct(String prodcutName , String zohoToken) throws InterruptedException {
		
		selectProduct(prodcutName);
		
		synchronized (driver)
		{
		    driver.wait(2000);
		}
		
		enterAccessToken(zohoToken);
		
		synchronized (driver)
		{
		    driver.wait(2000);
		}
		clickOnSaveBtn();
		
		
	}
	
	
	public void selectProduct(String prodcutName) {
		

		Select systemDropDownElement = new Select(driver.findElement(By.xpath(".//*[@id='system']")));
		
		systemDropDownElement.selectByIndex(1);
		
	}
	
	public void enterAccessToken(String zohoToken) {
		
		WebElement accessTokenTxtBoxElement = driver.findElement(accessTokenTxtBox);
		
		if(accessTokenTxtBoxElement.isDisplayed()) {
			
			accessTokenTxtBoxElement.sendKeys(zohoToken);
		}
	}

	public void clickOnSaveBtn() {
		
		WebElement zohosaveBtnElement =  driver.findElement(zohosaveBtn);
		
		if(zohosaveBtnElement.isDisplayed()) {
			
			zohosaveBtnElement.click();
		}
		
		else System.out.println("Save Btn not found");
		
	}
	
	


	
}