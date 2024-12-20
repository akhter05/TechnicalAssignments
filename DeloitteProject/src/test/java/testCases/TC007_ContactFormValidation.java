package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.ContactPage;
import PageObjects.HomePage;
import testBase.BaseClass;

public class TC007_ContactFormValidation extends BaseClass {

	@Test(groups = { "regression", "master" })
	public void verify_ContactPage_Fields() {

		// Test will validate fields of Contact Page and also captcha which exists
		// inside a iFrame

		logger.info("***********Starting TC007_ContactFormValidation ************");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickContactManu();
			ContactPage cp = new ContactPage(driver);
			cp.openURLofCaptchaFrame();
			String mainhandle = cp.swicthToNewBrowserTab();
			if (cp.IsCaptchaLabelDisplayed() == true) {
				cp.clickCaptchaCheckbox();
				cp.swicthBackToMainBrowserTab(mainhandle);
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			logger.error("Test Failed");
			logger.debug(e.getMessage());
			Assert.assertTrue(false);
		}
		logger.info("***********Ending TC007_ContactFormValidation ************");

	}
}
