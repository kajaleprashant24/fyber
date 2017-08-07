package com.fyber.selenium.webdriver.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitService {

	public static int TIMEOUT = 30; // second
	WebDriver driver;

	public WaitService() {
		super();
		this.driver = WebDriverWrapper.getDriver();
	}

	public  void waitForElementVisible(WebElement element) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	
}
