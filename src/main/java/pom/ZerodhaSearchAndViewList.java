package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaSearchAndViewList {
	
	
	@FindBy (xpath = "//input[@icon='search']") private WebElement search;
	@FindBy (xpath = "//body//ul//li//span//span[@Class='tradingsymbol']") private List<WebElement> searchStock;
	@FindBy (xpath = "//button[@class='button-green']") private WebElement add;
	@FindBy (xpath = "//button[@class='button-blue buy']") private WebElement buy;
	@FindBy (xpath = "//button[@class='button-orange sell']") private WebElement sell;
	@FindBy (xpath = "//span[@class='icon icon-align-center']") private WebElement marketDepth;
	@FindBy (xpath = "//a[@class='text-center']") private WebElement showDepth;
	@FindBy (xpath = "(//span[@class='icon icon-trending-up'])[1]") private WebElement chart;
	@FindBy (xpath = "//span[@class='icon icon-trash']") private WebElement delete;
	@FindBy (xpath = "//span[@class='icon icon-ellipsis']") private WebElement more;
	@FindBy (xpath = "//li[@class='search-result-item selected']") private WebElement select;
	@FindBy (xpath = "//body[@class='app-wrapper']") private WebElement empty;
	@FindBy (xpath = "//body//ul//li[@data-balloon-pos='up']") private List<WebElement> page;
	@FindBy (xpath = "//body//div//div//span[@class='nice-name']") private List<WebElement> stockOnPage;
	@FindBy (xpath = "//span[@class='last-price']") private List<WebElement> stockPriceOnPage;
	
	public ZerodhaSearchAndViewList(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSearch(WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofMillis(2000));
		wait.until(ExpectedConditions.visibilityOf(search));
		search.click();
	}
	public void enterStockName(String stock) {
		search.sendKeys(stock);
	}
	public void searchGetListOfStock(Object stockName, WebDriver driver) {
		int sizes =searchStock.size();
		System.out.println(sizes);
		int a=0;
		for(int i=0; i<sizes; i++) {
			WebElement share =searchStock.get(i);
			String shareName =share.getText();
			System.out.println(shareName);
			if(shareName.equals(stockName)) {
				a=i;
			}			
		}
		WebElement shre =searchStock.get(a);
		System.out.println(shre.getText());
		Actions action =new Actions(driver);
		action.moveToElement(shre);
		action.perform();
	}
	public void selectStock(WebDriver driver) {
		Actions action =new Actions(driver);
		action.moveToElement(select);
		action.perform();
	}
	public void clickOnAddStock(WebDriver driver) {
		add.click();
		Actions action =new Actions(driver);
		action.click(empty);
		action.perform();
	}
	public void clickOnBuyStock() {
		buy.click();
	}
	public void clickOnSellStock() {
		sell.click();
	}
	public void clickOnMarketDepth() {
		marketDepth.click();
	}
	public void clickOnShowMarketDepth() {
		showDepth.click();
	}
	public void clickOnChart() {
		chart.click();
	}
	public void clickOnDelete() {
		delete.click();
	}
	public void clickOnMore() {
		more.click();
	}
	
	public void goToPage(int l, WebDriver driver) {
		int f=0;
		int listSize =page.size();
		for (int x=2; x<=listSize; x++) {
//			WebElement getAList =driver.findElement(By.xpath("//body//ul//li[@data-balloon='"+x+"']"));
//			String value =getAList.getText();
//			int p =Integer.parseInt(value);
			if(l==x) {
				f=x;
			}
		}
		WebElement getList =driver.findElement(By.xpath("//body//ul//li[@data-balloon="+f+"]"));
		getList.click();
	}
	
	public void stockPresentOnPage(String expectedStock, WebDriver driver) {		
		for(int i=0;i<stockOnPage.size();i++) {
			WebElement stock =stockOnPage.get(i);
			String stockName =stock.getText();
			if(stockName.equals(expectedStock)) {
				Actions action =new Actions(driver);
				action.moveToElement(stock);
				action.perform();
			}
		}		
	}
	
	public void priceOfStockOnPage() {
		for(int i=0;i<stockOnPage.size();i++) {
			 
			for(int j=0;j<stockPriceOnPage.size();j++) {
				
				if(i==j) {
					System.out.println(stockOnPage.get(i).getText()+" "+stockPriceOnPage.get(j).getText());
				}
			}
		}
	}
}
