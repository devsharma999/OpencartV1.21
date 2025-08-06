package PageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement inp_firstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement inp_lastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement inp_mail;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement inp_contactNo;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement inp_pwd;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement inp_confirmPwd;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement btn_agreeTC;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_continue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmation;

	public void setFirstName(String Fname) {
		inp_firstname.sendKeys(Fname);
	}

	public void setLastName(String Lname) {
		inp_lastname.sendKeys(Lname);
	}

	public void setMail(String mail) {
		inp_mail.sendKeys(mail);
	}

	public void setContact(String contact) {
		inp_contactNo.sendKeys(contact);
	}

	public void setPassword(String pwd) {
		inp_pwd.sendKeys(pwd);
	}

	public void setConfirmPwd(String Cpwd) {
		inp_confirmPwd.sendKeys(Cpwd);
	}

	public void clickAgree() {
		btn_agreeTC.click();
	}

	public void clickContinue() {
		btn_continue.click();
	}

	public String msgConfirmation() {
		try {
			return confirmation.getText();

		} catch (Exception e) {
			return (e.getMessage());

		}
	}

}
