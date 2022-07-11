package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ZerodhaHomePage {
	@FindBy (xpath = "//span[text()='Orders']") private WebElement orders;
	@FindBy (xpath = "//span[text()='Holdings']") private WebElement holdings;
	@FindBy (xpath = "//span[text()='Positions']") private WebElement positions;
	@FindBy (xpath = "//span[text()='Funds']") private WebElement funds;
	@FindBy (xpath = "//span[text()='Apps']") private WebElement apps;
	@FindBy (xpath = "//span[@class='user-id']") private WebElement userId;
	@FindBy (xpath = "//span[text()='Dashboard']") private WebElement dashboard;
	@FindBy (xpath = "//a[@class=\"logo\"]") private WebElement logo;
	
	public ZerodhaHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnOrders() {
		orders.click();
	}
	public void clickOnHoldings() {
		holdings.click();
	}
	public void clickOnPositions() {
		positions.click();
	}
	public void clickOnFunds() {
		funds.click();
	}
	public void clickOnApps() {
		apps.click();
	}
	public void clickOnUserId() {
		userId.click();
	}
	public void clickOnDashboard() {
		dashboard.click();
	}
	public void clickOnLogoToRefresh() {
		logo.click();
	}
	public void expectedTitle(WebDriver driver, String expectedTitle) {
//		WebDriverWait wait =new WebDriverWait(driver, Duration.ofMillis(2000));
//		wait.until(ExpectedConditions.titleContains(title));
		String actualTitle =driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
