package com.fyber.selenium.webdriver.base;

import org.openqa.selenium.WebDriver;

public class WebDriverTestBase {

	public static WebDriver driver;
	private static String browserType = "firefox";

	/**
	 * Set Browser for WebDriver.
	 * 
	 * @param browser
	 *            - browser to initialization.
	 */
	public static void setBrowserType(String browser) {
		browserType = browser;

	}

	/**
	 * WebDriver initialization.
	 */
	public void initWebDriver() {

		switch (browserType) {
		
		case "firefox":
			WebDriverWrapper.initFirefoxDriver();
			break;
		case "chrome":
			WebDriverWrapper.initChromeDriver();
			break;

		case "ie":
		case "iexplorer":
		case "internetexplorer":
			WebDriverWrapper.initInternetExplorerDriver();
			break;

		}
		driver = WebDriverWrapper.getDriver();
	}

}
