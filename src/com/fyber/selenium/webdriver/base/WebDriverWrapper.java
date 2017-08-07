package com.fyber.selenium.webdriver.base;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public final class WebDriverWrapper {

	public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
	
	public WebDriverWrapper() {
	}

	public static int TIMEOUT = 30; // seconds
	
	/**
	 * Get WebDriver instance
	 * @return 
	 *         -WebDriver instance
	 */
	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	/**
	 * Set WebDriver instance
	 * @param webDriver
	 */
	public static void setWebDriver(WebDriver webDriver) {
		threadDriver.set(webDriver);
	}

	/**
	 * Set Default timeout for WebDriver
	 * 
	 * @param timeout
	 *           
	 */
	public static void setDefaultTimeout(int timeout) {
		TIMEOUT = timeout;
	}

	/**
	 * initialization FirefoxDriver
	 */
	public static void initFirefoxDriver() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setPreference("javascript.enabled", true);
	//	profile.setPreference("network.cookie.cookieBehavior", 2);
		setWebDriver(new FirefoxDriver(profile));
		setTimeout(TIMEOUT);
		getDriver().manage().window().maximize();
	}

	/**
	 * initialization InternetExplorerDriver
	 */
	public static void initInternetExplorerDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setJavascriptEnabled(true);
		setWebDriver(new InternetExplorerDriver(capabilities));
		setTimeout(TIMEOUT);
		getDriver().manage().window().maximize();
	}

	/**
	 * initialization ChromeDriver
	 * 
	 */
	public static void initChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
		options.addArguments("chrome.switches","--disable-extensions");
		options.addArguments("--test-type");
		options.addArguments(Arrays.asList("--no-sandbox","--ignore-certificate-errors","--homepage=about:blank","--no-first-run"));
		setWebDriver(new ChromeDriver(options));
		setTimeout(TIMEOUT);
		getDriver().manage().window().maximize();
	}

	

	/**
	 * Set Wait and Script timeouts for WebDriver
	 * 
	 * @param timeout
	 *            
	 */
	public static void setTimeout(int timeout) {
		getDriver().manage().timeouts()
				.implicitlyWait(timeout, TimeUnit.SECONDS);
		getDriver().manage().timeouts()
				.setScriptTimeout(timeout, TimeUnit.SECONDS);
	}

	
	/**
	 * Open web page
	 * 
	 * @param page
	 *            - url of webpage
	 */
	public static void open(String url) {
		getDriver().get(url);
		setTimeout(10);
	}

	/**
	 * Quit from WebDriver (Closes all browser windows and safely ends the
	 * session).
	 */
	public static void quit() {
		if (getDriver() != null) {
			getDriver().quit();
		}
	}

	/**
	 * Close the WebDriver (Close the browser window that the driver has focus
	 * of).
	 */
	public static void close() {
		if (getDriver() != null) {
			getDriver().close();
		}
	}
}
