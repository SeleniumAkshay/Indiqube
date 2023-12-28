package PomRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalDownloadsPage {
	
	public List<WebElement> getAddToCart() {
		return addToCart;
	}

	public WebElement getShoppingCartBtn() {
		return shoppingCartBtn;
	}

	public DigitalDownloadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='Add to cart']")
	private List<WebElement> addToCart;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCartBtn;
	
	

}
