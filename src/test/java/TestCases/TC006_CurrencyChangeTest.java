package TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import PageObjets.HomePage;
import TestBase.BaseTest;

public class TC006_CurrencyChangeTest extends BaseTest {
	@Test(groups = "tc006")
	public void currencyTest() {
		logger.info("*-*-*-*-* Starting TC006_CurrencyChangeTest *-*-*-*-*");
		SoftAssert softAssert = new SoftAssert();

		try {
			HomePage hp = new HomePage(driver);

			logger.info("Checking Euro Currency");
			hp.clickCurrency();
			hp.currencyToEuro();
			softAssert.assertTrue(hp.confirmationCurrency("euro"), "Euro currency check failed");

			logger.info("Checking Pound Currency");
			hp.clickCurrency();
			hp.currencyToPound();
			softAssert.assertTrue(hp.confirmationCurrency("pound"), "Pound currency check failed");

			logger.info("Checking USD Currency");
			hp.clickCurrency();
			hp.currencyToUSD();
			softAssert.assertTrue(hp.confirmationCurrency("usd"), "USD currency check failed");

		} catch (Exception e) {
			logger.error("Broken XPath or Missing Element: " + e.getMessage());
			softAssert.fail("Exception occurred during test: " + e.getMessage());
		}

		// This will report all failures at once
		softAssert.assertAll();
	}
}
