package com.automation.base;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.PropertiesUtility;
import com.automation.utility.constants;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	Logger mylog = LogManager.getLogger(BaseTest.class);
	protected static WebDriver driver = null;
	 protected ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();
	@BeforeMethod
	@Parameters("browserName")
public void setUpBeforeMethod(@Optional("chrome") String BrowserName1)
{
	mylog.info("*******setUpbeforeMethod********");
	launchBrowser(BrowserName1);
	String url=PropertiesUtility.readDataFromPropertyFile(constants.APPLICATION_PROPERTIES,"url");
	goToUrl(url);
				
}
//@AfterMethod
public void tearDownAfterTestmethod()
{
	closeBrowser();
	mylog.info("*******tearDownAfterTestMethod*********");
}
public void closeBrowser() {
	driver.close();
	mylog.info("browser instance closed");
	driver=null;
}
public void launchBrowser(String browserName) {

	switch (browserName.toLowerCase()) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		mylog.info("browser instance chrome created");
		driver.manage().window().maximize();
		System.out.println("window is maximized");
		break;

	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		mylog.info("browser instance chrome created");
		driver.manage().window().maximize();
		break;

	case "edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		break;

	case "opera":
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
		driver.manage().window().maximize();
		break;

	

	default:
		System.out.println("Unsupported browser: " + browserName);
	}

	// return driver;
}

public void goToUrl(String url) {
	driver.get(url);
	mylog.info(url + "is entered");
	
}
public void takescreenshot(String filepath)
{
	TakesScreenshot screenCapture=(TakesScreenshot)driver;
	File src=screenCapture.getScreenshotAs(OutputType.FILE);
	File destination=new File(filepath);
	try
	{
		Files.copy(src, destination);
		extentReport.logTestInfo("File copied");
	}
	catch(IOException e)
	{
		e.printStackTrace();
		extentReport.logTestFailed("went wrong when capturing the screen");
	}
}
}
