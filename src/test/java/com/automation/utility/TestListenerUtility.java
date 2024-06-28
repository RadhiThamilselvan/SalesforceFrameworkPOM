package com.automation.utility;




import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.base.BaseTest;



public class TestListenerUtility extends BaseTest implements ITestListener{
	protected Logger mylog=LogManager.getLogger();
	public static ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();

	@Override
	public void onTestStart(ITestResult result) {
		mylog.info(result.getName()+" started------");
		extentReport.startSingleTestReport(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		mylog.info(result.getName()+" ended with success------------");
		extentReport.logTestpassed(result.getName()+" ended with success------------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		mylog.error(result.getName()+" ended with failure------------");
		extentReport.logTestFailed(result.getMethod().getMethodName()+"test is failed");
		extentReport.logTestFailedWithException(result.getThrowable());
		String dir=constants.SCREENSHOTS_DIRECTORY_PATH;
		String filename=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		String path=dir+filename+".png";
		
		takescreenshot(path);
		
		extentReport.logTestWithscreenshot(path);
	}



	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		mylog.info(context.getName()+ "Test has started------------------");
		extentReport.startExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		mylog.info(context.getName()+"Test has ended-------------");
		extentReport.endReport();
	}
	
	
	

}