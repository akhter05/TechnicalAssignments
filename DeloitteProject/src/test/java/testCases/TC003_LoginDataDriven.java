package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.PracticePage;
import PageObjects.PracticeTestLogin;
import Utilities.DataProviders;
import testBase.BaseClass;

/* Test cases covered:
 * Login credential valid - login success - logout-passed
 * Login credential valid - login fail - fail
 * 
 * Login credential invalid - login success - logout-fail
 * Login credential invalid - login fail - passed
 * 
 */

public class TC003_LoginDataDriven extends BaseClass {

	@Test(groups={"datadriven","master"}, dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void Verify_LoginByDataDriven(String userName, String pwd, String result) {
		logger.info("***********Starting TC003_LoginDataDriven ************");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickPracticeMenu();
			logger.info("Clicked on Practice Menu");
			PracticePage pp = new PracticePage(driver);
			pp.clickTestLoginPage();
			logger.info("Clicked on Test Login link");
			PracticeTestLogin ptl = new PracticeTestLogin(driver);
			try {
				ptl.setUserName(userName);
				ptl.setUserPwd(pwd);
			} catch (Exception e) {

			}
			ptl.clickSubmit();
			logger.info("Entered username and pwd then clicked submit button");

			Boolean loginmsgdisplayed = false;
			
			try {
			loginmsgdisplayed = ptl.isLoginMsgDisplayed();
			} catch (Exception e) {

			}

			if (result.equalsIgnoreCase("Valid")) {
				if (loginmsgdisplayed == true) {
					Assert.assertTrue(true);
					ptl.clickLogout();
				} else {
					logger.error("Test failed");
					logger.debug("Debug log");
					Assert.assertTrue(false);
				}
			} else if (result.equalsIgnoreCase("Invalid")) {
				if (loginmsgdisplayed == false) {
					Assert.assertTrue(true);
				} else {
					logger.error("Test failed");
					logger.debug("Debug log");
					ptl.clickLogout();
					Assert.assertTrue(false);
				}

			}

		} catch (Exception e) {
			Assert.fail();
			logger.debug("Exception: " + e.getMessage());
		}

		logger.info("*****************Ending test TC003_LoginDataDriven*****************");
	}

}
