package PageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubscriptionBundlePage extends BasePage {

	public SubscriptionBundlePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@type='radio' and @name='product_id']")
	List<WebElement> pricingPlanRadioButtons;

	public void clickMonthlyPricingPlanRadioButton() {
		pricingPlanRadioButtons.get(0).click();
	}

	public void clickSixMonthPricingPlanRadioButton() {
		// Click the second element
		pricingPlanRadioButtons.get(1).click();
	}

	public boolean isSixMonthPricingPlanRadioButtonSelected() {
		// Click the second element
		return pricingPlanRadioButtons.get(1).isSelected();
	}

	public boolean isMonthlyPricingPlanRadioButtonSelected() {
		// Click the second element
		return pricingPlanRadioButtons.get(0).isSelected();
	}

}
