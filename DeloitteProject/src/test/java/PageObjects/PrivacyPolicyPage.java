package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyPolicyPage extends BasePage {

	public PrivacyPolicyPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h1[@class='post-title']")
	WebElement privacyPageHeading;

	public boolean isPrivacyPolicayHeadingDisplayed() {
		return privacyPageHeading.isDisplayed();
	}
}
