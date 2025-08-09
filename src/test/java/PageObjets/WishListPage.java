package PageObjets;

import java.util.*;
import TestBase.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

	public WishListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class='btn btn-danger']")
	WebElement btn_remove;

	public void clickRemover() {
		btn_remove.click();
	}

	public boolean confirmationWishList(String product) {
		List<WebElement> list = driver.findElements(By.tagName("td"));
		for(WebElement i :list) {
			if(i.getText().equalsIgnoreCase(product)) {
				System.out.print(i.getText());
				return true;
			}
			System.out.println(i.getText());
		}
		return false;
	}

}
