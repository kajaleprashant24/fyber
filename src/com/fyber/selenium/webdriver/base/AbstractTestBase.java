package com.fyber.selenium.webdriver.base;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;;;


public abstract class  AbstractTestBase extends WebDriverTestBase{

	public static String browser;
	
	
	public AbstractTestBase() {
		super();
		
	}

	/** Initialized instance of WebDriver before test suite execution
	 * 
	 */
	
	@BeforeSuite(alwaysRun = true)
	public void setUp()  {

		System.setProperty("webdriver.chrome.driver",
				"lib/selenium/chromedriver/chromedriver.exe");
		System.setProperty("webdriver.ie.driver",
				"lib/selenium/iedriver/IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver",
				"lib/selenium/gecko/geckodriver.exe");
		

		browser = System.getProperty("browser","chrome");

		setBrowserType(browser);

		initWebDriver();
		driver.manage().deleteAllCookies();
		if (browser == "chrome") {
			driver.manage().timeouts()
					.implicitlyWait(300, TimeUnit.MILLISECONDS);
		} else {
			driver.manage().timeouts()
					.implicitlyWait(100, TimeUnit.MILLISECONDS);
		}
	}

	
	/**
	 * Quit WebDriver instance after test suite execution.
	 * 
	 */
	@AfterSuite
	public void tearDown() {
		WebDriverWrapper.quit();
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}