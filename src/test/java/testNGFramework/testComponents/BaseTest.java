package testNGFramework.testComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import testNGFramework.pageobject.LandingPage;

public class BaseTest {
	
	
	public WebDriver driver;
	
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		  Properties prob=new Properties();
		  
		  
		  FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "/src/main/java/testNGFramework/resources/GlobalData.properties");
		 
		  prob.load(fis);
		
		  String broswerName=prob.getProperty("broswer");
		  
		 
		  if(broswerName.equalsIgnoreCase("chrome"))
		  {
		  
			  WebDriverManager.chromiumdriver().setup(); 
			  
			  driver=new ChromeDriver();
		  
		  }
		  else
		  {
			  System.out.println(broswerName);
		  }
	
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		return driver;
	
	}
		
	@BeforeMethod
	public LandingPage launchAppliaction() throws IOException
	{
		     driver =initializeDriver();
		
			 landingPage=new LandingPage(driver);
			  
			 landingPage.goTo();
			  
			  return landingPage;
			 	
	}
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	}
	 
	 

}
