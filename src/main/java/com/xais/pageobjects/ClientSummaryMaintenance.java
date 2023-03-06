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
public class ClientSummaryMaintenance extends BaseClass{
	
	@FindBy(id = "lstrformtitle")
	WebElement formTitle;
	
	public ClientSummaryMaintenance() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		String title = Action.getTitle(driver);
		return title;
	}
	

}
