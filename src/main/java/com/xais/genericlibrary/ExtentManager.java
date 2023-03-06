/**
 * 
 */
package com.xais.genericlibrary;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author Dibyendu.raj
 *
 */
public class ExtentManager {
	
	public static ExtentReports extentReports;
	
	public ExtentReports generateExtentReport() {
		extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("XAIS Report");
		sparkReporter.config().setDocumentTitle("XAIS Report");
		sparkReporter.config().setTimeStampFormat("MM/dd/YYYY hh:mm:ss");
		
		extentReports.attachReporter(sparkReporter);
		
//		extentReports.setSystemInfo("Application URL", properties.getProperty("url"));
//		extentReports.setSystemInfo("Browser", properties.getProperty("browser"));
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("OS Version", System.getProperty("os.version"));
		extentReports.setSystemInfo("Tester", System.getProperty("user.name"));
		
		return extentReports;
	}
	
	public static void endReport() {
		extentReports.flush();
	}
}
