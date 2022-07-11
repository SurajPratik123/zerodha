package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.Excel;
import utility.ScreenShot;

public class ZerodhaHomePageTest {
	WebDriver driver;
	
	@BeforeMethod	
	public void loginToZerodha() throws EncryptedDocumentException, IOException {
		driver =Browser.chromeBrowser();
		ZerodhaLoginPage zerodhaLoginPage =new ZerodhaLoginPage(driver);
//		String userId =Excel.getData("Sheet1", 1, 0);
//		String pass =Excel.getData("Sheet1", 1, 1);
//		String pin =Excel.getData("Sheet1", 1, 2);
		
		zerodhaLoginPage.enterUserId("LAJ486");
		zerodhaLoginPage.enterPassword("Suraj@123");
		zerodhaLoginPage.clickOnLogin();
		zerodhaLoginPage.enterPin("221998", driver);
		zerodhaLoginPage.clickOnContinue();
	}
	@AfterMethod
	public void screenshot() throws IOException {
		ScreenShot.takeScreenShot(driver, "HomePage");
	}
	@Test
	public void ordersModelTest() {
		ZerodhaHomePage zerodhaHomePage =new ZerodhaHomePage(driver);
		zerodhaHomePage.clickOnOrders();
		zerodhaHomePage.expectedTitle(driver, "Orders / Kite");
		zerodhaHomePage.clickOnHoldings();
		zerodhaHomePage.expectedTitle(driver, "Holdings / Kite");
		zerodhaHomePage.clickOnLogoToRefresh();
	}
	

}
