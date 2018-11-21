package com.prod.dashboard.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage {


	private WebDriver driver;

	private By dashboardTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[1]/li[1]/a[text() = 'Dashboard']");
	
	
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public CalendarSearchPage verifyDashboard() throws InterruptedException {
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOndashboard();
		synchronized (driver)
		{
		    driver.wait(5000);
		}
		
		
		return new CalendarSearchPage(driver);
	}
	
	
	public void clickOndashboard() {
		
		WebElement dashboardTabElement =  driver.findElement(dashboardTab);
		
		if(dashboardTabElement.isDisplayed()) {
			
			dashboardTabElement.click();
		}
		
		else System.out.println("Dashbaord Tab not found");
		
	}

	
	public boolean verifyDashboardPage() {	
		WebElement dashboardTxtElement  = driver.findElement(By.xpath(".//*[@id='contentMain']/div[1]/div/div/h2[text() = 'Organization Prodoscore']"));
		boolean dashboardStatus = dashboardTxtElement.isDisplayed();
		return dashboardStatus;
	}
}
