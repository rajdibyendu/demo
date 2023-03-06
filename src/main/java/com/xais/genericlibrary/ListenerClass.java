/**
 * 
 */
package com.xais.genericlibrary;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;

/**
 * @author Dibyendu.raj
 *
 */
public class ListenerClass extends ExtentManager implements ITestListener {
	public ExtentReports extentReports;
	public static ExtentTest test;
	
	public void onStart(ITestContext context) {
		extentReports = generateExtentReport();
	}
	
	public void onTestStart(ITestResult result) {
		 test = extentReports.createTest(result.getName());
		 test.log(Status.INFO, "Test case execution started");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "<font color='#9ccc65'>Test case execution passed</font>");
	}

	public void onTestFailure(ITestResult result) {
		String path = Action.takeScreenshot(BaseClass.driver, result.getName());
		Media  media =  MediaEntityBuilder.createScreenCaptureFromPath(path).build();
		test.log(Status.FAIL, "<font color='#e57373'>Test case execution failed<br>"+result.getThrowable()+"</font>", media);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "<font color='#ff9900'>Test case execution skipped<br>"+result.getThrowable()+"</font>");
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
		String pathString  = System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html";
		File f = new File(pathString);
		try {
			Desktop.getDesktop().browse(f.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
