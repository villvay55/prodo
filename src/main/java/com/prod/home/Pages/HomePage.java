package com.prod.home.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.prod.dashboard.Pages.DashBoardPage;

public class HomePage {
	
	private WebDriver driver;

	private By dashboardTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[1]/li[1]/a[text() = 'Dashboard']");
	private By managersTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[1]/li[2]/a[text() = 'Managers']");
	private By employeesTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[1]/li[3]/a[text() = 'Employees']");
	private By correlationsTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[1]/li[4]/a[text() = 'Correlations']");
	private By myProfileTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[2]/li[1]/a[text() = 'My Profile']");
	private By settingsTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[2]/li[2]/a[text() = 'Settings']");

	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public DashBoardPage verifyTab() throws InterruptedException {
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnmanagers();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnemployees();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOncorrelations();
		synchronized (driver)
		{
		    driver.wait(5000);
		}
		clickOnprofile();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnsettings();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		return new DashBoardPage(driver);
	}
	
	public void clickOndashboard() {
		
		WebElement dashboardTabElement =  driver.findElement(dashboardTab);
		
		if(dashboardTabElement.isDisplayed()) {
			
			dashboardTabElement.click();
		}
		
		else System.out.println("Dashbaord Tab not found");
		
	}

	public void clickOnmanagers() {
		
		WebElement managersTabElement =  driver.findElement(managersTab);
		
		if(managersTabElement.isDisplayed()) {
			
			managersTabElement.click();
		}
		
		else System.out.println("Managers Tab not found");
		
	}
	
	public void clickOnemployees() {
		
		WebElement employeesTabElement =  driver.findElement(employeesTab);
		
		if(employeesTabElement.isDisplayed()) {
			
			employeesTabElement.click();
		}
		
		else System.out.println("Employees Tab not found");
		
	}
	
	public void clickOncorrelations() {
		
		WebElement correlationsTabElement =  driver.findElement(correlationsTab);
		
		if(correlationsTabElement.isDisplayed()) {
			
			correlationsTabElement.click();
		}
		
		else System.out.println("Correlations Tab not found");
		
	}
	
	public void clickOnprofile() {
		
		WebElement myProfileTabElement =  driver.findElement(myProfileTab);
		
		if(myProfileTabElement.isDisplayed()) {
			
			myProfileTabElement.click();
		}
		
		else System.out.println("My profile Tab not found");
		
	}
	
	public void clickOnsettings() {
		
		WebElement settingsTabTabElement =  driver.findElement(settingsTab);
		
		if(settingsTabTabElement.isDisplayed()) {
			
			settingsTabTabElement.click();
		}
		
		else System.out.println("Settings Tab not found");
		
	}
	

}
