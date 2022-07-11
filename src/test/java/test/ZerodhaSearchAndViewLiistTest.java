package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaLoginPage;
import pom.ZerodhaSearchAndViewList;
import utility.BaseClass;
import utility.ScreenShot;
@Listeners(utility.Listeners.class)
public class ZerodhaSearchAndViewLiistTest extends BaseClass {

	@BeforeMethod
	public void login() {
		driver =Browser.chromeBrowser();
		ZerodhaLoginPage zerodhaLoginPage =new ZerodhaLoginPage(driver);
		zerodhaLoginPage.enterUserId("LAJ486");
		zerodhaLoginPage.enterPassword("Suraj@123");
		zerodhaLoginPage.clickOnLogin();
		zerodhaLoginPage.enterPin("221998", driver);
		zerodhaLoginPage.clickOnContinue();
	}
//	@AfterMethod
//	public void takeScreenShot() throws IOException, InterruptedException {
//		Thread.sleep(2000);
//		ScreenShot.takeScreenShot(driver, "ZerodhaTest");
//	}
	
	@Test(enabled = false)
	public void searchAndViewListTest() throws EncryptedDocumentException, IOException, InterruptedException {		
		ZerodhaSearchAndViewList zerodhaSearchAndViewList =new ZerodhaSearchAndViewList(driver);
		
		zerodhaSearchAndViewList.clickOnSearch(driver);
		zerodhaSearchAndViewList.enterStockName("TATAPOWER");
		zerodhaSearchAndViewList.selectStock(driver);
		zerodhaSearchAndViewList.clickOnAddStock(driver);

	}
	
	@Test(enabled = false)
	public void searchStockByThreeWords() {
		ZerodhaSearchAndViewList zerodhaSearchAndViewList =new ZerodhaSearchAndViewList(driver);
		zerodhaSearchAndViewList.clickOnSearch(driver);
		zerodhaSearchAndViewList.enterStockName("ta");
		zerodhaSearchAndViewList.searchGetListOfStock("TARC", driver);
		zerodhaSearchAndViewList.clickOnAddStock(driver);
	}
	
	@Test(enabled = false)
	public void clickOnListAndSearch() {
		ZerodhaSearchAndViewList zerodhaSearchAndViewList =new ZerodhaSearchAndViewList(driver);
		zerodhaSearchAndViewList.goToPage(2, driver);
		zerodhaSearchAndViewList.stockPresentOnPage("TATAMOTORS", driver);
		zerodhaSearchAndViewList.clickOnMarketDepth();
		zerodhaSearchAndViewList.clickOnShowMarketDepth();
	}
	
	@Test(enabled = false)
	public void actionOnDefaultStock() {
		ZerodhaSearchAndViewList zerodhaSearchAndViewList =new ZerodhaSearchAndViewList(driver);
//		zerodhaSearchAndViewList.goToPage(2, driver);
		zerodhaSearchAndViewList.stockPresentOnPage("PAYTM", driver);
		zerodhaSearchAndViewList.clickOnMore();
	}
	
	@Test
	public void stockPriceOnPage() {
		ZerodhaSearchAndViewList zerodhaSearchAndViewList =new ZerodhaSearchAndViewList(driver);
		zerodhaSearchAndViewList.priceOfStockOnPage();
	}

}
