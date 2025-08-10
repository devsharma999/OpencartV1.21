package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjets.HomePage;
import TestBase.BaseTest;
import Utilities.SepratorUtility;

public class TC009_HoverMenuNavigationTest extends BaseTest {
	
	@Test(groups = "tc009")
	public void navigationTest() {
		logger.info("*-*-*-*-*-* Starting TC002_LoginTest *-*-*-*-*-*");
		try {
			HomePage hp = new HomePage(driver);
			logger.info("Hovering To Desktop");
			hp.hoverDesktop();
			hp.clickMac();
			logger.info("Clicked on Mac");
			Assert.assertTrue(hp.confirmationDesktopHover());
		}catch(Exception e) {
			logger.error("Failed "+e.getMessage());
			Assert.fail();
		}
		logger.info("*-*-*-*-* Finishing TC009_HoverMenuNavigationTest *-*-*-*-*");
		SepratorUtility.logTestSeparator(logger);
	}
}
