package PageObjets;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import TestBase.BasePage;

public class ResultPage extends BasePage {

	public ResultPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='Add to Cart']")
	WebElement btn_addtocart;
	@FindBy(xpath = "//span[normalize-space()='Checkout']")
	WebElement btn_checkout;
	

	public void clickAddtocart() {
		btn_addtocart.click();
	}
	
	public void clickCheckout() {
		btn_checkout.click();
	}

	public boolean confirmationAddtoCart(String product) {
		try {
			String dynamicPath = String
					.format("//div[@class='alert alert-success alert-dismissible']//a[contains(text(),'%s')]", product);
			WebElement txt_confirm = driver.findElement(By.xpath(dynamicPath));
			String actualText = "Success: You have added " + txt_confirm.getText() + " Air to your shopping cart!";
			System.out.println(txt_confirm.getText());
			System.out
					.println(actualText + "===" + "Success: You have added " + product + " Air to your shopping cart!");

			return actualText.equalsIgnoreCase("Success: You have added " + product + " Air to your shopping cart!");
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return false;
		}
	}
}

