package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.PracticePage;
import PageObjects.PracticeTestLogin;
import testBase.BaseClass;

public class TC002_LogInFail extends BaseClass{
	
@Test(groups={"regression","master"})
public void Verify_Login_Fail()
{
logger.info("*****************Starting test TC002_LogInFail*****************");
try {
	HomePage hp= new HomePage(driver);
	hp.clickPracticeMenu();
	logger.info("Clicked on Practice Menu");
	PracticePage pp= new PracticePage(driver);
	pp.clickTestLoginPage();
	logger.info("Clicked on Test Login link");
	PracticeTestLogin ptl = new PracticeTestLogin(driver);
	ptl.setUserName("failedTest");
	ptl.setUserPwd("failedTest");
	ptl.clickSubmit();
	logger.info("Entered invalid username and pwd then clicked submit button");
	String errormsg = ptl.getInvalidUserErrorMsg();
	
	if (errormsg.equalsIgnoreCase("Your username is invalid!"))
	{
	Assert.assertTrue(true);
	}
	else
	{
		logger.error("Test failed");
		logger.debug("Debug log");
		Assert.assertTrue(false);
	}
	
	}
	catch(Exception e)
	{
	
	Assert.fail();	
	}

logger.info("*****************Ending test TC002_LogInFail*****************");
}

}
