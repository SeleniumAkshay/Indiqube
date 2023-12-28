package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;

public class TextNgRegister extends BaseTest{

	@Test
	public void register() throws EncryptedDocumentException, IOException {
		
		driver.findElement(By.linkText("Log out")).click();
		
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

	}

}
