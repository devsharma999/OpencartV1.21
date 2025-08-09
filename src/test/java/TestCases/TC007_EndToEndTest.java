package TestCases;

import TestBase.BaseTest;
import Utilities.SepratorUtility;

import org.testng.Assert;
import org.testng.annotations.*;

import PageObjets.AccountRegistrationPage;
import PageObjets.CheckOutPage;
import PageObjets.HomePage;
import PageObjets.LoginPage;
import PageObjets.MyAccountPage;
import PageObjets.ResultPage;

public class TC007_EndToEndTest extends BaseTest {

	@Test(groups = "tc007")
	public void endToEndTesting() {
		logger.info("*-*-*-*-* Starting TC007_EndToEndTest *-*-*-*-*");
		logger.info("Registering Customer");
		String mail = RandomString() + "@gmail.com";
		String pwd = RandomAlphanumric();
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
			logger.info("Registering Customer with this mail--->" + mail);
			logger.info("PassWord is--->" + pwd);
			arp.setMail(mail);
			arp.setContact(RandomInteger());

			arp.setPassword(pwd);
			arp.setConfirmPwd(pwd);
			arp.clickAgree();
			arp.clickContinue();
			logger.info("Validating Expected Message");
			String message = arp.msgConfirmation();
			System.out.println("Confirmation Message: " + message);
			logger.info("Confirmation Message: " + message);
			Assert.assertEquals(arp.msgConfirmation(), "Your Account Has Been Created!", "RegistrationFailed");
		} catch (Exception e) {
			logger.error("Test Failed", e);
			Assert.fail(e.getMessage());
		}
		logger.info("LoggingOut Customer");
		MyAccountPage map1 = new MyAccountPage(driver);
		map1.click_logout();
		Assert.assertTrue(map1.confirmationlogout());
		try {

			// HomePage
			logger.info("Logging in with same credential that has been just used while Regestring");
			HomePage hp = new HomePage(driver);
			hp.clickmyacc();
			logger.info("Clicked On MyAccount");
			hp.clicklogin();
			logger.info("Clicked On Login");

			// LoginPage
			LoginPage lp = new LoginPage(driver);
			logger.info("Filling Login Details");
			lp.setEmail(mail);
			lp.setPassword(pwd);
			lp.clickLogin();
			logger.info("Clicked On Login_Button");

			// MyAccountPage
			MyAccountPage map = new MyAccountPage(driver);
			Assert.assertTrue(map.confirmation());
			logger.info("Login Successfull");
		} catch (Exception e) {
			logger.error("Test Failed", e);
			Assert.fail();
		}
		logger.info("Now Searching For Product Which is Available");
		try {
			logger.info("Searching for product as mentioned by Devlopers");
			HomePage hp = new HomePage(driver);
			String productA = p.getProperty("product");
			hp.setSearch(productA);
			logger.info("Searched" + productA);
			Assert.assertTrue(hp.confirmationSearch(productA));
			logger.info("Adding To Cart");

			ResultPage rp = new ResultPage(driver);
			rp.clickAddtocart();
			Assert.assertTrue(rp.confirmationAddtoCart(productA));

		} catch (Exception e) {
			logger.error("Failed to Confirm = " + e.getMessage());
			Assert.fail();
		}
		logger.info("Now Checking Out The Product selected");
		try {
			ResultPage rp1 = new ResultPage(driver);
			Thread.sleep(2000);
			rp1.clickCheckout();
			CheckOutPage cop = new CheckOutPage(driver);
			cop.clickCheckout();
			Assert.assertTrue(cop.confirmationCheckout());
		}catch(Exception e) {
			logger.error("Failed to Confirm = " + e.getMessage());
			Assert.fail();
		}
		logger.info("*-*-*-*-* Finishing TC007_EndToEndTest *-*-*-*-*");
		SepratorUtility.logTestSeparator(logger);
	}

}
