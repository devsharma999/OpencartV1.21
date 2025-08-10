package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjets.HomePage;
import PageObjets.LoginPage;
import PageObjets.MyAccountPage;
import PageObjets.ResultPage;
import PageObjets.WishListPage;
import TestBase.BaseTest;
import Utilities.SepratorUtility;

public class TC008_WishListTest extends BaseTest {
	
	@Test(groups = "tc008")
	public void wishListTesting() throws InterruptedException {
	logger.info("*-*-*-*-*-* Starting TC002_LoginTest *-*-*-*-*-*");
	logger.info("Before Adding Anything to wishList we Have to loggin to the website");
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
	String product = p.getProperty("product");
	logger.info("Searching For"+product);
	HomePage hp = new HomePage(driver);
	hp.setSearch(product);
	ResultPage rp = new ResultPage(driver);
	rp.clickHeart();
	Thread.sleep(2000);
	rp.clickWishList();
	WishListPage wlp = new WishListPage(driver);
	Assert.assertTrue(wlp.confirmationWishList(product),"ProductHasNot Been Added To WishList");
	logger.info("*-*-*-*-* Finishing TC008_WishListTest *-*-*-*-*");
	SepratorUtility.logTestSeparator(logger);
	
}
}
