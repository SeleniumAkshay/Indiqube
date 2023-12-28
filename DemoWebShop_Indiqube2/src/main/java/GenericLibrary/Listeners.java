package GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener ,ISuiteListener{

	@Override
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ts=(TakesScreenshot)BaseTest.listenerDriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(FrameWorkConstants.screenShotPath+result.getName()+".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
	