/**
 * 
 */
package com.xais.pageobjects;

import java.sql.Driver;
import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xais.genericlibrary.Action;
import com.xais.genericlibrary.BaseClass;

/**
 * @author Dibyendu.raj
 *
 */
public class MyBasket extends BaseClass{
	
	@FindBy(xpath = "//select[@id='ddlProcessId']")
	private WebElement processNameDropdown;
	
	@FindBy(xpath = "//input[@id='txtRequestDateFrom']")
	private WebElement initiatedDate;
	
	@FindBy(xpath = "//button[@id='btnSearchActivities']")
	private WebElement applyFilterButton;
	
	@FindBy(xpath = "//label[contains(text(),'%s')]//parent::td//following-sibling::td/a/span[text()='Checkout'])[1]")
	private WebElement checkoutButton;
	
	public MyBasket() {
		PageFactory.initElements(driver, this);
	}
	
	public void searchActivity(String processName, String activity) throws InterruptedException {
		
		Action.selectByVisibleText(processName, processNameDropdown);
		Thread.sleep(5000);
		initiatedDate.click();
		Thread.sleep(2000);
		initiatedDate.clear();
		Thread.sleep(2000);
		initiatedDate.sendKeys("03/02/2023");
		Thread.sleep(10000);
		//Action.type(initiatedDate, Action.getCurrentDate());
		Instant startTime = Instant.now();
//        while (Duration.between(startTime, Instant.now()).toMinutes() < 5) {
//            try {
//            	WebElement element = driver.findElement(By.xpath(String.format(checkoutButton.getAttribute("xpath"), activity)));
//                Action.click(driver, element);
//                break;
//            } catch (Exception e) {
//            	Action.click(driver, applyFilterButton);
//            	
//                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-form-id")));
//            }
//        }
		
		
//		Action.selectByVisibleText(processName, processNameDropdown);
//		Action.type(initiatedDate, Action.getCurrentDate());
//		Action.click(driver, applyFilterButton);
	}
	
	public void clickOnCheckoutButton(String stepName) {
	    WebElement element = driver.findElement(By.xpath(String.format(checkoutButton.getAttribute("xpath"), stepName)));
	    element.click();
	}


}
