package com.fyber.selenium.assertions;

import com.fyber.selenium.webdriver.base.AbstractTestBase;

public class VerificationServiceImpl implements VerificationService {

	/**
	 * Verify that current page URL matches the expected URL.
	 */
	public boolean verifyPageUrl(String Url) {
		// TODO Auto-generated method stub
		return AbstractTestBase.driver.getCurrentUrl().equalsIgnoreCase(Url);
	}
}
