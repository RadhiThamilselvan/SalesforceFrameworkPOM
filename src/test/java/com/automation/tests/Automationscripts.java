package com.automation.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.ForgotPasswordPage;
import com.automation.pages.LoginPage;
import com.automation.pages.ReturnToLogin;
import com.automation.pages.SalesforceHomePage;
import com.automation.utility.constants;
	import com.automation.utility.PropertiesUtility;
	
	public class Automationscripts extends BaseTest {
		Logger mylog = LogManager.getLogger(Automationscripts.class);
		
		@Test
			public void Salesforce_Login_positive() throws InterruptedException {
			
				
			String usernameData = PropertiesUtility.readDataFromPropertyFile(constants.APPLICATION_PROPERTIES,"username");
			String passwordData=PropertiesUtility.readDataFromPropertyFile(constants.APPLICATION_PROPERTIES,"password");
			
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUserName(usernameData);
			loginpage.enterPwd(passwordData);
			driver=loginpage.clickLoginButton();
			SalesforceHomePage home=new SalesforceHomePage(driver);
			home.clickuserNameDropdown();
			Thread.sleep(2000);
			driver=home.userNameDropdown("Logout");
		}
			@Test	
		public void Salesforce_invalidLogin() throws InterruptedException {
			
			
			
			
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUserName("1234");
			loginpage.enterPwd("12345");
			driver=loginpage.clickLoginButton();
			
		}
		@Test
			public void checkRememberMe() throws InterruptedException
			{
				
				String usernameData = PropertiesUtility.readDataFromPropertyFile(constants.APPLICATION_PROPERTIES,"username");
				String passwordData=PropertiesUtility.readDataFromPropertyFile(constants.APPLICATION_PROPERTIES,"password");
				
				LoginPage loginpage=new LoginPage(driver);
				loginpage.enterUserName(usernameData);
				loginpage.enterPwd(passwordData);
				loginpage.checkRememberMe();
				driver=loginpage.clickLoginButton();
				SalesforceHomePage home=new SalesforceHomePage(driver);
				home.clickuserNameDropdown();
				Thread.sleep(2000);
				driver=home.userNameDropdown("Logout");
			  
			  
			  
			}
		@Test
		public void clearpassword()
		{
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUserName("1234");
			loginpage.clearPassword();
			driver=loginpage.clickLoginButton();
		}
		@Test
		public void forgotPwd()
		{
			String usernameData = PropertiesUtility.readDataFromPropertyFile(constants.APPLICATION_PROPERTIES,"username");
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUserName(usernameData);
			driver=loginpage.clickForgotPwd();
			ForgotPasswordPage fp= new ForgotPasswordPage(driver);
			fp.enterUserName(usernameData);
			driver=fp.clickContinue();
			ReturnToLogin r=new ReturnToLogin(driver);
			driver=r.returnToLogin();
			
			
		}
			
			

			

		

		
}
