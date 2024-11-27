package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath= "/html/body/div/div/header/div[3]/div[1]/div/div[2]/div/nav/ul/li[2]/a")
	WebElement practiceMenu;
	
	public void clickPracticeMenu()
	{
		practiceMenu.click();
	}
	

}
