/**
 * 
 */
package com.xais.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.xais.genericlibrary.BaseClass;
import com.xais.pageobjects.LandingPage;
import com.xais.pageobjects.LoginPage;
import com.xais.genericlibrary.DataProviders;

/**
 * @author Dibyendu.raj
 *
 */
public class InternalFootprintTest extends BaseClass{
	
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
	
	@Test(dataProvider = "IneternalFootprint", dataProviderClass = DataProviders.class)
	public void verifyInternalFootprintWithAllFields(String clientName, String appName, String serviceType, String url, String dbType, String dbSize, String dbBackup, String dbServer, String subscription, String resourceGroup, String appGateway, String budget, String managedIdentity, String azurekeyVault, String vnetDetails, String alerts, String devTeamContact, String devOps, String webAppService, String btAppService, String expectedVolume, String appOwner) {
		landingPage = new LoginPage().loginToApp();
		Assert.assertTrue(landingPage.verifyWelcomeMessage());
		//test.log(Status.INFO, "Login successful");
		//test.log(Status.INFO, "Entering all fields and clicking save button");
		landingPage.clickOnXifCard().clickOnNewButton().createNewInternalFootprint(clientName, appName, serviceType, url, dbType, dbSize, dbBackup, dbServer, subscription, resourceGroup, appGateway, budget, managedIdentity, azurekeyVault, vnetDetails, alerts, devTeamContact, devOps, webAppService, btAppService, expectedVolume, appOwner);
		
	}
}
