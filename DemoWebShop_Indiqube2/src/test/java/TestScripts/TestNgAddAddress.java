package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;

public class TestNgAddAddress extends BaseTest {
	
	@Test
	public void addAddress() throws EncryptedDocumentException, IOException {
		
		driver.findElement(By.linkText("My account")).click();
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//input[@value='Add new']")).click();
		driver.findElement(By.id("Address_FirstName")).sendKeys(dutil.getExcelData("AddAddress", 1, 0));
		driver.findElement(By.id("Address_LastName")).sendKeys(dutil.getExcelData("AddAddress", 1, 1));
		driver.findElement(By.id("Address_Email")).sendKeys(dutil.getExcelData("AddAddress", 1, 2));
		WebElement countrydd = driver.findElement(By.id("Address_CountryId"));
		um.selectByVisibleText(countrydd, dutil.getExcelData("AddAddress", 1, 3));
		driver.findElement(By.id("Address_City")).sendKeys(dutil.getExcelData("AddAddress", 1, 4));
		driver.findElement(By.id("Address_Address1")).sendKeys(dutil.getExcelData("AddAddress", 1, 5));
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(dutil.getExcelData("AddAddress", 1, 6));
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys(dutil.getExcelData("AddAddress", 1, 7));
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
	}

}
