/**
 * 
 */
package com.xais.testcases;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.xais.genericlibrary.BaseClass;
import com.xais.pageobjects.LandingPage;
import com.xais.pageobjects.LoginPage;

/**
 * @author Dibyendu.raj
 *
 */
public class LoginPageTest extends BaseClass {
	LandingPage landingPage;
	private ExtentTest test;
	
	@BeforeMethod
	public void beforeMethod() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyLoginWithValidCredentials(ITestContext context) {
		test = (ExtentTest) context.getAttribute("test");
		test = extentReports.createTest("Verify login with valid credentials");
		landingPage = new LoginPage().loginToApp();
		test.log(Status.INFO, "Verifying login");
		Assert.assertTrue(landingPage.verifyWelcomeMessage());
		test.pass("test case passed");
		test.log(Status.INFO, "Login Successful");
	}

}
