package com.prod.signin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.prod.home.Pages.HomePage;

public class SignInPage {
	
	private WebDriver driver;
	
	private By emailTextBox = By.xpath(".//*[@id='id_username']");
	
	private By passwordTextBox = By.xpath(".//*[@id='id_password']");
 
	private By signBtn = By.xpath(".//*[@id='app']/div/div[2]/form/input[2]");

	private By homeLinkTxt = By.xpath(".//*[@id='contentMain']/div[1]/div/div/h2");
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterUserName(String userName) {
		
		WebElement emailTxtBox  = driver.findElement(emailTextBox);
	
		if(emailTxtBox.isDisplayed()) {
			
			emailTxtBox.sendKeys(userName);
		}
		
	}

	public void enterPassword(String userPassword) {
		
		WebElement passTxtBox = driver.findElement(passwordTextBox);
		
		if(passTxtBox.isDisplayed()) {
			
			passTxtBox.sendKeys(userPassword);
		}
		
	}
	
	public void clickOnSignIn() {
		
		WebElement signInBtn =  driver.findElement(signBtn);
		
		if(signInBtn.isDisplayed()) {
			
			signInBtn.click();
		}
		
		else System.out.println("Element not found");
		
	}


	public HomePage verifySigin(String user , String pass) throws InterruptedException {
		enterUserName(user);
		synchronized (driver)
		{
		    driver.wait(1000);
		}
		enterPassword(pass);
		synchronized (driver)
		{
		    driver.wait(1000);
		}
		clickOnSignIn();
		synchronized (driver)
		{
		    driver.wait(18000);
		}
		return  new HomePage(driver);
		
		
	}
	
	public boolean verifySignInPage() {
		
		WebElement homeLinkTxtElement  = driver.findElement(homeLinkTxt);
		boolean status = homeLinkTxtElement.isDisplayed();
		
		return status;
	}


}
