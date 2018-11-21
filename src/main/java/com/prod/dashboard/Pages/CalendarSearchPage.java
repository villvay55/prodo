package com.prod.dashboard.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalendarSearchPage {

	private WebDriver driver;

	private By fromDateTxtBox = By.xpath(".//*[@id='app']/header/div[1]/form/div[2]/input");
	private By toDateTxtBox = By.xpath(".//*[@id='app']/header/div[1]/form/div[3]/input");
	
	
	
	public CalendarSearchPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public OrganizationScorePage calenderSearch() throws InterruptedException {
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		normalSearch();
		synchronized (driver)
		{
		    driver.wait(8000);
		}
		customSearch();
		synchronized (driver)
		{
		    driver.wait(15000);
		}
		
		return new OrganizationScorePage(driver);
	}
	
	public void normalSearch() {
		
		Select customDateDropDown = new Select(driver.findElement(By.xpath(".//*[@id='date-filter']")));
		customDateDropDown.selectByIndex(1);
		
	}
	
	public void customSearch() throws InterruptedException {
		
		WebElement fromDateTxtBoxElement =  driver.findElement(fromDateTxtBox);
		
		if(fromDateTxtBoxElement.isDisplayed()) {
			
			fromDateTxtBoxElement.click();
			
		}
		
		else System.out.println("From date text box not found");
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		
		List<WebElement> dates = 	driver.findElements(By.xpath("//div[@class='calendar']/table//td"));
		
		int total_date = dates.size();
		
		for(int i=0;i <= total_date;i++) {
			
			String date = dates.get(i).getText();
			if(date.equalsIgnoreCase("10")) {
				
				dates.get(i).click();
				break;
			}
		}
		
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		WebElement toDateTxtBoxElement =  driver.findElement(toDateTxtBox);
		
		if(toDateTxtBoxElement.isDisplayed()) {
			
			toDateTxtBoxElement.click();
		}
		
		else System.out.println("To date text box not found");
		
		
		synchronized (driver)
		{
		    driver.wait(3000);
		}
		
		List<WebElement> dates1 = 	driver.findElements(By.xpath("//div[@class='calendar']/table//td"));
		
		int total_date1 = dates1.size();
		for(int i=0;i <= total_date1;i++) {
			
			String date1 = dates1.get(i).getText();
			if(date1.equalsIgnoreCase("3")) {
				
				dates1.get(i).click();
				break;
			}
		}
		
		  	long val = 1522794600000l;
	        Date date=new Date(val);
	        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
	        String dateText = df2.format(date);
	        System.out.println(dateText);
	        List<WebElement> scoreDates = 	driver.findElements(By.xpath("//div[@id='contentMain']/div[2]/div[2]/div[1]/div[1]/*[local-name() = 'svg']/*[local-name() = 'g'][3]/*[local-name() = 'g']"));
	        int total1 = scoreDates.size();
	        System.out.println("Total  "+total1);
	}

	
	
    
}
