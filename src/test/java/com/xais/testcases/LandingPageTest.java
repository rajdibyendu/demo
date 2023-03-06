/**
 * 
 */
package com.xais.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.xais.genericlibrary.BaseClass;
import com.xais.genericlibrary.ListenerClass;
import com.xais.pageobjects.LandingPage;
import com.xais.pageobjects.LoginPage;

/**
 * @author Dibyendu.raj
 *
 */
public class LandingPageTest extends BaseClass{
	LoginPage loginPage;
	LandingPage landingPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void validateCard() {
		landingPage = new LoginPage().loginToApp();
		ListenerClass.test.log(Status.INFO, "Verifying the visibility of XIF card");
		Assert.assertTrue(landingPage.validateXifCard());
		ListenerClass.test.log(Status.INFO, "Verifying the visibility of XC card");
		Assert.assertTrue(landingPage.validateXcCard());
		ListenerClass.test.log(Status.INFO, "Verifying the visibility of XD card");
		Assert.assertTrue(landingPage.validateXdCard());
	}

}
