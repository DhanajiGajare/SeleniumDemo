package testNGFramework.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends ProductCatelogue{
	  WebDriver driver;
	  
	 public LandingPage(WebDriver driver) {
			
		    super(driver);    
		 
		    this.driver=driver;
		    
		    PageFactory.initElements(driver, this);
		    	
			}
	    
	    @FindBy(id="userEmail")
	    WebElement email;
	    
	    @FindBy(id="userPassword")
	    WebElement password;
	    
	    
	    @FindBy(id="login")
	    WebElement submit;
	    
	
	   
	    
	    public ProductCatelogue loginApplication(String user,String pass)
	    {
	    	
	    	email.sendKeys(user);
	    	password.sendKeys(pass);
	    	submit.click();
	    	
	    	ProductCatelogue productCatelogue=new ProductCatelogue(driver);
	    	
	    	return productCatelogue;
	    	
	    	
	    }
	    
	    
	    
       
       public void goTo()
       {
    	   driver.get("https://rahulshettyacademy.com/client");
       }
		
	    
		
		
		
		

	}


