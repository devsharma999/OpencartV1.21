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
	@FindBy(xpath = "//span[normalize-space()='Currency']")
	WebElement btn_currency;
	@FindBy(xpath = "//button[contains(text(),'€Euro')]")
	WebElement btn_euro;
	@FindBy(xpath = "//button[normalize-space()='$US Dollar']")
	WebElement btn_usd;
	@FindBy(xpath = "//button[normalize-space()='£Pound Sterling']")
	WebElement btn_pound;

	
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

	public void clickCurrency() {
		btn_currency.click();
	}

	public void currencyToPound() {
		btn_pound.click();
	}

	public void currencyToUSD() {
		btn_usd.click();

	}

	public void currencyToEuro() {
		btn_euro.click();
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
	public boolean confirmationCurrency(String currency) {
	    String symbol = "";
	    switch (currency.toLowerCase()) {
	        case "pound":
	            symbol = "\u00A3";
	            break;
	        case "usd":
	            symbol = "\u0024";
	            break;
	        case "euro":
	            symbol = "\u20AC"; // Correct Unicode for €
	            break;
	        default:
	            System.out.println("Unsupported currency: " + currency);
	            return false;
	    }

	    try {
	        String dynamicXpath = String.format("//strong[contains(normalize-space(),'%s')]", symbol);
	        WebElement confirmingCurrency = driver.findElement(By.xpath(dynamicXpath));
	        String fc = confirmingCurrency.getText().trim();
	        return fc.contains(symbol); // or use fc.equals(symbol) if exact match is expected
	    } catch (Exception e) {
	        System.out.println("Confirmation element not found or text mismatch: " + e.getMessage());
	        return false;
	    }
	}
}

