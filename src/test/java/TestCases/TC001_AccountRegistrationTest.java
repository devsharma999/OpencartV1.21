package TestCases;


import org.testng.Assert;
import org.testng.annotations.*;

import PageObjets.AccountRegistrationPage;
import PageObjets.HomePage;
import TestBase.BaseTest;
import Utilities.SepratorUtility;

public class TC001_AccountRegistrationTest extends BaseTest {
	

	@Test(groups = {"regression","Master"})
	public void register() {
		logger.info("*-*-*-*-* Starting TC001_AccountRegistrationTest *-*-*-*-*");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickmyacc();
		logger.info("Clicked On MyAccount");
		hp.clickregister();
		logger.info("Clicked On Register");
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details");
		arp.setFirstName(RandomString().toUpperCase());
		arp.setLastName(RandomString().toUpperCase());
		arp.setMail(RandomString() + "@gmail.com");
		arp.setContact(RandomInteger());
		String pwd = RandomAlphanumric();
		arp.setPassword(pwd);
		arp.setConfirmPwd(pwd);
		arp.clickAgree();
		arp.clickContinue();
		logger.info("Validating Expected Message");
		String message = arp.msgConfirmation();
		System.out.println("Confirmation Message: " + message);
		logger.info("Confirmation Message: " + message);
		Assert.assertEquals(arp.msgConfirmation(), "Your Account Has Been Created!", "RegistrationFailed");
		}catch(Exception e){
			logger.error("Test Failed",e);
			Assert.fail(e.getMessage());
		}
		logger.info("*-*-*-*-* Finished TC001_AccountRegistrationTest *-*-*-*-*");
		SepratorUtility.logTestSeparator(logger);
	}

}
