package com.automation.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.automation.utility.ExtentReportsUtility;


public class BasePage {
	protected Logger mylog = LogManager.getLogger(BasePage.class);
	protected static WebDriver driver = null;
    protected ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();
    
    public BasePage(WebDriver driver)
    {
    	BasePage.driver=driver;
    	PageFactory.initElements(driver,this);
    }
    
	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			mylog.info(objectName +"data is entered in " + objectName + " textbox");
		} else {
			extentReport.logTestFailed((objectName + " element is not displayed"));
			;
		}
	}
	public void errorMessage(WebElement e)
	{
		if(e.isDisplayed())
		{
			extentReport.logTestInfo((e.getText()));;
		}
	}
	
	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			mylog.info((objectName + "button is clicked"));
			
		} else {
			extentReport.logTestFailed((objectName+" element is not enabled"));
			
		}
	}
	
	public void getTextFromElement(WebElement ele, String objectName) {
		String data="";
		if(ele.isDisplayed()) {
		data = ele.getText();
		extentReport.logTestInfo(data);
		}
		else {
			extentReport.logTestFailed(objectName+" not dispalyed");
		}
		
	}
	public void selectByVisibleText(WebElement ele,String Text)
	{
		Select objSelect =new Select(ele);
		objSelect.selectByVisibleText(Text);
	}
	
	public String currentDateTime()
	{
		String dt="";
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now= LocalDateTime.now();
	    dt=dtf.format(now);
	    return dt;
		
	}
	public void alert_Accept()
	{
		driver.switchTo().alert().accept();
		mylog.info("Alert accepted");
	}
	public void alert_Dismiss()
	{
		driver.switchTo().alert().dismiss();
		extentReport.logTestInfo("alert dismissed");
	}
	public void actionsMoveTo(WebElement ele,String ObjectName) {
		Actions a=new Actions(driver);
		a.moveToElement(ele).click().build().perform();
		extentReport.logTestInfo(ObjectName +" is clicked");
	}
	public void ContextClickOnElement(WebElement ele,String objName)
	{
		Actions action=new Actions(driver);
		action.contextClick(ele).build().perform();
		extentReport.logTestInfo("right click performed on web element "+objName);
	}
	public void enter_TextArea(WebElement ele,String data,String objectName)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).sendKeys(data).build().perform();
		extentReport.logTestInfo("Text printed");
	}
	public void switch_Frames()
	{
		
		driver.switchTo().frame("contactInfoContentId");
		extentReport.logTestInfo("switched to frame");
	}
	
	public void switch_Frames1(WebElement e,String data)
	{
		driver.switchTo().frame(e);
		extentReport.logTestInfo("switched to" +data);
	}
	public void switch_FrameByIndex(int index)
	{
		driver.switchTo().frame(index);
		extentReport.logTestInfo("switched to frame");
	}
	public void switch_FrameByID(String ID)
	{
		driver.switchTo().frame(ID);
		extentReport.logTestInfo("switched to frame");
	}
	public void selectByText(WebElement e,String Text,String object)
	{
		Select objSelect = new Select(e);
		objSelect.selectByVisibleText(Text);
		extentReport.logTestInfo(object +"is Selected");
	}
	
	public void select(WebElement e,int Index,String object)
	{
		Select objSelect = new Select(e);
		objSelect.selectByIndex(Index);
		extentReport.logTestInfo(object +"is selected");
	}
	public void switch_FrameSize()
	{
		int size=driver.findElements(By.tagName("iframe")).size();
		mylog.info(size);
		for(int i=0;i<=size;i++) {
			driver.switchTo().frame(i);
			int index=driver.findElements(By.xpath("/html/body/iframe")).size();
			mylog.info(index);
		}
	}
	public void default1_Frame()
	{
		driver.switchTo().defaultContent();
		extentReport.logTestInfo("switched to default frame");
	}
	public void clear1(WebElement e)
	{
		e.clear();
		mylog.info("data cleared");
	}
	public void windowHandles()
	{
		String window=driver.getWindowHandle();
		System.out.println(window);
		Set<String> allWindowHandles=driver.getWindowHandles();
		for(String handle:allWindowHandles)
		{
			System.out.println(handle);
		}
		
		
	}
	public Alert switchToAlert()
	{
		Alert alert=driver.switchTo().alert();
		return alert;
	}
	public String getAlertText(Alert a,String s)
	{
		String text=a.getText();
		return text;
	}
	public void AcceptAlert(Alert a)
	{
		a.accept();
	}
	public void dismissAlert(Alert a)
	{
		a.dismiss();
	}
	public void explicit_Waits(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
	       wait.until(ExpectedConditions.elementToBeClickable(e));
	       
	}
	
}
