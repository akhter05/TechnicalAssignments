package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.PracticePage;
import PageObjects.TestExceptionPage;
import testBase.BaseClass;

public class TC004_TestException_ElementNotInteractableException extends BaseClass {

	@Test(groups = {"regression","master"})
	public void Verify_ElementNotInteractableException() {
		logger.info("***********Starting TC004_TestExceptionAdd ************");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickPracticeMenu();
			logger.info("Clicked on Practice Menu");
			PracticePage pp = new PracticePage(driver);
			pp.clickTestExceptionLink();
			TestExceptionPage te = new TestExceptionPage(driver);
			te.clickAddbutton();
			te.setRow2FavouriteFood("burger");
			try {
			te.clickRow2SaveButton();
			te.isSavedMsgDisplayed();
			}catch(Exception e)
			{
				if(e.getMessage().contains("element not interactable"))
				{assertTrue(true);}
				
			}

		} catch (Exception e) {

			logger.debug("Exception: " + e.getMessage());
			System.out.println(e.getMessage());
			Assert.fail();
		}
		logger.info("***********Ending TC004_TestExceptionAdd************");

	}
}
