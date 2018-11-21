package com.prod.Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prod.base.gudpplBaseSetup;
import com.prod.signin.Pages.*;

import ExcelLib.ExcelDataConfig;

public class SignInTestCase extends gudpplBaseSetup{


	public ExcelDataConfig excelDataConfig;
	
	private WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		driver = getDriver();
	}
	
	
	@Test(priority=1)
	public void testSignIn() throws InterruptedException, IOException {
	//BasePage basepage = new BasePage(driver);
	//String loginPageTile =  basepage.getPageTitle();
	//Assert.assertTrue(loginPageTile.toLowerCase().contentEquals("gudppl"));

	//System.out.println("Gudppl Home Page");
	
	
	SignInPage signInPage  = new SignInPage(driver);
	signInPage.verifySigin("admin", "Germany1");
	Assert.assertTrue(signInPage.verifySignInPage());
	
	System.out.println("Successfully login prodoscore");
	}
}
