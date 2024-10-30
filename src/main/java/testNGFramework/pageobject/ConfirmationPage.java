package testNGFramework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	
	WebDriver driver;

	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	
	
	public ConfirmationPage(WebDriver driver) {

		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String confirmationPage()
	{
		
		return confirmationMessage.getText();
		
	}
	
	public void closePage()
	{
		driver.close();
	}

}
