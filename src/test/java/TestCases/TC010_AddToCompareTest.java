package TestCases;

import TestBase.BaseTest;

import org.testng.Assert;
import org.testng.annotations.*;

import PageObjets.HomePage;
import PageObjets.ResultPage;

public class TC010_AddToCompareTest extends BaseTest{

	
		// TODO Auto-generated method stub
		@Test(groups = "tc010")
		public void addtocompareTest() {
			logger.info("*-*-*-*-* Starting TC010_AddToCompareTest *-*-*-*-*");
			try {
				
				
			logger.info("clicked on Search SettingProduct");
			HomePage hp = new HomePage(driver);
			hp.setSearch(p.getProperty("compareA"));
			
			logger.info("Clicking Add to comparison");
			ResultPage rp = new ResultPage(driver);
			rp.clickAddtocomparison();
			logger.info("Searching for another Product To compare");
			hp.clickSearch();
			hp.clearSearchbar();
			hp.setSearch(p.getProperty("compareB"));
			rp.clickAddtocomparison();
			rp.clickProductComparison();
			Assert.assertTrue(rp.confirmationComparisonpage());
			logger.info("Comparison Successfull");
			}catch(Exception e) {
				logger.error("Failed"+e.getMessage());
				Assert.fail();
			}
			
		}
		
	

}
