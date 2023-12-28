package TestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;

public class TestNg_addToCart extends BaseTest{
	
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
		
		if (checkBox.size()==count) {
			System.out.println("All Products Has Been Added");
		}
		else {
			System.out.println(" not added ");
		}
			
		
	}

}
