package testNGFramework.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;



import testNGFramework.pageobject.CartPage;

public class AbstractComponent{
	
	WebDriver driver;
	
	@FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;
	
	By cartHeaderBy=By.cssSelector("[routerlink*='cart']");
	
    public AbstractComponent(WebDriver driver)
    {
    	
        this.driver=driver;
    	
    	PageFactory.initElements(driver, this);
	}

    
	public void waitForElementToApper(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void WaitForElementToDisappear(WebElement ele)
	{
		//stop execution for some time because of timer
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
	public CartPage goToCartPage()
	{
	
		cartHeader.click();
		
		CartPage cartPage=new CartPage(driver);
		
		return cartPage;
	   
		
	}
	
	
	
}
