package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyStock {
	
	@FindBy (xpath = "//label[text()='Regular']") private WebElement regular;
	@FindBy (xpath = "//label[@for='radio-149']") private WebElement longterm;
	@FindBy (xpath = "//label[@for='radio-155']") private WebElement limitOrder;
	@FindBy (xpath = "//input[@rules='[object Object],[object Object],[object Object]']") private WebElement quantity;
	@FindBy (xpath = "(//input[@rules='[object Object]'])[1]") private WebElement price;
	@FindBy (xpath = "//button[@class='submit']") private WebElement buy;
	@FindBy (xpath = "//button[@class='button-outline cancel']") private WebElement cancel;
	@FindBy (xpath = "//input[@rules='[object Object],[object Object]']") private WebElement triggerPrice;
	@FindBy (xpath = "//label[@for='radio-140']") private WebElement bseShare;
	@FindBy (xpath = "//label[@for='radio-141']") private WebElement nseShare;
	@FindBy (xpath = "//span[@class='reload-margin icon icon-reload']") private WebElement refreshMargin;
	@FindBy (xpath = "//span[@class='margin-value']") private WebElement marginPrice;
	
	public BuyStock(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void regularOrderSelected() {
		regular.isSelected();
	}
	

}
