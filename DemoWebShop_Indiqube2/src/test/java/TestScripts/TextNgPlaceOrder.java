package TestScripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GenericLibrary.BaseTest;

public class TextNgPlaceOrder extends BaseTest{
	
	@Test
	public void placeOrder() {
		
		driver.findElement(By.partialLinkText("COMP")).click();
		driver.findElement(By.partialLinkText("Desktops")).click();
		driver.findElement(By.partialLinkText("Simple Computer")).click();
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		driver.findElement(By.id("add-to-cart-button-75")).click();
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[2]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[3]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[4]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[5]")).click();
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		String text = driver.findElement(By.xpath("//div[@class='title']/strong")).getText();
		
		if (text.contains("Your order has been successfully processed!")) {
			System.out.println("Order Placed");
			String orderId = driver.findElement(By.xpath("//ul[@class='details']/li[1]")).getText();
			System.out.println(orderId);
		}
		else {
			System.out.println("Order Not Placed");
		}		
		
//		driver.findElement(By.xpath("//ul[@class='details']/li[2]/a")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
	}

}
