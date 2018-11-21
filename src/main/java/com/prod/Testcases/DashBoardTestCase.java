package com.prod.Testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.prod.base.gudpplBaseSetup;
import com.prod.dashboard.Pages.CalendarSearchPage;
import com.prod.dashboard.Pages.CorrelationsPage;
import com.prod.dashboard.Pages.DashBoardPage;
import com.prod.dashboard.Pages.MyEmployeesPage;
import com.prod.dashboard.Pages.OrganizationScorePage;
import com.prod.employees.Pages.EmployeesPage;
import com.prod.employees.Pages.EmployeesSearch;
import com.prod.home.Pages.HomePage;
import com.prod.managers.Pages.ManagersPage;
import com.prod.managers.Pages.ManagersScorePage;
import com.prod.product.crmSetting.Pages.CrmProductPage;
import com.prod.product.crmSetting.Pages.CrmProductPage2;
import com.prod.signin.Pages.*;


import ExcelLib.ExcelDataConfig;

public class DashBoardTestCase extends gudpplBaseSetup{


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
	//Assert.assertTrue(signInPage.verifySignInPage());
	System.out.println("Successfully login prodoscore");
	
	
	CrmProductPage2 CrmProductPage2 = new CrmProductPage2(driver);
	CrmProductPage2.verifyAddingProduct("1", "b837529c718db42bfdda53e25c31a877");
	CrmProductPage2.verifyAddingProduct("Salesforce", "test@prodoscore.com", "Welcome123456!12", "N3urB5BXkMtzZQXIjSw0K311E");
	//CrmProductPage crmPageobj  = new CrmProductPage(driver);
	//crmPageobj.verifyAddingProduct("Salesforce", "test@prodoscore.com", "Welcome123456!12", "N3urB5BXkMtzZQXIjSw0K311E");
	/*HomePage homePage = new HomePage(driver);
	homePage.verifyTab();
	System.out.println("Successfully verified all tabs");
	
	DashBoardPage dashBoardPage = new DashBoardPage(driver);
	dashBoardPage.verifyDashboard();
	Assert.assertTrue(dashBoardPage.verifyDashboardPage());
	System.out.println("Successfully verified dashboard page");
	
	CalendarSearchPage calendarSearchPage = new CalendarSearchPage(driver);
	calendarSearchPage.calenderSearch();
	
	OrganizationScorePage organizationScorePage = new OrganizationScorePage(driver);
	organizationScorePage.verifyScorePage();
	
	CorrelationsPage correlationsPage = new CorrelationsPage(driver);
	correlationsPage.verifyCorrelationsPage();
	
	MyEmployeesPage myEmployeesPage = new MyEmployeesPage(driver);
	myEmployeesPage.verifyEmployees();
	Assert.assertTrue(myEmployeesPage.verifyEmployeesName());

	ManagersPage managersPage = new ManagersPage(driver);
	managersPage.verifyManagersPage();
	
	ManagersScorePage managersScorePage = new ManagersScorePage(driver);
	managersScorePage.verifyManagers();
	
	EmployeesPage employeesPage = new EmployeesPage(driver);
	employeesPage.verifyEmployeesPage();
	
	EmployeesSearch employeesSearch = new EmployeesSearch(driver);

	employeesSearch.verifyEmployees("cha","Tech Support","Matthew Samuel");*/
	
	
	
	}
	
}
