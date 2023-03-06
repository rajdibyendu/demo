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
public class CaseInitiation extends BaseClass{
	
	@FindBy(id = "ddlProcessId")
	private WebElement processDropdown;
	
	@FindBy(id = "btnRefreshParameters")
	private WebElement refreshParameterButton;
	
	@FindBy(id = "txtIstrNotes")
	private WebElement notesTextbox;
	
	@FindBy(id = "txtParameter_0")
	private WebElement firstParameter;
	
	@FindBy(id = "txtParameter_1")
	private WebElement secondParameter;
	
	@FindBy(id = "FreezedControl_btnSave")
	private WebElement initializeButton;
	
	@FindBy(xpath = "(//div[@id='GlobalMessageDiv'])[2]")
	private WebElement messageDiv;

	
	@FindBy(xpath = "//img[@alt='loader']")
	private WebElement loader;
	
	public CaseInitiation() {
		PageFactory.initElements(driver, this);
	}
	
	public void initiateClientRegistration(String notes) {
		Action.selectByVisibleText("Client Registration", processDropdown);
		Action.click(driver, notesTextbox);
		Action.type(notesTextbox, notes);
		Action.click(driver, initializeButton);
		Action.waitUntilInvisibilityOf(driver, loader, 30);
	}
	
	public String getTitle() {
		return Action.getTitle(driver);
	}
	
	public String getMessage() {
		return messageDiv.getText();
	}

}

