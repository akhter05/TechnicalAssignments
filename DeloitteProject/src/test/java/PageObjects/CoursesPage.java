package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoursesPage extends BasePage {

	public CoursesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Selenium WebDriver and Java Monthly Subscription B')]")
	WebElement subscriptionBundleLink;

	public void clicksubscriptionBundleLink() {
		subscriptionBundleLink.click();
	}
	
	
}
