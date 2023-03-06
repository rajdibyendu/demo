package com.xais.genericlibrary;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Dibyendu.raj
 *
 */
public class Action extends BaseClass {

	public static void click(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}
	
	/**
	 * Type text at location
	 * 
	 * @param locatorName
	 * @param text
	 * @return - true/false
	 */
	public static boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}
		}
		return flag;
	}
	
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
	}
	
	public static String getTitle(WebDriver driver) {
	    try {
	        String text = driver.getTitle();
	        System.out.println("Title of the page is: " + text);
	        return text;
	    } catch (Exception e) {
	        System.out.println("Unable to retrieve the title of the page: " + e.getMessage());
	        return null;
	    }
	}
	
	public static boolean isDisplayed(WebDriver driver, WebElement ele) {
	    boolean flag = false;
	    try {
	        if (ele.isDisplayed()) {
	            System.out.println("Element is displayed");
	            flag = true;
	        } else {
	            System.out.println("Element is not displayed");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Element not found");
	    }
	    return flag;
	}
	
	public static boolean selectByVisibleText(String visibletext, WebElement ele) {
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			System.out.println("selected option is : " + visibletext);
			return true;
		} catch (Exception e) {
			System.out.println("Unable to select any options");
			return false;
		}
	}

	public static String takeScreenshot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\Screenshot\\" + filename + "_" + dateName + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}
	
	public static void waitUntilInvisibilityOf(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static String getCurrentDate() {
		String currentDate = new SimpleDateFormat("MMddyyyy").format(new Date());
		System.out.println("Current date is : "+currentDate);
		return currentDate;
	}
}
