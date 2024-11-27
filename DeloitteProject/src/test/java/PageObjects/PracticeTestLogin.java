package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeTestLogin extends BasePage {

	public PracticeTestLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "/html/body/div/div/section/section/div[1]/div[1]/input")
	WebElement txtUserName;

	@FindBy(xpath = "/html/body/div/div/section/section/div[1]/div[2]/input")
	WebElement txtUserPwd;

	@FindBy(xpath = "/html/body/div/div/section/section/div[1]/button")
	WebElement btnSubmit;

	@FindBy(xpath = "/html/body/div/div/section/div/div/article/div[2]/p[1]/strong")
	WebElement msgConfirmation;

	@FindBy(xpath = "/html/body/div/div/section/section/div[2]")
	WebElement invalidUsererrorMsg;

	@FindBy(xpath = "/html/body/div/div/section/div/div/article/div[2]/div/div/div/a")
	WebElement logoutButton;

	public void setUserName(String username) {
		txtUserName.sendKeys(username);

	}

	public void setUserPwd(String pwd) {
		txtUserPwd.sendKeys(pwd);

	}

	public void clickSubmit() {
		btnSubmit.click();

	}

	public String getLoginConfirmation() {
		try {
			return msgConfirmation.getText();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String getInvalidUserErrorMsg() {
		try {
			return invalidUsererrorMsg.getText();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public Boolean isLoginMsgDisplayed() {
		try {
			return msgConfirmation.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public void clickLogout() {

		logoutButton.click();
	}

	public Boolean IsLoginPageDisplayed() {

		return txtUserName.isDisplayed();
	}
}
