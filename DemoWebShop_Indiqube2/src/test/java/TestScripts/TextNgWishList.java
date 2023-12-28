package TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;

public class TextNgWishList extends BaseTest{
	
	@Test
	public void wishList() {
		driver.findElement(By.partialLinkText("BOO")).click();
		driver.findElement(By.linkText("Fiction EX")).click();
		driver.findElement(By.id("add-to-wishlist-button-78")).click();
		driver.findElement(By.xpath("//span[text()='Wishlist']")).click();
		
		String value = driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[4]/a")).getText();
		
		if (value.contains("Fiction EX")) {
			driver.findElement(By.xpath("//table[@class='cart']/tbody/tr/td[1]/input")).click();
			driver.findElement(By.name("updatecart")).click();
		}
		else {
			System.out.println("Product is not available");
		}
		
	}
	
	

}
