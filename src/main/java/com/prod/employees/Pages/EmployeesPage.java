package com.prod.employees.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class EmployeesPage {


	private WebDriver driver;
	
	private By employeesTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[1]/li[3]/a[text() = 'Employees']");
	
	
	public EmployeesPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public EmployeesSearch verifyEmployeesPage() throws InterruptedException {
		
		
		
		clickOnEmployees();
		
		synchronized (driver)
		{
		    driver.wait(5000);
		}
		
		return new EmployeesSearch(driver);
		
	}
	
	
	public void clickOnEmployees() {
		
		WebElement employeesTabElement =  driver.findElement(employeesTab);
		
		if(employeesTabElement.isDisplayed()) {
			
			employeesTabElement.click();
		}
		
		else System.out.println("Employees Tab not found");
		
	}

}
