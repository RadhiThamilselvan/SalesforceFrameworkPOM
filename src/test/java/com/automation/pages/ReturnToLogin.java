package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.base.BasePage;

public class ReturnToLogin extends BasePage {
	public ReturnToLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//*[@id=\"forgotPassForm\"]/a") WebElement return1;
	
	public WebDriver returnToLogin()
	{
		clickElement(return1,"Return To Login");
		return driver;
	}
}
