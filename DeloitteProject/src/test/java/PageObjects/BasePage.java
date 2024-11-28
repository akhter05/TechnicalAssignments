package PageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String swicthToNewBrowserTab() {
		// Get the current window handle (Main Window)
		String mainWindowHandle = driver.getWindowHandle();
		// Get all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		// Switch to the new window
		for (String handle : windowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		return mainWindowHandle;

	}

	public void swicthBackToMainBrowserTab(String mainWindowHandle) {
		// Switch back to the main window
		driver.switchTo().window(mainWindowHandle);

	}
}
