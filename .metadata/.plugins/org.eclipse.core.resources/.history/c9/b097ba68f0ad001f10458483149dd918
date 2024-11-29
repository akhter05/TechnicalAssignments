package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.PrivacyPolicyPage;
import testBase.BaseClass;

public class TC005_PrivacyPolicyLink extends BaseClass {

	@Test(groups = { "regression", "master" })
	public void Verify_PrivacyPolicyLink() {
		logger.info("***********Starting TC005_PrivacyPolicyLink ************");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickPrivacyPolicyLink();
			String mainwindowhandle = hp.swicthToNewBrowserTab();
			logger.info("Switched to Privacy policy window");
			PrivacyPolicyPage prip = new PrivacyPolicyPage(driver);

			if (prip.isPrivacyPolicayHeadingDisplayed()) {
				driver.close();
				hp.swicthBackToMainBrowserTab(mainwindowhandle);
				Assert.assertTrue(true);
			} else {
				logger.error("Test Failed");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			logger.debug("Exception: " + e.getMessage());
			Assert.fail();
		}
		logger.info("***********Ending TC005_PrivacyPolicyLink ************");

	}

}
