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
public class EnvironmentLookup extends BaseClass {
	
	@FindBy(xpath = "//span[contains(text(),'Error Message')]/../button")
	WebElement closeButton;
	
	@FindBy(id = "lstrformtitle")
	WebElement formTitle;
	
	public EnvironmentLookup() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		String title = Action.getTitle(driver);
		return title;
	}
	
	public void clickOnCloseButton() {
		Action.click(driver, closeButton);
	}
}
