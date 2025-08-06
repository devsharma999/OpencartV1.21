package PageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txt_pwd;
	@FindBy(xpath = "//input[@value='Login']") WebElement btn_login;
	
	
	public void setEmail(String mail) {
		txt_email.sendKeys(mail);
	}
	public void setPassword(String pwd) {
		txt_pwd.sendKeys(pwd);
	}
	public void clickLogin() {
		btn_login.click();
	}

	
	

}





