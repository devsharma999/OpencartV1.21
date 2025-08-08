package PageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.BasePage;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msgheading;
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btn_logout;
	@FindBy(xpath ="//h1[normalize-space()='Account Logout']")
	WebElement msgConfirmation;

	public boolean confirmation() {
		try {
			return msgheading.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public void click_logout() {
		btn_logout.click();
	}
	
	public boolean confirmationlogout() {
		String msg = msgConfirmation.getText();
		return msg.equalsIgnoreCase("Account Logout");
	}

}

