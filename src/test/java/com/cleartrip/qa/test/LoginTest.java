package com.cleartrip.qa.test;



import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cleartrip.baseclass.Base;
import com.cleartrip.qa.main.HomePage;
import com.cleartrip.qa.main.LoginPage;

import junit.framework.Assert;

public class LoginTest extends Base{
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginTest() throws FileNotFoundException {		
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
			try {
				initialization();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		loginPage = new LoginPage();
		
		 
				}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
	
	String title = loginPage.validateLoginPageTitle();
	Assert.assertEquals(title,"#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
}		
	
	
	@Test(priority = 2)
	public void loginUrl() {
	
	homePage = loginPage.signIn(prop.getProperty("ID"),prop.getProperty("PASSWORD"));
	
	}	
	
	
	
	@AfterMethod
	public void tearDown()
   {
	driver.quit();
   }
	
	
}
