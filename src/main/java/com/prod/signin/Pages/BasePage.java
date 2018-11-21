package com.prod.signin.Pages;

import org.openqa.selenium.WebDriver;


public class BasePage {
	
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public SignInPage loginPage() {
		
		
			return new SignInPage(driver);
	}
	
	public String getPageTitle() {
		
		String title = driver.getTitle();
		return title;
	}
	
	

}