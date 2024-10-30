package testNGFramework.pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CheckOutPage{
	
	WebDriver driver;
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> productTitle;
	
	@FindBy(css="[class*='subtotal'] button")
    WebElement checkoutEle;
	

	
		
	public CartPage(WebDriver driver) {
		
	    super(driver);
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		
	}

	

	public Boolean verifyProductName(String productName)
	{
		
		
		
		Boolean match=productTitle.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		
		return match;
	}
	
	public CheckOutPage goToCheckOut()
	{
		checkoutEle.click();
		
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		
		return checkOutPage;
		
	}
	

}
