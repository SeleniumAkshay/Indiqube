package GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class UtilityMethods {

	Select sel;

	public int getRandomNumber() {

		Random r=new Random();
		return r.nextInt(1000);

	}

	public void selectByValue(WebElement ele,String value) {

		sel=new Select(ele);
		sel.selectByValue(value);

	}

	public void selectByVisibleText(WebElement ele,String text) {

		sel=new Select(ele);
		sel.selectByVisibleText(text);

	}

	public boolean verifyDropdownIsmultiple(WebElement ele) {

		sel=new Select(ele);
		return sel.isMultiple();

	}

	public void deselectAll(WebElement ele) {

		sel=new Select(ele);

		if (sel.isMultiple()) {
			sel.deselectAll();
		}
		else {
			System.out.println(" We can't deselect single select dropdown");
		}

	}

	public void deselectByValue(WebElement ele,String value) {

		sel=new Select(ele);
		sel.deselectByValue(value);

	}

	public void deselectByVisibleText(WebElement ele,String text) {

		sel=new Select(ele);
		sel.deselectByVisibleText(text);

	}
	
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();		
	}
	
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();		
	}
	
	public void alertSendText(WebDriver driver,String value) {
		driver.switchTo().alert().sendKeys(value);		
	}
	
	public String alertGetText(WebDriver driver) {
		return driver.switchTo().alert().getText();		
	}
	
	public void switchWindow(WebDriver driver,String pageTitle) {
		
		Set<String> page_id = driver.getWindowHandles();
		
		for (String string : page_id) {
			driver.switchTo().window(string);
			if(driver.getTitle().contains(pageTitle)) {
				break;
			}
		}		
		
	}
	
	public String currentTime() {
		return LocalDateTime.now().toString().replace("-", "/");		
	}
	
	public void webPageScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot take=(TakesScreenshot) driver;
		File src=take.getScreenshotAs(OutputType.FILE);
		File dest=new File(FrameWorkConstants.screenShotPath+currentTime()+".png");
		FileHandler.copy(src, dest);
	}




}
