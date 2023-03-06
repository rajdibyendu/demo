/**
 * 
 */
package com.xais.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xais.genericlibrary.BaseClass;

/**
 * @author Dibyendu.raj
 *
 */
public class ClientLookup extends BaseClass{
	
	@FindBy(id = "lstrformtitle")
	WebElement formTitle;
	
	@FindBy(xpath = "//*[@data-sfwcontroltype = 'sfwListViewContent']//label[@sfwcaption = 'Client Name']")
	List<WebElement> searchResults;
	
	public ClientLookup() {
		PageFactory.initElements(driver, this);
	}
	
	public ClientSummaryMaintenance clickOnFirstCard() {
		for(WebElement firstCardElement : searchResults) {
			if(firstCardElement.getText().equalsIgnoreCase("race")) {
				firstCardElement.click();
				break;
			}
		}
		return new ClientSummaryMaintenance();
	}

}
