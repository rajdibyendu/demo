/**
 * 
 */
package com.xais.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.xais.genericlibrary.Action;
import com.xais.genericlibrary.BaseClass;
import com.xais.genericlibrary.FileLibrary;

/**
 * @author Dibyendu.raj
 *
 */
public class InternalFootprintLookup extends BaseClass{
	
	FileLibrary fLib = new FileLibrary();
	
	@FindBy(id = "actNew1")
	WebElement newButton;
	
	public InternalFootprintLookup() {
		PageFactory.initElements(driver, this);
	}
	
	public InternalFootprintMaintenance clickOnNewButton() {
		Action.click(driver, newButton);
		return new InternalFootprintMaintenance();
	}
	
	public String getTitle() {
		return Action.getTitle(driver);
	}
}
