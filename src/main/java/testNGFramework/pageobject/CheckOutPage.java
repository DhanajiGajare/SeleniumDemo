package testNGFramework.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testNGFramework.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;
	
	@FindBy(css="[placeholder*='Select Country']")
	WebElement country;
	
	
	@FindBy(xpath="//*[@class='ta-results list-group ng-star-inserted']/button[2]")
	WebElement selectCountry;
	
	
	@FindBy(xpath="//*[@class='btnn action__submit ng-star-inserted']")
	WebElement submit;
	
	
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToApper(By.cssSelector(".ta-results"));
		selectCountry.click();
		
	}
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		
		ConfirmationPage confirmationPage=new ConfirmationPage(driver);
		
		return confirmationPage;
	}
	
}
