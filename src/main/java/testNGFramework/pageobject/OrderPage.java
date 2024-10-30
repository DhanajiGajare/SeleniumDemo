package testNGFramework.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//*[@class=\"ng-star-inserted\"] /td[2]")
	List<WebElement> productTitle;
	
	public OrderPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
 @FindBy(css="*[routerlink*=\"myorders\"]")
 WebElement orderHistory;
 
 //By products=By.cssSelector(null)
 
 public void orderConfirmation()
 {
	 orderHistory.click();
 }

 public boolean historyCheck(String productName)
 {
	 boolean match =productTitle.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
 
     return match;
 }
 
}
