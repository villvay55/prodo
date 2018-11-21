package com.prod.managers.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.prod.employees.Pages.EmployeesPage;

public class ManagersScorePage {
	
	private WebDriver driver;
	
	private By managersLink = By.xpath(".//*[@id='AppBreadcrumbs']/ul/li[2]/a[text() = 'Managers']");
	
	
	public ManagersScorePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public EmployeesPage verifyManagers() throws InterruptedException {
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnAboveAverageEmployees();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnAverageEmployees();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnBelowEmployees();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		return new EmployeesPage(driver);
	}
	
	
	public void clickOnAboveAverageEmployees() throws InterruptedException {
		
		List<WebElement> employeesList = 	driver.findElements(By.xpath(".//*[@id='contentManagers']/div[3]/div[1]/div/ul/li"));
		
		int total_Employees = employeesList.size();
		
		System.out.println("Total Employees "+total_Employees);

		if(total_Employees == 0) {
			
			System.out.println("No employees in above average section");
			
		}else {
			
			Random rand = new Random();
	        int rand_int1 = rand.nextInt(total_Employees);
	        System.out.println(rand_int1);
	        employeesList.get(rand_int1).click();
	        
	        synchronized (driver)
			{
			    driver.wait(3000);
			}
			
	        WebElement managersLinkElement =  driver.findElement(managersLink);
	        managersLinkElement.click();
	        
	        synchronized (driver)
			{
			    driver.wait(3000);
			}
	        
		}
	        
		
		
	}

	public void clickOnAverageEmployees() throws InterruptedException {
		
		List<WebElement> employeesList = 	driver.findElements(By.xpath(".//*[@id='contentManagers']/div[3]/div[2]/div/ul/li"));
		
		int total_Employees = employeesList.size();
		
		System.out.println("Total Employees "+total_Employees);

		if(total_Employees == 0) {
			
			System.out.println("No employees in average section");
			
		}else {
			
			Random rand = new Random();
	        int rand_int1 = rand.nextInt(total_Employees);
	        System.out.println(rand_int1);
	        employeesList.get(rand_int1).click();
	        synchronized (driver)
			{
			    driver.wait(3000);
			}
	        
	        WebElement managersLinkElement =  driver.findElement(managersLink);
	        managersLinkElement.click();
	        
	        synchronized (driver)
			{
			    driver.wait(3000);
			}
		}
	        
		
		
	}

	public void clickOnBelowEmployees() throws InterruptedException {
	
	List<WebElement> employeesList = 	driver.findElements(By.xpath(".//*[@id='contentManagers']/div[3]/div[3]/div/ul/li"));
	
	int total_Employees = employeesList.size();
	
	System.out.println("Total Employees "+total_Employees);

	if(total_Employees == 0) {
		
		System.out.println("No employees in below average section");
		
	}else {
		
		Random rand = new Random();
        int rand_int1 = rand.nextInt(total_Employees);
        System.out.println(rand_int1);
        employeesList.get(rand_int1).click();
        synchronized (driver)
		{
		    driver.wait(3000);
		}
		
        WebElement managersLinkElement =  driver.findElement(managersLink);
        managersLinkElement.click();
        
        synchronized (driver)
		{
		    driver.wait(3000);
		}
	}
        
	
}

}
	
