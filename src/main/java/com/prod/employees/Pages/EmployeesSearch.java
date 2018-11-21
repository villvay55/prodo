package com.prod.employees.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.prod.settings.Pages.SettingsPage;

public class EmployeesSearch {

private WebDriver driver;

	private By employeesTxtBox = By.xpath(".//*[@id='contentEmployees']/div[4]/div/div[1]/input");
	private By employeesTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[1]/li[3]/a[text() = 'Employees']");
	//.//*[@id='empSettings']/div[2]/div/table/tbody/tr[contains(@style,'display: block;')]
	
	public EmployeesSearch(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public SettingsPage verifyEmployees(String name , String role , String manager) throws InterruptedException {
		
		employeeSearch(name);
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		/*employeeSearch(name,role);
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		employeeSearch(name,role,manager);*/
		
		return new SettingsPage(driver);
	}


	public void employeeSearch(String name) throws InterruptedException {
		
		WebElement employeesTabElement =  driver.findElement(employeesTxtBox);
		
		if(employeesTabElement.isDisplayed()) {
			
			employeesTabElement.sendKeys(name);
			
			synchronized (driver)
			{
			    driver.wait(5000);
			}
			

			//validateEmployeeSearch();
			
			clickOnEmployeesTab();
		
		}
		
		else System.out.println("Employees Textbox not found");
		
	}
	
	public void employeeSearch(String name , String role) throws InterruptedException {
		
		WebElement employeesTabElement =  driver.findElement(employeesTxtBox);
		
		if(employeesTabElement.isDisplayed()) {
			
			employeesTabElement.click();
			
		}
		
		
		
		else {
			
			System.out.println("Employees Textbox not found");
		}
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		Select userRoleDropDown = new Select(driver.findElement(By.xpath(".//*[@id='userrole']")));
		//userRoleDropDown.selectByValue(role);
		userRoleDropDown.selectByIndex(1);
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		clickOnEmployeesTab();
	}
	
	public void employeeSearch(String name , String role, String manager) throws InterruptedException {
		
		
		WebElement employeesTabElement =  driver.findElement(employeesTxtBox);
		
		if(employeesTabElement.isDisplayed()) {
			
			employeesTabElement.click();
			
		}
		
		
		
		else {
			
			System.out.println("Employees Textbox not found");
		}
		
		
		Select userRoleDropDown = new Select(driver.findElement(By.xpath(".//*[@id='userrole']")));
		userRoleDropDown.selectByValue(role);
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		Select managerDropDown = new Select(driver.findElement(By.xpath(".//*[@id='manager']")));
		managerDropDown.selectByValue(manager);
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		clickOnEmployeesTab();
	}
	
	public void clickOnEmployeesTab() throws InterruptedException {
		
		WebElement employeesTabElement =  driver.findElement(employeesTab);
		
		if(employeesTabElement.isDisplayed()) {
			
			employeesTabElement.click();
			
			synchronized (driver)
			{
			    driver.wait(3000);
			}
		}
		
		else System.out.println("Employees Tab not found");
	}
	
	public void validateEmployeeSearch() throws InterruptedException {
		
		driver.findElement(By.xpath(".//*[@id='contentSettings']/div[1]/ul/li[1]/a")).click();
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		List<WebElement> resultGrid = 	driver.findElements(By.xpath(".//*[@id='empSettings']/div[2]/div/table/tbody/tr[contains(@style,'display: block;')]"));
		
		int total_Employees = resultGrid.size();
	  
	    synchronized (driver)
		{
		    driver.wait(3000);
		}
		System.out.println("Total Employees after search "+total_Employees);

		if(total_Employees == 0) {
			
			System.out.println("No employees in search criteria");
			
		}else {
			
			Random rand = new Random();
	        int rand_int1 = rand.nextInt(total_Employees);
	        System.out.println(rand_int1);
	       
	        resultGrid.get(rand_int1).click();
	        synchronized (driver)
			{
			    driver.wait(3000);
			}
		
	}
}
}
