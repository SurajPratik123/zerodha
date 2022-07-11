package pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver chromeBrowser() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();//help us download chrome exe automatically
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver =new ChromeDriver(option);
		driver.get("https://kite.zerodha.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);//implicit wait
		
		return driver;
	}

}
