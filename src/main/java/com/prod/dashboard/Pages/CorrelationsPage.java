package com.prod.dashboard.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CorrelationsPage {

	private WebDriver driver;

	private By correlationsTopicsLink = By.xpath(".//*[@id='contentMain']/div[2]/div[1]/div[1]/div/nav/a[1][text() = 'Topics']");
	private By correlationsCODLink = By.xpath(".//*[@id='contentMain']/div[2]/div[1]/div[1]/div/nav/a[2][text() = 'COD']");
	private By correlationsTopicData = By.xpath("//div[@class = 'card-tabs corrWidget']/div[@id = 'corrWidgetTopics']/table[1]//tr/td[1]");
	private By correlationsCODData = By.xpath(".//*[@id='corrWidgetCOD']//tbody/tr[1]/td");
	private By dashboardTab = By.xpath(".//*[@id='app']/div[1]/div[1]/nav/ul[1]/li[1]/a[text() = 'Dashboard']");
	
	private By correlationsTxt = By.xpath(".//*[@id='contentMain']/div[2]/div[1]/div[1]/h2");
	private By topicVerificationTxt  = By.xpath(".//*[@id='topics']/thead/tr/th[1][text() = 'Topic']");
	private By codVerificationTxt  = By.xpath(".//*[@id='people']/thead/tr/th[1]/span[1][text() = 'COD']");
	private By trendVerificationTxt  = By.xpath(".//*[@id='chart_correlations']/h2");
	private By employeeDataVerificationTxt  = By.xpath(".//*[@id='correlationDetails']/div/table/thead/tr/th[1][text() = 'Employee']");
	
	
	public CorrelationsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public MyEmployeesPage verifyCorrelationsPage() throws InterruptedException {
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		CorrelationsPageVerifications();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnTopicsData();
		codAndTopicsVerifications();
		System.out.println("Successfully verified topics page");
		synchronized (driver)
		{
		    driver.wait(5000);
		}
		clickOnDashboard();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnCOD();
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		clickOnCODData();
		codAndTopicsVerifications();
		System.out.println("Successfully verified cod page");
		synchronized (driver)
		{
		    driver.wait(5000);
		}
		
		
		return new MyEmployeesPage(driver);
	}
	
	
	public void CorrelationsPageVerifications() throws InterruptedException {
		
	
		verifyCorrelations();
		verifyTopic();
		verifyCod();
		
		System.out.println("Successfully verified correlations page");
	}
	
	public void codAndTopicsVerifications() throws InterruptedException {
		
		
		verifyTrend();
		verifyEmployees();
		
		
	}

	public void verification() {
		
		WebElement correlationsTopicsLinkElement =  driver.findElement(correlationsTopicsLink);
		
		if(correlationsTopicsLinkElement.isDisplayed()) {
			
			correlationsTopicsLinkElement.click();
		}
		
		else System.out.println("Topics Tab not found");
		
	}


	public void clickOnTopics() {
		
		WebElement correlationsTopicsLinkElement =  driver.findElement(correlationsTopicsLink);
		
		if(correlationsTopicsLinkElement.isDisplayed()) {
			
			correlationsTopicsLinkElement.click();
		}
		
		else System.out.println("Topics Tab not found");
		
	}
	
	public void clickOnTopicsData() {
		
		WebElement correlationsTopicDataElement =  driver.findElement(correlationsTopicData);
		
		if(correlationsTopicDataElement.isDisplayed()) {
			
			correlationsTopicDataElement.click();
		}
		
		else System.out.println("Could not find any topic");
		
	}
	
	public void clickOnCOD() {
		
		WebElement correlationsCODLinkElement =  driver.findElement(correlationsCODLink);
		
		if(correlationsCODLinkElement.isDisplayed()) {
			
			correlationsCODLinkElement.click();
		}
		
		else System.out.println("COD Tab not found");
		
	}
	
	public void clickOnCODData() {
		
		WebElement correlationsCODDataElement =  driver.findElement(correlationsCODData);
		
		if(correlationsCODDataElement.isDisplayed()) {
			
			correlationsCODDataElement.click();
		}
		
		else System.out.println("Could not find any COD");
		
	}
	
	
	public void clickOnDashboard() throws InterruptedException {
		
		WebElement dashboardTabElement =  driver.findElement(dashboardTab);
		
		if(dashboardTabElement.isDisplayed()) {
			
			dashboardTabElement.click();
			
		}
		
		else System.out.println("Dashboard Tab not found");
	
	}
	
	public String correlationsPageVerification() {
		
		WebElement correlationsTxtElement = driver.findElement(correlationsTxt);
		String correlationsTxtElementTxt  = correlationsTxtElement.getText();
		return correlationsTxtElementTxt;
	}
	
	public boolean verifyCorrelations() throws InterruptedException {
		
		String expectedCorrelationsText = "Correlations";
		return correlationsPageVerification().contains(expectedCorrelationsText);
		
	}
	
	public String topicVerification() {
		
		WebElement topicVerificationTxtElement = driver.findElement(topicVerificationTxt);
		String topicVerificationTxtElementTxt  = topicVerificationTxtElement.getText();
		return topicVerificationTxtElementTxt;
	}
	
	public boolean verifyTopic() throws InterruptedException {
		
		String expectedTopicsText = "Topics";
		return topicVerification().contains(expectedTopicsText);
		
	}
	
	
	public String codVerification() {
		
		WebElement codVerificationTxtElement = driver.findElement(codVerificationTxt);
		String codVerificationTxtElementTxt  = codVerificationTxtElement.getText();
		return codVerificationTxtElementTxt;
	}
	
	public boolean verifyCod() throws InterruptedException {
		
		String expectedCodText = "COD";
		return codVerification().contains(expectedCodText);
		
	}
	
	
	public String trendVerification() {
		
		WebElement trendVerificationTxtElement = driver.findElement(trendVerificationTxt);
		String trendVerificationTxtElementTxt  = trendVerificationTxtElement.getText();
		return trendVerificationTxtElementTxt;
	}
	
	public boolean verifyTrend() throws InterruptedException {
		
		String expectedTrendText = "Trend for \"team\"";
		return trendVerification().contains(expectedTrendText);
		
	}
	
	public String employeesVerification() {
		
		WebElement employeeDataVerificationTxtElement = driver.findElement(employeeDataVerificationTxt);
		String codVerificationTxtElementTxt  = employeeDataVerificationTxtElement.getText();
		return codVerificationTxtElementTxt;
	}
	
	public boolean verifyEmployees() throws InterruptedException {
		
		String expectedEmployeeText = "Employee";
		return employeesVerification().contains(expectedEmployeeText);
		
	}
	

}
