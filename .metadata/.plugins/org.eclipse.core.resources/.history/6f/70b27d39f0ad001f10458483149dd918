package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CoursesPage;
import PageObjects.HomePage;
import PageObjects.SubscriptionBundlePage;
import testBase.BaseClass;

public class TC006_CoursesSubscriptionRadioButtons extends BaseClass {

	@Test(groups = { "regression", "master" })
	public void Verify_SubscriptionPage_RadioButtons() {

		logger.info("***********Starting TC005_PrivacyPolicyLink ************");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickCoursesManu();
			CoursesPage cp = new CoursesPage(driver);
			cp.clicksubscriptionBundleLink();
			String mainWindow = cp.swicthToNewBrowserTab();
			SubscriptionBundlePage sbp = new SubscriptionBundlePage(driver);
			sbp.clickSixMonthPricingPlanRadioButton();
			if (sbp.isSixMonthPricingPlanRadioButtonSelected() == true) {
				logger.error("six month radio button selected");
			}
			sbp.clickMonthlyPricingPlanRadioButton();
			if (sbp.isSixMonthPricingPlanRadioButtonSelected() == true) {
				logger.error("Monthly radio button selected");
			}
			driver.close();
			sbp.swicthBackToMainBrowserTab(mainWindow);
			Assert.assertTrue(true);
		} catch (Exception e) {
			logger.error("test failed");
			logger.debug("Exception is " + e.getMessage());
			Assert.assertTrue(false);
		}

	}
}
