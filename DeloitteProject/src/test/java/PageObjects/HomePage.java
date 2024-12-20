package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "/html/body/div/div/header/div[3]/div[1]/div/div[2]/div/nav/ul/li[2]/a")
	WebElement practiceMenu;

	@FindBy(xpath = "//a[normalize-space()='privacy policy']")
	WebElement privacyPolicyLink;

	@FindBy(xpath = "//a[normalize-space()='Courses']")
	WebElement coursesMenu;

	@FindBy(xpath = "//a[normalize-space()='Contact']")
	WebElement contactMenu;

	public void clickPracticeMenu() {
		practiceMenu.click();
	}

	public void clickPrivacyPolicyLink() {
		privacyPolicyLink.click();
	}

	public void clickCoursesManu() {
		coursesMenu.click();
	}

	public void clickContactManu() {
		contactMenu.click();
	}

}
