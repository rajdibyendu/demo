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
import com.xais.pageobjects.CaseInitiation;
import com.xais.pageobjects.LandingPage;
import com.xais.pageobjects.LoginPage;
import com.xais.pageobjects.MyBasket;

/**
 * @author Dibyendu.raj
 *
 */
public class ClientRegistrationWorkflowTest extends BaseClass{
	LoginPage loginPage;
	LandingPage landingPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
	@Test
	public void clientRegistrationInitiation() throws InterruptedException {
		ListenerClass.test.log(Status.INFO, "Launching case initiation page");
		CaseInitiation caseInitiation = new LoginPage().loginToApp().clickOnCaseInitiation();
		ListenerClass.test.log(Status.INFO, "Initiating client registration workflow");
		caseInitiation.initiateClientRegistration("test notes");
		Assert.assertTrue(caseInitiation.getMessage().contains("Workflow process Initiated"));
	}
	
	@Test//(dependsOnMethods = "clientRegistrationInitiation")
	public void captureClientInformation() throws InterruptedException {
//		ListenerClass.test.log(Status.INFO, "Navigate to BPM MY Basket");
		new LoginPage().loginToApp().clickOnMyBasket().searchActivity("Client Registration", "Capture");
//		CaseInitiation caseInitiation = new LoginPage().loginToApp().clickOnCaseInitiation();
//		ListenerClass.test.log(Status.INFO, "Initiating client registration workflow");
//		caseInitiation.initiateClientRegistration("test notes");
//		Assert.assertTrue(caseInitiation.getMessage().contains("Workflow process Initiated"));
	}

}
