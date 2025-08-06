package TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjets.HomePage;
import PageObjets.ResultPage;
import TestBase.BaseTest;
import Utilities.SepratorUtility;
public class TC005_AddToCartTest extends BaseTest {
	@Test(groups = "tc005")
	public void addtoCartVerfication() {
		logger.info("*-*-*-*-* Starting TC005_AddToCartTest *-*-*-*-*");
		try {
			logger.info("Searching for product as mentioned by Devlopers");
			HomePage hp = new HomePage(driver);
			hp.setSearch("imac");
			logger.info("Adding To Cart");
			ResultPage rp = new ResultPage(driver);
			rp.clickAddtocart();
			Assert.assertTrue(rp.confirmationAddtoCart("iMac"));
		}catch(Exception e) {
			logger.error("Failed to Confirm = "+e.getMessage());
			Assert.fail();
		}
		logger.info("*-*-*-*-* Finishing TC005_AddToCartTest *-*-*-*-*");
		SepratorUtility.logTestSeparator(logger);
	}
}
