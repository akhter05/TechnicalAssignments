package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.PracticePage;
import PageObjects.PracticeTestLogin;
import testBase.BaseClass;

public class TC001_LogInSuccess extends BaseClass {

	@Test(groups = { "sanity", "master" })
	public void Veiry_Login_Success() {
		logger.info("***********Starting TC001_LogInSuccess ************");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickPracticeMenu();
			logger.info("Clicked on Practice Menu");
			PracticePage pp = new PracticePage(driver);
			pp.clickTestLoginPage();
			logger.info("Clicked on Test Login link");
			PracticeTestLogin ptl = new PracticeTestLogin(driver);
			ptl.setUserName(prop.getProperty("userName"));
			ptl.setUserPwd(prop.getProperty("pwd"));
			ptl.clickSubmit();
			logger.info("Entered username and pwd then clicked submit button");
			String loginmsg = ptl.getLoginConfirmation();

			if (loginmsg.equalsIgnoreCase("Congratulations student. You successfully logged in!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed");
				logger.debug("Test validation failed");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {

			Assert.fail();
			logger.debug("Exception: " + e.getMessage());
		}
		logger.info("***********Ending TC001_LogInSuccess ************");
	}

}
