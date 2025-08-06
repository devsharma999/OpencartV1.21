package PageObjets;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement btn_myacc;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement btn_register;
	@FindBy(xpath = "(//a[normalize-space()='Login'])[1]")
	WebElement btn_login;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txt_search;

	public void clickmyacc() {
		btn_myacc.click();
	}

	public void clickregister() {
		btn_register.click();
	}

	public void clicklogin() {
		btn_login.click();
	}

	public void setSearch(String product) {
		txt_search.sendKeys(product + Keys.ENTER);
	}

	public boolean confirmationSearch(String product) {
		try {
			String dynamicXPath = String.format("//h1[normalize-space()='Search - %s']", product);
			WebElement confirmingSearch = driver.findElement(By.xpath(dynamicXPath));
			String actualText = confirmingSearch.getText();
			System.out.println(actualText);
			return actualText.equalsIgnoreCase("Search - " + product);
		} catch (Exception e) {
			System.out.println("Confirmation element not found or text mismatch: " + e.getMessage());
			return false;
		}
	}
}
