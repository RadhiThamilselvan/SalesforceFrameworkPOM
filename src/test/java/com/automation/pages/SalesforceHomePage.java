package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.base.BasePage;

public class SalesforceHomePage extends BasePage {
	@FindBy(xpath="//span[@id='userNavLabel']") WebElement userNameDrop;
	
	
	public SalesforceHomePage(WebDriver driver) {
		super(driver);
	
	}
	public void clickuserNameDropdown()
	{
		clickElement(userNameDrop, "userNameDrop");
	}
	public WebDriver userNameDropdown(String data) 
	{
		 
		  
		
		 List<WebElement> elements=driver.findElements(By.xpath("//*[@id=\'userNav-menuItems\']/a"));
		    for(WebElement ele:elements) {
		    	
		    	String st=ele.getText();
		    	
		    	if(st.equals(data))
		    	{
		    		ele.click();
		    		mylog.info(data+ "is clicked");
		    		break;
		    	}
		    }
return driver;
	

	}
	
}
