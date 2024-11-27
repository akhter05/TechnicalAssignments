package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticePage extends BasePage{

	public PracticePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a")
	WebElement linkRestLogingPage;
	
	public void clickTestLoginPage()
	{
		linkRestLogingPage.click();
		
	}

}
