/**
 * 
 */
package com.xais.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.xais.genericlibrary.Action;
import com.xais.genericlibrary.BaseClass;
import com.xais.pageobjects.ClientSummaryMaintenance;
import com.xais.pageobjects.LandingPage;
import com.xais.pageobjects.LoginPage;


/**
 * @author Dibyendu.raj
 *
 */
public class ClientTest extends BaseClass{
	LoginPage loginPage;
	LandingPage landingPage;
	ClientSummaryMaintenance clientSummary;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyClientLookupAndMaintenance() {
		landingPage = new LoginPage().loginToApp();
		clientSummary = landingPage.clickOnXcCard().clickOnFirstCard();
		Action.pageLoadTimeOut(driver, 30);
		String actTitle = clientSummary.getTitle();
		String expTitle =  "ClientSummary Maintenance";
		Assert.assertEquals(actTitle, expTitle);
		
	}
}
