package com.prod.Testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prod.base.gudpplBaseSetup;
import com.prod.home.Pages.HomePage;
import com.prod.signin.Pages.*;


import ExcelLib.ExcelDataConfig;

public class HomePageTestCase extends gudpplBaseSetup{


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
	
	HomePage homePage = new HomePage(driver);
	homePage.verifyTab();
	System.out.println("Successfully verified all tabs");
	
	
	}
}
