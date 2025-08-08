package PageObjets;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.*;

import TestBase.BasePage;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btn_checkout;
	
	public void clickCheckout() {
		btn_checkout.click();
	}
	public boolean confirmationCheckout() {
		return true;
	}
}
