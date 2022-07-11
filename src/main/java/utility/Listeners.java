package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+ " Test has started");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+ " Test passed");
	}
	
	public void onTestFailure(ITestResult result) {
		
		try {
			ScreenShot.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
