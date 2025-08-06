package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjets.HomePage;
import TestBase.BaseTest;
import Utilities.SepratorUtility;

public class TC004_SearchingTest extends BaseTest {
	@Test(groups = "tc004")
	public void search() {
		logger.info("*-*-*-*-* Starting TC004_SearchingTest *-*-*-*-*");
		try {
			logger.info("Searching for product as mentioned by Devlopers");
			HomePage hp = new HomePage(driver);
			String productA = p.getProperty("product");
			hp.setSearch(productA);
			Assert.assertTrue(hp.confirmationSearch(productA));
			logger.info("Searched"+productA);
		} catch (Exception e) {
			logger.error("Test Failed", e);
			Assert.fail();
		}
		logger.info("*-*-*-*-* Finishing TC004_SearchingTest *-*-*-*-*");
		SepratorUtility.logTestSeparator(logger);
	}
}
