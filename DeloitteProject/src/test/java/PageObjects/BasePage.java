package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void swicthToFrame(String iframeIdOrNam) {
		 // Switch to the iframe by ID or Name passed as a parameter
        driver.switchTo().frame(iframeIdOrNam);  // Using the ID or Name of the iframe passed to the method
	}

	public void swicthBackToMainPageFromFrame() {		
	// Switch back to the main page (default content)
    driver.switchTo().defaultContent();
	}

	public void swicthBackToMainBrowserTab(String mainWindowHandle) {
		// Switch back to the main window
		driver.close();
		driver.switchTo().window(mainWindowHandle);

	}

	public static HashMap<Integer, String> storeValuesInHashMap(ArrayList<String> values) {

		HashMap<Integer, String> map = new HashMap<>();
		// Loop through each value in the ArrayList
		for (int i = 0; i < values.size(); i++) {
			map.put(i, values.get(i)); // Use i as the sequential key starting from 0
		}
		// Return the populated HashMap
		return map;
	}

	public boolean waitForStaleElementAndVisibility(By locator, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = null;
		int MAX_RETRIES = 5;
		// Retry loop to handle StaleElementReferenceException
		for (int i = 0; i < MAX_RETRIES; i++) {
			try {
				// Try to find the element again
				element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

				// If the element is found, check if it is visible in the DOM
				if (element.isDisplayed()) {
					return true; // Element is visible, return true
				}
			} catch (StaleElementReferenceException e) {
				// Element is stale, continue to retry
				System.out.println("Stale element detected. Retrying...");
			} catch (TimeoutException e) {
				// Timeout reached, element was not found or visible
				System.out.println("Timeout reached. Element not visible after waiting for " + timeout + " seconds.");
				return false;
			} catch (NoSuchElementException e) {
				// If element is not found, continue to retry
				System.out.println("Element not found. Retrying...");
			}

			try {
				// Wait for a short duration before retrying (e.g., 1 second)
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return false; // Return false if we couldn't find or make the element visible

	}
}
