package com.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.base.BasePage;

public class LoginPage extends BasePage {
@FindBy(xpath="//input[@id=\"username\"]") WebElement userName;
@FindBy(id="password") WebElement password;
@FindBy(id="Login") WebElement Login;
@FindBy(xpath="//a[@id=\"forgot_password_link\"]")WebElement forgotPwd;
@FindBy(id="rememberUn") WebElement rememberMe;



public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
public void enterUserName(String data)
{
	enterText(userName, data,"userName field");
}
public void enterPwd(String data)
{
	enterText(password,data,"password");
}
public WebDriver clickLoginButton()
{
	clickElement(Login,"Login");
	return driver;
}
public void clearPassword()
{
	clear1(password);
}

public void checkRememberMe() {
	clickElement(rememberMe, "Remember me");
	
}
public WebDriver clickForgotPwd()
{
	clickElement(forgotPwd, "Forgot Password");
	return driver;
}
public String getTitleOfThePage() {

	return getTitleOfThePage();
}
public String getTextFromUsernameField() throws InterruptedException
{
	Thread.sleep(3000);
	String st=userName.getText();
	return st;
}

}
