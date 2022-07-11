package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	public static void takeScreenShot(WebDriver driver, String name) throws IOException {
		String d =ScreenShot.date();
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destination = new File("C:\\ScreenShot\\"+name+d+".jpg");
	FileHandler.copy(source, destination);
	}
	
	public static String date() {
		DateTimeFormatter dtf =DateTimeFormatter.ofPattern("YYYY-MM-dd-HH-mm-ss");
		LocalDateTime currentTime =LocalDateTime.now();
			String d =dtf.format(currentTime);
			return d;
	}
}
