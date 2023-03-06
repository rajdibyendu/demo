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
public class LoginPage extends BaseClass{
	
	@FindBy(id = "txtUserName")
	WebElement username;
	
	@FindBy(id = "txtPassword")
	WebElement password;
	
	@FindBy(id = "btnLogin")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public LandingPage loginToApp() {
		Action.type(username, properties.getProperty("username"));
		Action.type(password, properties.getProperty("password"));
		Action.click(driver, loginButton);
		return new LandingPage();
	}
}
