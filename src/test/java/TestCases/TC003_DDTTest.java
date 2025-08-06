package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjets.HomePage;
import PageObjets.LoginPage;
import PageObjets.MyAccountPage;
import TestBase.BaseTest;
import Utilities.DataProviders;
import Utilities.SepratorUtility;

public class TC003_DDTTest extends BaseTest {

	@Test(dataProvider = "logindata", dataProviderClass = DataProviders.class , groups = {"datadriven","Master"}) 
	public void verify_login(String usrname, String pwd, String exp) {
		logger.info("*-*-*-*-*-* Starting TC003_DDTTesting *-*-*-*-*-*");
		try {
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickmyacc();
		logger.info("Clicked On MyAccount");
		hp.clicklogin();
		logger.info("Clicked On Login");

		// LoginPage
		LoginPage lp = new LoginPage(driver);
		logger.info("Filling Out "+exp+ "Login Details");
		lp.setEmail(usrname);
		lp.setPassword(pwd);
		lp.clickLogin();
		logger.info("Clicked On Login_Button");
		// MyAccount
		MyAccountPage map = new MyAccountPage(driver);
		boolean targetPage = map.confirmation();

		if (exp.equalsIgnoreCase("valid")) {
			if (targetPage) {
				Assert.assertTrue(true);
				map.click_logout();
			} else {
				Assert.assertTrue(false);
			}
		}else if(exp.equalsIgnoreCase("invalid")) {
			if(targetPage) {
				Assert.assertFalse(true);
				map.click_logout();
			}else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("*-*-*-*-*-* Finished TC003_DDTTesting *-*-*-*-*-*");
		SepratorUtility.logTestSeparator(logger);
	}
}
