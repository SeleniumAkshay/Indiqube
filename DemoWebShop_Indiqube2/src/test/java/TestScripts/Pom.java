package TestScripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PomRepo.DigitalDownloadsPage;
import PomRepo.HomePage;
import PomRepo.LoginPage;
import PomRepo.WelcomePage;

public class Pom {
	
	@Test
	public void addToCart() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		
		WelcomePage wp=new WelcomePage(driver);
		wp.getLoginButton().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getEmailTb().sendKeys("tyssqsp@gmail.com");
		lp.getPassTb().sendKeys("Qsp@1234");
		lp.getLoginBtn().click();
		
		HomePage hp=new HomePage(driver);
		hp.getDigitaldownloadsLink().click();
		
		DigitalDownloadsPage ddp=new DigitalDownloadsPage(driver);
		List<WebElement> ele = ddp.getAddToCart();
		int count = ele.size();
		
		for (int i = 0; i < count; i++) {
			Thread.sleep(1000);
			ele.get(i).click();
		}
		
		ddp.getShoppingCartBtn().click();		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
