package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ZerodhaSignUpPage;
import utility.ScreenShot;

public class ZerodhaSignUpPageTest {
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver =Browser.chromeBrowser();
		}
	
	@AfterMethod
	public void takeScreenShot() throws IOException {
		ScreenShot.takeScreenShot(driver, "Zerodha");
	}
	
	@Test
	public void signUpTest() throws InterruptedException {
		ZerodhaSignUpPage zerodhaSignUpPage = new ZerodhaSignUpPage(driver);
		
		zerodhaSignUpPage.clickOnSignUp();
		
		zerodhaSignUpPage.openSignUpPage(1, driver);
		
		zerodhaSignUpPage.enterMobileNumber("7499326115");
		
	}

}
