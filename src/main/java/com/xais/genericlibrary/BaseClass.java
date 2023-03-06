package com.xais.genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

public class BaseClass {
	public static Properties properties;
	public static WebDriver driver;
	protected ExtentReports extentReports;
	@BeforeSuite
	public void beforeSuite() throws IOException{
		extentReports = new ExtentManager().generateExtentReport();
		properties = new Properties();
		FileInputStream fileInputStream  = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\commondata.properties");
		properties.load(fileInputStream );
		System.out.println("commondata.properties load successfully");
	}

	public static void launchApp() {
		String browserName = properties.getProperty("browser");
		if (browserName.contains("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browserName.contains("edge")){
			driver = new EdgeDriver();
		}
		//Maximize the screen
		driver.manage().window().maximize();
		
		//Implicit TimeOuts
		Action.implicitWait(driver, 10);
	
		//PageLoad TimeOuts
		Action.pageLoadTimeOut(driver, 30);
		
		//Launching the URL
		driver.get(properties.getProperty("url"));
	}
}
