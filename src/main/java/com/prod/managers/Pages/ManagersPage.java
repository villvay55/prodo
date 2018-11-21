package com.prod.managers.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ManagersPage {
	
	private WebDriver driver;
	
	private By managersTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[1]/li[2]/a[text() = 'Managers']");
	
	public ManagersPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public ManagersScorePage verifyManagersPage() throws InterruptedException {
		
		
		
		clickOnManagers();
		
		synchronized (driver)
		{
		    driver.wait(5000);
		}
		
		return new ManagersScorePage(driver);
		
	}
	
	
	public void clickOnManagers() {
		
		WebElement dashboardTabElement =  driver.findElement(managersTab);
		
		if(dashboardTabElement.isDisplayed()) {
			
			dashboardTabElement.click();
		}
		
		else System.out.println("Managers Tab not found");
		
	}

	
}

