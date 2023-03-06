/**
 * 
 */
package com.xais.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.xais.genericlibrary.Action;
import com.xais.genericlibrary.BaseClass;

/**
 * @author Dibyendu.raj
 *
 */
public class InternalFootprintMaintenance extends BaseClass{
	
	
	@FindBy(id = "txtClientName")
	WebElement clientName;
	
	@FindBy(id = "txtAppName")
	WebElement appName;
	
	@FindBy(id = "ddlIntServiceType")
	WebElement serviceType;
	
	@FindBy(id = "txtInputData_0")
	WebElement url;
	
	@FindBy(id = "ddlInputData_1")
	WebElement dbType;
	
	@FindBy(id = "txtInputData_2")
	WebElement dbSize;
	
	@FindBy(id = "txtInputData_3")
	WebElement dbBackup;
	
	@FindBy(id = "txtInputData_4")
	WebElement dbServer;
	
	@FindBy(id = "txtInputData_5")
	WebElement subscription;
	
	@FindBy(id = "txtInputData_6")
	WebElement resourceGroup;
	
	@FindBy(id = "txtInputData_7")
	WebElement appGateway;
	
	@FindBy(id = "txtInputData_8")
	WebElement budget;
	
	@FindBy(id = "txtInputData_9")
	WebElement managedIdentity;
	
	@FindBy(id = "txtInputData_10")
	WebElement azurekeyVault;
	
	@FindBy(id = "txtInputData_11")
	WebElement vnetDetails;
	
	@FindBy(id = "txtInputData_12")
	WebElement alerts;
	
	@FindBy(id = "txtInputData_13")
	WebElement devTeamContact;
	
	@FindBy(id = "txtInputData_14")
	WebElement devOps;
	
	@FindBy(id = "txtInputData_15")
	WebElement webAppService;
	
	@FindBy(id = "txtInputData_16")
	WebElement btAppService;
	
	@FindBy(id = "txtInputData_17")
	WebElement expectedVolume;
	
	@FindBy(id = "txtInputData_18")
	WebElement appOwner;
	
	@FindBy(id = "actSave")
	WebElement saveButton;
	
	public InternalFootprintMaintenance() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewInternalFootprint(String clientName, String appName, String serviceType, String url, String dbType, String dbSize, String dbBackup, String dbServer, String subscription, String resourceGroup, String appGateway, String budget, String managedIdentity, String azurekeyVault, String vnetDetails, String alerts, String devTeamContact, String devOps, String webAppService, String btAppService, String expectedVolume, String appOwner) {
		Action.selectByVisibleText(clientName, this.clientName);
		Action.type(this.appName, appName);
		Action.selectByVisibleText(serviceType, this.serviceType);
		Action.type(this.url, url);
		Action.selectByVisibleText(dbType, this.dbType);
		Action.type(this.dbSize, dbSize);
		Action.type(this.dbBackup, dbBackup);
		Action.type(this.dbServer, dbServer);
		Action.type(this.subscription, subscription);
		Action.type(this.resourceGroup, resourceGroup);
		Action.type(this.appGateway, appGateway);
		Action.type(this.budget, budget);
		Action.type(this.managedIdentity, managedIdentity);
		Action.type(this.azurekeyVault, azurekeyVault);
		Action.type(this.vnetDetails, vnetDetails);
		Action.type(this.alerts, alerts);
		Action.type(this.devTeamContact, devTeamContact);
		Action.type(this.devOps, devOps);
		Action.type(this.webAppService, webAppService);
		Action.type(this.btAppService, btAppService);
		Action.type(this.expectedVolume, expectedVolume);
		Action.type(this.appOwner, appOwner);
		//Action.click(driver, saveButton);		
	}
}
