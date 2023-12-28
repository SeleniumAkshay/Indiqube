package TestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;

@Listeners(GenericLibrary.Listeners.class)
public class TextNg_addToCartAssert extends BaseTest{
	
	@Test
	public void addToCart() throws InterruptedException {
		driver.findElement(By.partialLinkText("Digital downloads")).click();
		List<WebElement> add = driver.findElements(By.xpath("//input[@value='Add to cart']"));
		
		int count = add.size();
		for (int i = 0; i <count; i++) {
			Thread.sleep(500);
			add.get(i).click();
		}
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		List<WebElement> checkBox = driver.findElements(By.xpath("//table[@class='cart']/tbody/tr/td/input[@type='checkbox']"));
		
		Assert.assertEquals(checkBox.size(),count,"NotAdded");
		Reporter.log("All Products Has Been Added",true);
		
//		if (checkBox.size()==count) {
//			System.out.println("All Products Has Been Added");
//		}
//		else {
//			System.out.println(" not added ");
//		}
//			
		
	}

}
