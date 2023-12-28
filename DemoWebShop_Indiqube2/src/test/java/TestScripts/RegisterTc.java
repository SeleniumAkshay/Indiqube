package TestScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericLibrary.DataUtility;
import GenericLibrary.UtilityMethods;

public class RegisterTc {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		DataUtility dutil=new DataUtility();
		UtilityMethods um=new UtilityMethods();
		
		//Step1 Launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Step2 navigate to webpage
		driver.get(dutil.getPropertyData("url"));
		
		//Step3 validate title
		if (driver.getTitle().contains(dutil.getExcelData("PageTitles", 1, 0))) {
			System.out.println("Title matched Navigated Successfully to welcome page");
		}
		else {
			System.out.println("Title Mismatched");
		}		
		
		//Step4 clicking on register button
		driver.findElement(By.linkText("Register")).click();
		
		//step5 validating rigister title
		if (driver.getTitle().contains(dutil.getExcelData("PageTitles", 1, 1))) {
			System.out.println("Title matched Navigated Successfully to register page");
		}
		else {
			System.out.println("Title Mismatched");
		}
		
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys(dutil.getExcelData("RegisterTC", 1, 0));
		driver.findElement(By.id("LastName")).sendKeys(dutil.getExcelData("RegisterTC", 1, 1));
		driver.findElement(By.id("Email")).sendKeys(um.getRandomNumber()+dutil.getExcelData("RegisterTC", 1, 2));
		driver.findElement(By.id("Password")).sendKeys(dutil.getExcelData("RegisterTC", 1, 3));
		driver.findElement(By.id("ConfirmPassword")).sendKeys(dutil.getExcelData("RegisterTC", 1, 4));
		driver.findElement(By.id("register-button")).click();
		
		String value = driver.findElement(By.className("result")).getText();
		
		//step6 validating register status
		if (value.contains("Your registration completed")) {
			System.out.println(" Register Successfully ");
		}
		else {
			System.out.println(" Register Unsuccess ");
		}
		
		//step7 clicking logout
		driver.findElement(By.linkText("Log out")).click();
		
		//step 8 close browser
		Thread.sleep(3000);
		driver.quit();
		
	}

}
