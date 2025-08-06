package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjets.HomePage;
import PageObjets.LoginPage;
import PageObjets.MyAccountPage;
import TestBase.BaseTest;
import Utilities.SepratorUtility;

public class TC002_LoginTest extends BaseTest {

	@Test(groups = {"sanity","Master"})
	public void login() {
		logger.info("*-*-*-*-*-* Starting TC002_LoginTest *-*-*-*-*-*");
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickmyacc();
		logger.info("Clicked On MyAccount");
		hp.clicklogin();
		logger.info("Clicked On Login");
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		logger.info("Filling Out Valid Login Details");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Clicked On Login_Button");
		
		//MyAccountPage
		MyAccountPage map = new MyAccountPage(driver);
		Assert.assertTrue(map.confirmation());
		}catch (Exception e) {
			logger.error("Test Failed",e);
			Assert.fail();
		}
		logger.info("*-*-*-*-*-* Finished TC002_LoginTest *-*-*-*-*-*");
		SepratorUtility.logTestSeparator(logger);
	}
}
