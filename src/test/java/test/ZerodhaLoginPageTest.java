package test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pojo.Browser;
import pom.ZerodhaLoginPage;
import utility.Excel;

public class ZerodhaLoginPageTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver = Browser.chromeBrowser();
	}
	
	@Test
	public void loginTest() throws EncryptedDocumentException, IOException, InterruptedException {
		ZerodhaLoginPage zerodhaLoginPage = new ZerodhaLoginPage(driver);
//		String userId =Excel.getData("Sheet1", 1, 0);
//		String pass =Excel.getData("Sheet1", 1, 1);
//		String pin =Excel.getData("Sheet1", 1, 2);
		
		boolean status =zerodhaLoginPage.isImageDisplayed();
		System.out.println(status);
//		Assert.assertFalse(status);//Hard Assert
//		SoftAssert softAssert =new SoftAssert();//Soft Assert
//		softAssert.assertFalse(status);
		
		zerodhaLoginPage.enterUserId("LAJ486");
		zerodhaLoginPage.enterPassword("Suraj@123");
		zerodhaLoginPage.clickOnLogin();
		
		zerodhaLoginPage.enterPin("221998", driver);
		zerodhaLoginPage.clickOnContinue();
//		softAssert.assertAll();
		
//		WebDriverWait wait =new WebDriverWait(driver, Duration.ofMillis(2000));
//		wait.until(ExpectedConditions.titleContains("Dashboard / Kite"));
//		String currentTitle =driver.getTitle();
//		String expectedTitle ="Dashboard / Kite";
//		Assert.assertEquals(currentTitle, expectedTitle);
		
		zerodhaLoginPage.expectedPageTitle(driver, "Dashboard / Kite", "Dashboard / Kite");
	}
	

}
