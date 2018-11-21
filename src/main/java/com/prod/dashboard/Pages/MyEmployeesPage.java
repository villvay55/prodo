package com.prod.dashboard.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.prod.managers.Pages.ManagersPage;

public class MyEmployeesPage {

		private WebDriver driver;
		
		private By dashboardTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[1]/li[1]/a[text() = 'Dashboard']");
		private By myEmployeesTxt = By.xpath(".//*[@id='contentMain']/div[2]/div[1]/div[2]/ul/li[1]/a/div[1]/p");
		private By verifyEmployee = By.xpath(".//*[@id='contentEmployees']/div[2]/div[1]/div/div/div[2]/div[2]");
		
		
		public MyEmployeesPage(WebDriver driver) {
			this.driver=driver;
		}
		
		
		
		

		public ManagersPage verifyEmployees() throws InterruptedException {
			
			clickOnDashboard();
			
			employeesText();
			
			synchronized (driver)
			{
			    driver.wait(8000);
			}

			clickOnEmployees();
			
			synchronized (driver)
			{
			    driver.wait(8000);
			}
			
			clickOnDashboard();
			
			synchronized (driver)
			{
			    driver.wait(5000);
			}
			//employeesVerification();
			
			return new ManagersPage(driver);
			
		}
		
		
		
		public void clickOnDashboard() {
			
			WebElement dashboardTabElement =  driver.findElement(dashboardTab);
			
			if(dashboardTabElement.isDisplayed()) {
				
				dashboardTabElement.click();
				
			}
			
			else System.out.println("Dashboard Details not found");
			
		}

		public String employeesText() {
			
			WebElement myEmployeesTxtElement = driver.findElement(myEmployeesTxt);
			String myEmployeesTxtElementTxt  = myEmployeesTxtElement.getText();
			
			System.out.println(myEmployeesTxtElementTxt);
			return myEmployeesTxtElementTxt;
			
		}
		
		public void clickOnEmployees() throws InterruptedException {
			
			
			List<WebElement> employeesTotal = 	driver.findElements(By.xpath(".//*[@id='contentMain']/div[2]/div[1]/div[2]/ul/li"));
	        int totalSize = employeesTotal.size();
	        
	        Random rand = new Random();
	        int rand_int1 = rand.nextInt(totalSize);
	        System.out.println(rand_int1);

			
			//String xx = ".//*[@id='contentMain']/div[2]/div[1]/div[2]/ul/li[]/a/div[1]/p";
			WebElement element = driver.findElement(By.xpath(".//*[@id='contentMain']/div[2]/div[1]/div[2]/ul/li[1]/a/div[1]/p"));
			Actions action = new Actions(driver);
			action.moveToElement(element).click().perform();
			
			synchronized (driver)
			{
			    driver.wait(6000);
			}
			
			element.click();
			/* WebElement employeeLinkElement =  driver.findElement(employeeLink);
				
			if(employeeLinkElement.isDisplayed()) {
					
					employeeLinkElement.click();
					
			}
				
			else 
				
			System.out.println("Employee not found");
				*/
			synchronized (driver)
				
			{
				    driver.wait(5000);
			}
			
		}
		
		
		
		public String employeesVerification() {
			
			//WebElement verifyEmployeeElement = driver.findElement(verifyEmployee);
			//String verifyEmployeeElementTxt  = verifyEmployeeElement.getText();
			//System.out.println(verifyEmployeeElementTxt);
			String verifyEmployeeElementTxt = driver.findElement(By.xpath(".//*[@id='contentOneEmployee']/div[2]/div[1]/div/div/div[2]/div[2][text() = 'Villvay Admin']")).getText();
			System.out.println(verifyEmployeeElementTxt);
			return verifyEmployeeElementTxt;
		}
		
		public boolean verifyEmployeesName() throws InterruptedException {
			String expectedEmployeeText = employeesVerification();
			return employeesText().contains(expectedEmployeeText);
			
		}
			
		
}
