package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//label[@id='recaptcha-anchor-label']")
	WebElement captchaLabel;

	@FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
	WebElement captchaCheckbox;

	@FindBy(xpath = "//iframe[@title='reCAPTCHA']")
	WebElement captchaIFrame;

	public boolean IsCaptchaLabelDisplayed() {
		return captchaLabel.isDisplayed();
	}

	public void clickCaptchaCheckbox() {
		captchaCheckbox.click();

	}

	public void openURLofCaptchaFrame() {
		String ifUrl = captchaIFrame.getAttribute("src");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		// Open a new tab using JavaScript
		jsExecutor.executeScript("window.open(arguments[0], '_blank');", ifUrl);

	}

}
