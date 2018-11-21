package com.prod.dashboard.Pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OrganizationScorePage {

	private WebDriver driver;
	
	private By aboveAverage = By.xpath(".//*[@id='contentMain']/div[1]/div/div/div[2]/a[1]/div");
	private By withinAverage = By.xpath(".//*[@id='contentMain']/div[1]/div/div/div[2]/a[2]/div");
	private By belowAverage = By.xpath(".//*[@id='contentMain']/div[1]/div/div/div[2]/a[3]/div");
	private By dashboardLink = By.xpath(".//*[@id='AppBreadcrumbs']/ul/li[1]/a[text() = 'Dashboard']");
	private By scoreText = By.xpath(".//*[@id='strataCount']/div[3]/div/div/h2");
	
	
	
	
	public OrganizationScorePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public CorrelationsPage verifyScorePage() throws InterruptedException {
		
	
		aboveAverage();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnDashboard();
		Assert.assertTrue(verifyAboveAveragePage());
		System.out.println("Successfully verified average orginization score page");
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		withinAverage();
		verifyWithinAveragePage();
		System.out.println("Successfully verified within orginization score page");
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnDashboard();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		belowAverage();
		verifyBelowAverage();
		System.out.println("Successfully verified below in orginization score page");
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnDashboard();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		return new CorrelationsPage(driver);
	}
	
	public void aboveAverage() throws InterruptedException {
		
		WebElement aboveAverageElement =  driver.findElement(aboveAverage);
		
		if(aboveAverageElement.isDisplayed()) {
			
			aboveAverageElement.click();
			
		}
		
		else System.out.println("Above Average Element not found");
	
		
	}
	
	public void clickOnDashboard() throws InterruptedException {
		
		WebElement dashboardLinkElement =  driver.findElement(dashboardLink);
		
		if(dashboardLinkElement.isDisplayed()) {
			
			dashboardLinkElement.click();
			
		}
		
		else System.out.println("Dashboard Link not found");
	
	}
	
	public void withinAverage() throws InterruptedException {
		
		WebElement withinAverageElement =  driver.findElement(withinAverage);
		
		if(withinAverageElement.isDisplayed()) {
			
			withinAverageElement.click();
			
		}
		
		else System.out.println("Within Average Element not found");
	
		
	}
	
	public void belowAverage() throws InterruptedException {
		
		WebElement belowAverageElement =  driver.findElement(belowAverage);
		
		if(belowAverageElement.isDisplayed()) {
			
			belowAverageElement.click();
			
		}
		
		else System.out.println("Below Average Element not found");
	
		
	}
	
	public String scorePage() {
		
		WebElement scoreTextElement = driver.findElement(scoreText);
		String scoreText  = scoreTextElement.getText();
		return scoreText;
	}
	
	public boolean verifyAboveAveragePage() throws InterruptedException {
		
		String expectedscoreText = "Employees with an above average Prodoscore";
		return scorePage().contains(expectedscoreText);
		
	}
	
	public boolean verifyWithinAveragePage() throws InterruptedException {
		
		String expectedscoreText = "Employees with a within average Prodoscore";
		return scorePage().contains(expectedscoreText);
			
		}
	
	public boolean verifyBelowAverage() throws InterruptedException {
		
		String expectedscoreText = "Employees with a below average Prodoscore";
		return scorePage().contains(expectedscoreText);
			
		}
}