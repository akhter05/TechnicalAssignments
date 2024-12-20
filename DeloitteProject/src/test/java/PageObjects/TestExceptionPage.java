/**
 * 
 */
package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 */
public class TestExceptionPage extends BasePage {

	public TestExceptionPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//button[@id='edit_btn']")
	WebElement editBtn;

	@FindBy(xpath = "//button[@id='save_btn']")
	WebElement row1SaveBtn;

	@FindBy(xpath = "//input[@value='Pizza']")
	WebElement inputFavFoodField;

	@FindBy(xpath = "//button[@id='add_btn']")
	WebElement addBtn;

	@FindBy(xpath = "//button[@id='remove_btn']")
	WebElement removeBtn;

	@FindBy(xpath = "//div[@id='confirmation']")
	WebElement saveConfirmMsg;

	@FindBy(xpath = "//div[@id='row2']//input[@type='text']")
	WebElement row2Input;

	@FindBy(xpath = "//div[@id=\"row2\"]//button[@name=\"Save\"][normalize-space()=\"Save\"]")
	WebElement row2SaveBtn;

	public void clickEditButton() {
		editBtn.click();
	}

	public void setRow1FavouriteFood(String food) {
		inputFavFoodField.clear();
		inputFavFoodField.sendKeys(food);
		row1SaveBtn.click();
	}

	public void clickRow1SaveButton() {
		row1SaveBtn.click();
	}
	
	public void clickRow2SaveButton() {
		row2SaveBtn.click();
	}

	public void clickSaveButton() {
		row1SaveBtn.click();
	}

	public void clickAddbutton() {

		addBtn.click();
	}

	public boolean isSavedMsgDisplayed() {

		return saveConfirmMsg.isDisplayed();
	}

	public boolean isRow2inputDisplayed() {

		return row2Input.isDisplayed();
	}

	public void setRow2FavouriteFood(String food) {

		row2Input.sendKeys(food);
		row2SaveBtn.click();
	}

}
