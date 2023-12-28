package GenericLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
	JavascriptExecutor java_script;
	public void scrollBy(WebDriver driver) {
		java_script=(JavascriptExecutor) driver;
		java_script.executeScript("window.scrollBy(0,500);");
	}
	
	public void scrollIntoView(WebDriver driver,WebElement ele) {
		java_script=(JavascriptExecutor) driver;
		java_script.executeScript("arguments[0].scrollIntoView(true);",ele);		
	}
	
	public void passValue(WebDriver driver,WebElement ele,String value) {
		java_script=(JavascriptExecutor) driver;
		java_script.executeScript("arguments[0].value='"+value+"';",ele);			
	}

}
