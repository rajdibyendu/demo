/**
 * 
 */
package com.xais.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xais.genericlibrary.Action;
import com.xais.genericlibrary.BaseClass;

/**
 * @author Dibyendu.raj
 *
 */
public class LandingPage extends BaseClass{
	
	@FindBy(xpath = "//span[text()='Internal Footprint']")
	WebElement xif;
	
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement xc;
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement xd;
	
	@FindBy(id = "btnWelComeDivCollapseExpand")
	WebElement welcome;
	
	@FindBy(xpath = "//a[normalize-space()='Case Initiation']")
	WebElement caseInitiationButton;
	
	@FindBy(xpath = "//a[normalize-space()='BPM']")
	private WebElement bpmMenu;
	
	@FindBy(xpath = "//a[@data-sfwcontroltype = 'sfwMenuText' and text()='My Basket']")
	private WebElement myBasketButton;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		String title = Action.getTitle(driver);
		return title;
	}
	
	public boolean verifyWelcomeMessage() {
		return Action.isDisplayed(driver, welcome);
	}
	
	public boolean validateXifCard() {
		return Action.isDisplayed(driver, xif);
	}
	
	public boolean validateXcCard() {
		return Action.isDisplayed(driver, xc);
	}
	
	public boolean validateXdCard() {
		return Action.isDisplayed(driver, xd);
	}
	
	public InternalFootprintLookup clickOnXifCard() {
		Action.click(driver, xif);
		return new InternalFootprintLookup();
	}
	
	public ClientLookup clickOnXcCard() {
		Action.click(driver, xc);
		return new ClientLookup();
	}
	
	public void clickOnXdCard() {
		Action.click(driver, xd);
	}
	
	public CaseInitiation clickOnCaseInitiation() {
		Actions actions = new Actions(driver);
		actions.moveToElement(bpmMenu).click(caseInitiationButton).build().perform();
		return new CaseInitiation();
	}
	
	public MyBasket clickOnMyBasket() {
		Actions actions = new Actions(driver);
		actions.moveToElement(bpmMenu).click(myBasketButton).build().perform();
		return new MyBasket();
	}
}
