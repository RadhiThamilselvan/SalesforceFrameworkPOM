package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.base.BasePage;

public class ForgotPasswordPage extends BasePage {
	@FindBy(id="un") WebElement userNameForgot;
	@FindBy(id="continue") WebElement cont;
	@FindBy(xpath="//*[@id=\"forgotPassForm\"]/div[1]/input[3]") WebElement cancel;
public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		
	}
public void enterUserName(String data)
{
	enterText(userNameForgot,data,"username");
}
public WebDriver clickContinue()
{
	clickElement(cont,"Continue");
	return driver;
}
public WebDriver clickCancel()
{
	clickElement(cancel,"Cancel");
	return driver;
}

}
