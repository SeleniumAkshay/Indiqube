package TestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;
import GenericLibrary.CommonUtility;

public class TextNgRemoveFromCart extends BaseTest{
	
	@Test
	public void removeFromCart() throws InterruptedException {
		
		CommonUtility cu=new CommonUtility();
		cu.addTocart(driver);
		
		List<WebElement> checkBox = driver.findElements(By.xpath("//table[@class='cart']/tbody/tr/td/input[@type='checkbox']"));
		
		int count = checkBox.size();
		
		for (int i = 0; i <count; i++) {
			checkBox.get(i).click();
		}
		driver.findElement(By.name("updatecart")).click();
		
		String text = driver.findElement(By.className("order-summary-content")).getText();
		
		
		if (text.contains("Your Shopping Cart is empty")) {
			System.out.println("All products Has Been removed");
		}
		else {
			System.out.println("not removed");
		}
		
	}
			

}
